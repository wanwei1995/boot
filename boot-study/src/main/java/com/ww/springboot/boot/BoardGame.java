package com.ww.springboot.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wanwei
 * @TODO 棋盘游戏：
 * 
 * @date: 2019年2月13日 下午6:26:43
 */
public class BoardGame {

	// 棋盘
	private static String[][] matrix = { { "A", "R", "E" }, { "I", "P", "D" }, { "E", "L", "P" } };

	public static void main(String[] args) {

		String[] targets = { "ARE", "PENPIEAPPLE", "APPLEPEN", "APPLE", "LIPS", "RED", "AIR", "PLEASE" };
		StringBuilder isok = new StringBuilder("以下词可以被生成：");
		
		for (int i = 0; i < targets.length; i++) {
			String s = targets[i];
			
            int k = 0;
			char c = s.charAt(k);
			Boolean falg = true;
			while(falg){
				// 匹配棋盘的行数
				List<Integer> row = new ArrayList<>();
				// 行列坐标
				Map<Integer, Integer> coordinate = new HashMap<>();
				// 获取字符在棋盘中的坐标
				getPosition(String.valueOf(c),row,coordinate);
				// 获取下一步可能的所有字符将其与下一字符对比
				List<String> nextList = getNextList(row,coordinate);
				c = s.charAt(k+1);
				//判断下一个字符是否符合条件
				falg = judge(nextList,String.valueOf(c));	
				if(k+1 == s.length()-1){
					break;
				}
				k++;
			}
			if(falg){
				isok.append(s).append(",");
			}
		}
		
		System.out.println(isok);

	}

	private static Boolean judge(List<String> nextList, String str) {
		for(String s:nextList){
			if(s.equals(str)){
				return true;
			}
		}
		return false;
	}

	private static List<String> getNextList(List<Integer> row, Map<Integer, Integer> coordinate) {
		List<String> nextList = new ArrayList<>();
		
		for(Integer i :row){
			int j = coordinate.get(i);
			// i j 为行列坐标
			for(int ii = -1;ii<2;ii++){
				for(int jj = -1;jj<2;jj++){
					//获取周围的八个字符不能超过棋盘边界
					if(((i+ii)>-1 && (i+ii)<3)&&((j+jj)>-1 && (j+jj)<3)&& (ii != 0 || jj != 0)){
						Boolean flag = true;
						for (String s :nextList) {
							if(s.equals(matrix[i+ii][j+jj])){
								flag = false;
								break;
							}
						}
						if(flag){
							nextList.add(matrix[i+ii][j+jj]);
						}						
					}	
				}
			}	
		}
		return nextList;
	}

	private static void getPosition(String s,List<Integer> row,Map<Integer, Integer> coordinate) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (matrix[i][j].equals(s)) {
					// 将匹配的坐标保存
					row.add(i);
					coordinate.put(i, j);
				}
			}
		}
	}

}
