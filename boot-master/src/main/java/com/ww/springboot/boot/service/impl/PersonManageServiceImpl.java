package com.ww.springboot.boot.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.exception.BusinessException;
import com.ww.springboot.boot.mapper.PersonManageMapper;
import com.ww.springboot.boot.model.ExportMessageDto;
import com.ww.springboot.boot.model.PersonManage;
import com.ww.springboot.boot.service.PersonManageService;
import com.ww.springboot.boot.utils.ExcelUtil;

@Service
public class PersonManageServiceImpl implements PersonManageService {

	@Autowired
	private PersonManageMapper personManageMapper;

	@Override
	public List<PersonManage> findList(PersonManage personManage) {
		return personManageMapper.findList(personManage);
	}

	@Transactional
	public void save(PersonManage personManage) {
		personManage.setCreateBy("admin");
		personManage.setCreateTime(new Date());
		personManageMapper.save(personManage);
	}

	@Transactional
	public void deleteList(String ids) {
		String[] data = ids.split(",");
		personManageMapper.deleteList(data);

	}

	@Transactional
	public void update(PersonManage personManage) {
		personManage.setUpdateBy("admin");
		personManage.setUpdateTime(new Date());
		personManageMapper.update(personManage);
	}

	@Override
	public PersonManage findById(Long id) {
		// TODO Auto-generated method stub
		return personManageMapper.findById(id);
	}

	@Override
	@Transactional
	public ExportMessageDto saveFromExcel(InputStream in) {
		StringBuilder existRow = new StringBuilder();
		StringBuilder errorRow = new StringBuilder();
		StringBuilder errorMessage = new StringBuilder();
        PersonManage personManage = new PersonManage();
		ExportMessageDto exportMessageDTO = new ExportMessageDto();
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(in);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			throw new BusinessException(e.getMessage());
		}
		Sheet sheet = wb.getSheetAt(0);
		// 仓库 运力区域 规则配送商 平台 优先级 是否启用 创建时间 创建人 备注
		for (int i = 2; i <= sheet.getLastRowNum(); i++) {
			String personName = ExcelUtil.convertCellStr(sheet.getRow(i).getCell(0));
			String status = ExcelUtil.convertCellStr(sheet.getRow(i).getCell(1));
            //判断状态是否正常
			
			//存入数据库
			personManage.setPersonName(personName);
			personManage.setStatus(Integer.valueOf(status));
			personManageMapper.save(personManage);
		}
			exportMessageDTO
					.setErrorRow(errorRow.length() > 0 ? errorRow.substring(0, errorRow.length() - 1).toString() : "");
			exportMessageDTO
					.setExistRow(existRow.length() > 0 ? existRow.substring(0, existRow.length() - 1).toString() : "");
			exportMessageDTO.setRemark(errorMessage.toString());
			return exportMessageDTO;
		}

	/**
     * 
     * @Description: 导出所查询的到excel表格
     * @date :2017年11月24日
     * @return:void
     */
    public void dataToExcel(HttpServletResponse response, PersonManage filer){
        // 声明一个工作簿
        Workbook workbook = new SXSSFWorkbook(1000);// 内存中保留 1000
                                                    // 条数据，以免内存溢出，其余写入 硬盘
        try {
            // 创建一个表格
            Sheet sheet = workbook.createSheet();
            // 表头
            Row headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("人名");
            headRow.createCell(1).setCellValue("状态");
            List<PersonManage> list = findList(filer);
            for (int i = 0; i < list.size(); i++) {
            	PersonManage personManage = list.get(i);
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(personManage.getPersonName());
                row.createCell(1).setCellValue(personManage.getStatus());  
            }
            response.setContentType("application/octet-stream");
            // 默认Excel名称
            response.setHeader("Content-disposition", "attachment;filename=person.xlsx");
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        }catch(Exception e){
        	throw new BusinessException(e.getMessage());
        } 
        finally {
            try {
				workbook.close();
			} catch (IOException e) {
				throw new BusinessException("文档关闭失败");
			}
        }
    }
}
