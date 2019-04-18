package com.ww.springboot.boot.service.impl;

import java.io.File;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.mail.util.MailSSLSocketFactory;
import com.ww.springboot.boot.enumeration.ConfigEnum;
import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.service.ConfigService;
import com.ww.springboot.boot.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private ConfigService configService;

	@Override
	public void sendWeekly() {
		Address[] addresses = new Address[1];
		try {
			addresses[0] = new InternetAddress(configService.getValueForKey(ConfigEnum.EMAIL_RECIPIENT.getValue()));
			String filePath = "C:/Users/12548/Desktop/weekly/"+"万伟周报"+new SimpleDateFormat("YYYYMMdd").format(new Date())+".pptx";
			sendMail(addresses,new Address[0], "周报", "",filePath);
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}

	/**
	 * @author wanwei
	 * @TODO  带附件
	 * @date: 2018年9月13日 上午10:23:20
	 * @param addresses
	 * @param subject
	 * @param text
	 * @param path
	 * @throws Exception
	 */
	private void sendMail(Address[] addresses, Address[] addressesCC,String subject, String text,String filePath) throws Exception {
		Session s = getSession();

		// 设置session的调试模式，发布时取消
		// s.setDebug(true);
		MimeMessage mimeMessage = new MimeMessage(s);
		mimeMessage.setFrom(new InternetAddress(configService.getValueForKey(ConfigEnum.EMAIL_SENDER.getValue())));
		//收件人
		mimeMessage.addRecipients(Message.RecipientType.TO, addresses);
		if(addressesCC.length != 0){
			//抄送人
			mimeMessage.addRecipients(Message.RecipientType.CC, addressesCC);
		}
		// 设置邮件消息的主题
		mimeMessage.setSubject(subject);
		mimeMessage.setSentDate(new Date());

		// MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart multiPart = new MimeMultipart();
		// 创建一个包含HTML内容的MimeBodyPart
		BodyPart bodyPart = new MimeBodyPart();
		// 设置html邮件消息内容
		bodyPart.setContent(text, "text/html; charset=utf-8");
		multiPart.addBodyPart(bodyPart);
		// 添加附件
		bodyPart = new MimeBodyPart();
		File file = new File(filePath);
		if(file.exists() && file.length() == 0) {  
		    throw new BusinessException("未找到文件");
		}  
		FileDataSource fds = new FileDataSource(file); // 得到数据源
		bodyPart.setDataHandler(new DataHandler(fds)); // 得到附件本身并放入BodyPart
		bodyPart.setFileName(fds.getName()); // 得到文件名并编码（防止中文文件名乱码）同样放入BodyPart
		multiPart.addBodyPart(bodyPart);
		// 设置邮件消息的主要内容
		mimeMessage.setContent(multiPart);

		mimeMessage.saveChanges();
		// 发送
		Transport.send(mimeMessage);
	}
	
	
	/**
	 * @author wanwei
	 * @TODO 不带附件
	 * @date: 2018年9月13日 上午10:24:02
	 * @param addresses
	 * @param subject
	 * @param text
	 * @throws Exception
	 */
	private void sendMail(Address[] addresses, String subject, String text) throws Exception {
		Session s = getSession();

		// 设置session的调试模式，发布时取消
		// s.setDebug(true);
		MimeMessage mimeMessage = new MimeMessage(s);
		mimeMessage.setFrom(new InternetAddress(configService.getValueForKey(ConfigEnum.EMAIL_SENDER.getValue())));
		//发送人
		mimeMessage.addRecipients(Message.RecipientType.TO, addresses);
		//抄送人
		mimeMessage.addRecipients(Message.RecipientType.CC, addresses);
		// 设置邮件消息的主题
		mimeMessage.setSubject(subject);
		mimeMessage.setSentDate(new Date());
		mimeMessage.setText(text);
		mimeMessage.saveChanges();
		// 发送
		Transport.send(mimeMessage);
	}

	private Session getSession() throws GeneralSecurityException {
		Properties prop = new Properties();
		// 协议
		prop.setProperty("mail.transport.protocol", "smtp");
		// 服务器
		prop.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
		// 端口
		prop.setProperty("mail.smtp.port", "465");
		// 使用smtp身份验证
		prop.setProperty("mail.smtp.auth", "true");
		// 使用SSL，企业邮箱必需！
		// 开启安全协议
		MailSSLSocketFactory sf = null;
		sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);

		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);
		//
		// 获取Session对象
		Session s = Session.getInstance(prop, new Authenticator() {
			// 此访求返回用户和密码的对象
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication pa = new PasswordAuthentication(configService.getValueForKey(ConfigEnum.EMAIL_SENDER.getValue()), configService.getValueForKey(ConfigEnum.EMAIL_PASSWORD.getValue()));
				return pa;
			}
		});
		return s;
	}
}
