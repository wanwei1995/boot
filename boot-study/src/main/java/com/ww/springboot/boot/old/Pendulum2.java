package com.ww.springboot.boot.old;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * @author wanwei
 * @TODO 钟摆
 * @date: 2018年9月27日 下午4:42:23 
 */
public class Pendulum2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	pendulum pend=new pendulum();
	public Pendulum2(){
		add(pend);
		Timer time =new Timer(100,new pendListener());
		time.start();
	}
	public static void main(String[]args){
		 JFrame frame=new Pendulum2();
		 frame.setTitle("钟摆");
		 frame.setSize(300, 300);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true); 
	 }
	class pendListener implements ActionListener{
	public void actionPerformed(ActionEvent arg0) {
			pend.move();
	}
	}
}
class pendulum extends JPanel{
	
	private int L=80;
	private double angle=0;
	public void move(){
		angle-=Math.PI/60;
		repaint();
	}
   protected void paintComponent(Graphics g){
	   super.paintComponent(g);
	   g.drawLine(getWidth()/2, getHeight()/4,getWidth()/2+(int)(Math.sin(angle)*L), getHeight()/4+(int)(Math.cos(angle)*L));
   }	
}