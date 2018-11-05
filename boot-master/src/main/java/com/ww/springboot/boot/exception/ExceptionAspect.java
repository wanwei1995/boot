package com.ww.springboot.boot.exception;

import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Aspect
@Component("exceptionAspect")
public class ExceptionAspect {
	public static String ATTRIBUTE_EXCEPTION_RESULT = "resultMsg";
	public static String ATTRIBUTE_EXCEPTION_TYPE = "msgType";
	public static String ATTRIBUTE_EXCEPTION_ERROR = "error";
	public static String ATTRIBUTE_SUCCESS = "success";
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("@annotation(com.ww.springboot.boot.exception.MyExceptionInterceptor)")
	public void exceptionAroundPointCut() {
	}

	@Around("exceptionAroundPointCut()")
	public Object atdcAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		String viewName = this.getViewName(pjp);

		try {
			result = pjp.proceed();
		} catch (Exception arg11) {
			Exception e = arg11;
			if (!(arg11 instanceof BusinessException)) {
				this.logger.error(pjp.getTarget().getClass() + "." + pjp.getSignature().getName(), arg11);
				throw arg11;
			}

			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			ServletRequestAttributes sra = (ServletRequestAttributes) ra;
			HttpServletRequest request = sra.getRequest();
			HttpServletResponse response = sra.getResponse();
			Object returnObject = this.getReturnType(pjp);
			Object[] objects;
			int i;
			ModelAndView arg13;
			if (this.isAjax(request)) {
				if (String.class.equals(returnObject)) {
					objects = pjp.getArgs();

					for (i = 0; i < objects.length; ++i) {
						if (objects[i] instanceof ModelMap) {
							((ModelMap) objects[i]).addAttribute(ATTRIBUTE_EXCEPTION_RESULT, arg11.getMessage());
							((ModelMap) objects[i]).addAttribute(ATTRIBUTE_EXCEPTION_TYPE, ATTRIBUTE_EXCEPTION_ERROR);
							response.setStatus(500);
							String arg12 = "base/layout :: message";
							return arg12;
						}
					}
				} else if (ModelAndView.class.equals(returnObject)) {
					arg13 = new ModelAndView("base/layout :: message");
					((ModelAndView) arg13).addObject(ATTRIBUTE_EXCEPTION_RESULT, arg11.getMessage());
					((ModelAndView) arg13).addObject(ATTRIBUTE_EXCEPTION_TYPE, ATTRIBUTE_EXCEPTION_ERROR);
					response.setStatus(500);
					return arg13;
				}
			} else {
				if (String.class.equals(returnObject)) {
					if (viewName.startsWith("redirect")) {
						objects = pjp.getArgs();

						for (i = 0; i < objects.length; ++i) {
							if (objects[i] instanceof RedirectAttributes) {
								((RedirectAttributes) objects[i]).addFlashAttribute(ATTRIBUTE_EXCEPTION_RESULT,
										e.getMessage());
								((RedirectAttributes) objects[i]).addFlashAttribute(ATTRIBUTE_EXCEPTION_TYPE,
										ATTRIBUTE_EXCEPTION_ERROR);
							}
						}
					} else {
						objects = pjp.getArgs();

						for (i = 0; i < objects.length; ++i) {
							if (objects[i] instanceof ModelMap) {
								((ModelMap) objects[i]).addAttribute(ATTRIBUTE_EXCEPTION_RESULT, e.getMessage());
								((ModelMap) objects[i]).addAttribute(ATTRIBUTE_EXCEPTION_TYPE,
										ATTRIBUTE_EXCEPTION_ERROR);
							}
						}
					}

					return viewName;
				}

				if (ModelAndView.class.equals(returnObject)) {
					arg13 = new ModelAndView(viewName);
					if (viewName.startsWith("redirect")) {
						objects = pjp.getArgs();

						for (i = 0; i < objects.length; ++i) {
							if (objects[i] instanceof RedirectAttributes) {
								((RedirectAttributes) objects[i]).addFlashAttribute(ATTRIBUTE_EXCEPTION_RESULT,
										e.getMessage());
								((RedirectAttributes) objects[i]).addFlashAttribute(ATTRIBUTE_EXCEPTION_TYPE,
										ATTRIBUTE_EXCEPTION_ERROR);
							}
						}
					} else {
						((ModelAndView) arg13).addObject(ATTRIBUTE_EXCEPTION_RESULT, arg11.getMessage());
						((ModelAndView) arg13).addObject(ATTRIBUTE_EXCEPTION_TYPE, ATTRIBUTE_EXCEPTION_ERROR);
					}

					return arg13;
				}
			}
		}

		return result;
	}

	boolean isAjax(HttpServletRequest request) {
		return request.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString());
	}

	private String getViewName(ProceedingJoinPoint pjp) throws Exception {
		Method currentMethod = this.getMethod(pjp);
		MyExceptionInterceptor interceptor = (MyExceptionInterceptor) currentMethod
				.getAnnotation(MyExceptionInterceptor.class);
		String viewName = "";
		if (interceptor != null) {
			viewName = interceptor.value();
		}

		return viewName;
	}

	private Object getReturnType(ProceedingJoinPoint pjp) throws Exception {
		Method currentMethod = this.getMethod(pjp);
		return currentMethod.getReturnType();
	}

	private Method getMethod(ProceedingJoinPoint pjp) throws Exception {
		Signature sig = pjp.getSignature();
		MethodSignature msig = null;
		if (!(sig instanceof MethodSignature)) {
			throw new IllegalArgumentException("该注解只能用于方法");
		} else {
			msig = (MethodSignature) sig;
			Object target = pjp.getTarget();
			Method currentMethod = target.getClass().getDeclaredMethod(msig.getName(), msig.getParameterTypes());
			return currentMethod;
		}
	}
}