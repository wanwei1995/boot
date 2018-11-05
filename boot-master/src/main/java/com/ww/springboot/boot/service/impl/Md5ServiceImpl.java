package com.ww.springboot.boot.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ww.springboot.boot.mapper.Md5Mapper;
import com.ww.springboot.boot.model.Md5;
import com.ww.springboot.boot.service.Md5Service;
import com.ww.springboot.boot.utils.MD5Util;

@Service
public class Md5ServiceImpl implements Md5Service {

	private static String[] num = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	@Autowired
	private Md5Mapper md5Mapper;

	/**
	 * @author wanwei
	 * @TODO 首字母大写
	 * @date: 2018年9月29日 下午6:08:42
	 */
	@Override
	@Transactional
	public void MakeData() {
		Md5 md5 = new Md5();
		for (String s : Arrays.asList(num)) {
			for (String ss : Arrays.asList(num)) {
				for (String sss : Arrays.asList(num)) {
					for (String ssss : Arrays.asList(num)) {
						for (String sssss : Arrays.asList(num)) {
							for (String ssssss : Arrays.asList(num)){
								for (String sssssss : Arrays.asList(num)) {
									String a = new StringBuilder().append(s).append(ss).append(sss).append(ssss)
											.append(sssss).append(ssssss).append(sssssss).toString();
									md5.setText(a);
									md5.setCipherText(MD5Util.md5Hex(a));
									md5Mapper.insert(md5);
								}
							}
						}
					}
				}
			}
		}
	}
}
