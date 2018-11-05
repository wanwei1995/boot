package com.ww.springboot.boot.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.mapper.TempSoMapper;
import com.ww.springboot.boot.model.TempSo;
import com.ww.springboot.boot.service.TempSoService;

@Service
public class TempSoServiceImpl implements TempSoService {

	@Autowired
	private TempSoMapper tempSoMapper;
	@Override
	@Transactional
	public void makeData() {
		TempSo tempSo = tempSoMapper.findById(229365L);
		for(int i = 0; i<10000;i++){
			tempSo.setPlatformCode(tempSo.getLogisticsNo()+UUID.randomUUID().toString().substring(8));
			tempSo.setPlatformOrderCode(tempSo.getLogisticsNo()+UUID.randomUUID().toString().substring(8));
			tempSoMapper.insert(tempSo);
		}
		
	}
	
	

}
