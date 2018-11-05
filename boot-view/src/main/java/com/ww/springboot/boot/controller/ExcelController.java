package com.ww.springboot.boot.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.service.ExcelService;

@Controller
@RequestMapping("excel")
public class ExcelController {

	@Autowired
	private ExcelService excelService;

	@RequestMapping("")
	public String index() {

		return "excel/list";
	}

	/**
	 * 请求导入文件
	 * 
	 * @date :2017年9月8日
	 * @return:String
	 */
	@RequestMapping("/upload")
	public String upload(Model model) {
		return "excel/upload";
	}

	/**
	 * excel导入数据库
	 * 
	 * @date :2017年9月8日
	 * @return:String
	 */
	@RequestMapping(value = "/createFromExcel", method = RequestMethod.POST)
	@ResponseBody
	public void createFromExcel(@RequestParam MultipartFile myFileName, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirectAttributes, RedirectAttributes attrs) {
		OutputStream out = null;
		FileInputStream in = null;
		File f = null;
		try {
			String result = excelService.ExcelToSql(myFileName.getInputStream());
			f = new File("C:\\data\\a.txt");
			FileWriter fw = null;
			BufferedWriter bw = null;

			f.createNewFile();
			fw = new FileWriter(f.getAbsoluteFile(), true); // true表示可以追加新内容
			// fw=new FileWriter(f.getAbsoluteFile()); //表示不追加
			bw = new BufferedWriter(fw);
			bw.write(result);
			bw.close();
			response.setContentType("application/octet-stream");// 告诉浏览器输出内容为流
			response.addHeader("Content-Disposition", "attachment;filename=SQL.txt");// Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
			String len = String.valueOf(f.length());
			response.setHeader("Content-Length", len);// 设置内容长度
			out = response.getOutputStream();
			in = new FileInputStream(f);
			byte[] b = new byte[1024];
			int n;
			while ((n = in.read(b)) != -1) {
				out.write(b, 0, n);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		} finally {
			try {
				in.close();
				out.close();
				f.delete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
