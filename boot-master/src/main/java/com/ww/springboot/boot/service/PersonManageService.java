package com.ww.springboot.boot.service;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ww.springboot.boot.model.ExportMessageDto;
import com.ww.springboot.boot.model.PersonManage;

public interface PersonManageService {

	List<PersonManage> findList(PersonManage personManage);

	void save(PersonManage personManage);

	void deleteList(String ids);

	void update(PersonManage personManage);

	PersonManage findById(Long id);

	ExportMessageDto saveFromExcel(InputStream inputStream);

	void dataToExcel(HttpServletResponse response, PersonManage personManage);

}
