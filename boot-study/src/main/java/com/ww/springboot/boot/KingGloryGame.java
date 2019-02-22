package com.ww.springboot.boot;
import java.util.Stack;

/**
 * @author wanwei
 * @TODO 王者荣耀小游戏： 深度优先搜索：对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次
 *       默认先往右走，可以走则继续，不行则往下走，再不行则退一步判断是右还是下；
 *       直到到达（9,9）或者回到（0,0）：到达（9,9）说明可以走通则游戏成功结束循环，回到（0,0）说明此血量无法走通
 *       
 *       实现方法：
 *       使用一个栈记录路径，另一个栈记录上一坐标血量，以便坐标回退时血量也一起回退
 *        
 * @date: 2019年2月14日 下午2:08:00
 */
public class KingGloryGame {

	// 队列 ：后进先出 （记录行进路径）
	static Stack<Integer> stackPath;
	// 队列 ：后进先出  （记录血量）
	static Stack<Integer> stackBlood;
	
	//上一坐标血量
	static int lastBlood;
	
	static int x;
	
	static int y;
	
	static int current;
	
	// 起点 (0,0)终点(9,9) ??不懂为什么起点还有加血 ：默认为血量已达到上限加血无效
	static int[][] map = { { 133, -523, -558, 846, -907, -1224, -1346, 787, -411, -1826 },
			{ -1478, -853, -1401, 341, -26, 759, -444, 174, -1594, -2000 },
			{ 861, -584, 670, 696, 676, -1674, -1737, -1407, -484, 248 },
			{ 458, -1669, -419, -382, -895, 732, -1278, -1802, -527, 862 },
			{ -1297, -544, -1943, 563, -380, -1268, 266, -1309, -1946, 85 },
			{ -1981, -1631, -168, 741, -211, -1070, -1873, -554, 243, -901 },
			{ 849, 971, -21, -1111, 463, 944, -124, -1414, -1463, -1287 },
			{ 70, -1886, -1159, -73, 555, -426, -190, -1750, -1028, -188 },
			{ -1220, -1654, -931, -1100, -433, -1643, -1281, -455, 904, -126 },
			{ -1494, -632, 243, 90, 993, 322, 32, -388, -225, 952 }};

	public static void main(String[] args) {

		int[] initial = {100, 1000, 2000, 5000, 10000};

		for (int i = 0; i < initial.length; i++) {
			stackPath = new Stack<Integer>();
			// 队列 ：先进先出 （记录血量）
			stackBlood = new Stack<Integer>();
			// 开始游戏
			if(startGame(initial[i])){
				//找到最佳的就结束游戏
				break;
			}
		}

	}

	private static Boolean startGame(int max) {

		lastBlood = 0;
		// 当前生命
		current = max;
		//记录血量
		stackBlood.add(current);
		// 初始坐标
		x = 0;
		y = 0;
		// 游戏只能向右或者向下,一次一步 : 0代表右，1代表下
		int k = 0;
		Boolean flag = true;
		while (true) {
			//System.out.println(String.valueOf(current)+" " + String.valueOf(x) +" "+ String.valueOf(y));
			//判断下一步是否可走
			Boolean next = update(k,max);
			if(!next){
				if(k == 0){
					k = 1;
				}else{
					//回退一步并判断上一步是右还是下
					int last = 1;
					//上一步为右则退一步往下走
					while(last == 1){
						if(stackPath.size() == 0&& k == 1){
							//这种情况则说明已经退回原点，则此游戏结束 ：失败
							flag = false;
							break;
						}
						//一直取直到为0
						last = stackPath.pop();
						if(last == 0){
							//坐标往左退
							y--;	
						}else{
							//坐标往上退
							x--;
						}
						//每取一次还原一次血量
						current = stackBlood.pop();
						
					}
					if(last == 0){
						//如果取出0，则让其往下走 
						k = 1;	
					}
					
				}
			}else{
				//可走则将其保存起来
				stackPath.add(k);
				stackBlood.add(lastBlood);
				//方向重新调整为右
				k = 0;
			}
			if(!flag){
				break;
			}
			
			if(x == 9 && y== 9){
				//到达终点
				flag = true;
				break;
			}
		}
		if (flag) {
			StringBuilder sb = new StringBuilder("英雄为：");
			switch(max){
			case 100: sb.append("狄仁杰 ");
			  break;
			case 1000: sb.append("凯 ");
	          break;
			case 2000: sb.append("亚瑟 ");
	          break;
			case 5000: sb.append("程咬金 ");
	          break;
			case 10000: sb.append("梦琪 ");
	          break;
			}
			sb.append("最低血量为：" + max +"路径为：");
			// 打印queue
			while(stackPath.size() > 0) {
				int path = stackPath.pop();
				if(path == 0){
					sb.append("右->");
				}else{
					sb.append("下->");
				}
			}
			System.out.println(sb);
		}
		return flag;
	}

	//判断是否可以走
	private static Boolean update(int k,int max) {
		
		Boolean result = true;
		int currentNew = current;
		lastBlood = current;
		if(k == 0){
			y++;
		}else{
			x++;
		}
		if(y>9 || x>9){
			result = false;
		}
		if(result){
			currentNew = currentNew + map[x][y];
			if(currentNew>max){
				currentNew = max;
			}
			if(currentNew <=0){
				result = false;
			}
		}
		if(!result){
			//不能走通则将改变的坐标还原回去
			if(k == 0){
				y--;
			}else{
				x--;
			}	
		}else{
			//可以走通才将血量更新
			current = currentNew;
		}
		return result;
	}
}
