package com.ww.springboot.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanwei 
 * @TODO     超集判断算法:
 * 
 *           1:去除字符串重复字符
 *           2：统计字符串a字符个数进行比较
 *           3：遍历第二个字符，判断是否每个字符都在第一个字符中存在
 *           4：全部满足则是超集   否则不是
 *           
 *           
 *           时间复杂度 与空间复杂度与两个字符串重复字符个数有关
 *           
 *           时间复杂度 = 2*Ο(1)+Ο(n2)
 *           空间复杂度 = 2*Ο(1)+Ο(n2)
 *        
 *       
 * @date: 2019年2月13日 下午5:35:03 
 */
public class Superset {

	
	public static void main(String[] args) {
		
		String firstString = "abbccddefafaagag";
		String secondString = "abcddgadgh";
		System.out.println("a 是   b的超集 ： "+isSuperset(firstString,secondString) );
		
	}
	
	/**
	 * @author wanwei
	 * @TODO  超集条件 ： a包含b的所有字符，a包含的a的数量大于b
	 * @date: 2019年2月13日 下午5:38:38
	 * @param a
	 * @param b
	 * @return
	 */
	private static Boolean isSuperset(String firstString,String secondString){
		
		int firstANum = 0;
		
		int secondANum = 0;
		
		List<String> firstList = new ArrayList<>();
		
		List<String> secondList = new ArrayList<>();
		
		Map<Integer, Object>  firstMap = rmDuplicates(firstString);
		firstANum = (int) firstMap.get(0);
		firstList = (List<String>) firstMap.get(1);
		
		Map<Integer, Object>  secondMap = rmDuplicates(secondString);
		secondANum = (int) secondMap.get(0);
		secondList = (List<String>) secondMap.get(1);
		
		
		if(firstANum<secondANum){
			return false;
		}
		for(String secondS :secondList){
			Boolean flag = false;
			for(String firstS:firstList){
				//有相同的字符串则为true
				if(firstS.equals(secondS)){
					flag = true;
					break;
				}
			}
			//只要flag为false则第一个字符串中不包含第二个字符串中字符
			if(!flag){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @author wanwei
	 * @TODO  遍历字符串将字符串重复字符去除 ,并统计a字符个数
	 * @date: 2019年2月13日 下午5:54:40
	 * @param s
	 * @return
	 */
	private static Map<Integer, Object> rmDuplicates(String s){
		Map<Integer, Object> map = new HashMap<Integer, Object>();
		int aNum = 0;
		List<String> list = new ArrayList<>();
		//遍历字符串将字符串重复字符去除
		for (int i = 0; i < s.length(); i++) {
			char c=s.charAt(i);
			if(c == 'a'){
				aNum++;
			}
			Boolean haveFlag = true;
			for(String ss :list){
				if(ss.equals(String.valueOf(c))){
					haveFlag = false; 
					break;
				}
			}
			if(haveFlag){
				list.add(String.valueOf(c));
			}
			
		}
		map.put(0, aNum);
		map.put(1, list);
		return map;
	}
}
