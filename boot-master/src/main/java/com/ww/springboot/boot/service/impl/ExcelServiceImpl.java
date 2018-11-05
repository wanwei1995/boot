package com.ww.springboot.boot.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.service.ExcelService;
import com.ww.springboot.boot.utils.ExcelUtil;

@Service
public class ExcelServiceImpl implements ExcelService{

	@Override
	public String ExcelToSql(InputStream in) {
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(in);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			throw new BusinessException(e.getMessage());
		}
		Sheet sheet = wb.getSheetAt(0);
		//获取excel行名称
		Map<Integer, String> nameMap = new HashMap<>();
		StringBuilder sql = new StringBuilder("insert into table_name (");
		int cellNum = sheet.getRow(0).getLastCellNum();
		for (int i = 0;i<cellNum;i++){
			nameMap.put(i, ExcelUtil.convertCellStr(sheet.getRow(0).getCell(i)));
			sql.append(ExcelUtil.convertCellStr(sheet.getRow(0).getCell(i)));
			sql.append(",");
		}
		//去掉最后一个 ，
		sql = new StringBuilder(sql.substring(0,sql.length() - 1));
		sql.append(")value(");
		StringBuilder totalSql = new StringBuilder();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			StringBuilder sqli = new StringBuilder(sql);
			for(int j = 0; j < cellNum; j++){
				//如果列值为空，则将插入语句中的头部去掉相依列名
				if(sheet.getRow(i).getCell(j) == null){
					String rowName = nameMap.get(j);
					sqli = new StringBuilder(sqli.toString().replace(","+rowName,""));
					continue;
				}
				if(sheet.getRow(i).getCell(j).getCellType() == 0)
				{
					sqli.append(ExcelUtil.convertCellStr(sheet.getRow(i).getCell(j)));
				}else{
					sqli.append(" ' ").append(ExcelUtil.convertCellStr(sheet.getRow(i).getCell(j))).append(" ' ");
				}
				sqli.append(",");
			}
			//去掉最后一个 ，
			sqli = new StringBuilder(sqli.substring(0,sqli.length() - 1));
			sqli.append(");");
			totalSql.append(sqli).append(" \r\n");
		}	
		return totalSql.toString();
	}

}
