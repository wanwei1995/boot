package com.ww.springboot.boot.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author wanwei
 * @TODO 击球
 * @date: 2018年9月27日 下午4:42:43 
 */
public class Hitbool extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbt=new JButton("Left");
	private JButton jbt2=new JButton("Right");
	private JButton jbt3=new JButton("hit");
	private JButton jbt4=new JButton("refresh");
	hitbool hit=new hitbool();
	
	public Hitbool(){
	 JPanel panel=new JPanel();
	 panel.setLayout(new FlowLayout());
	 panel.add(jbt);
	 panel.add(jbt2);
	 panel.add(jbt3);
	 panel.add(jbt4);
	 add(hit);
	 add(panel,BorderLayout.SOUTH);
	
	 jbt.addActionListener(new jbtListerer());
	 jbt2.addActionListener(new jbtListerer2());
	 jbt3.addActionListener(new jbtListerer3());
	 jbt4.addActionListener(new jbtListerer5());
	 Timer time=new Timer(100,new jbtListerer4());
	 time.start();
	}
    
	public static void main(String[]args){
		
		JFrame frame=new Hitbool();
		frame.setTitle("exercise");
		frame.setSize(350, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	class jbtListerer implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			hit.move();
		}
		
	}
	class jbtListerer2 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			hit.move2();
		}
		
	}
	class jbtListerer3 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			hit.move3();
		}
		
	}
	class jbtListerer4 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			hit.move4();
		}
		
	}
	class jbtListerer5 implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			hit.move5();
		}
		
	}
	class hitbool extends JPanel{
		private int Length=50;
		private int i=18;
		private int radius=0;
		int x=0;
		int y=0;
		private int k=0;
		private int j=0;
		public void move(){
			i++;
			repaint();
		}
		public void move2(){
			i--;
			repaint();
		}
		public void move3(){
			radius+=10;
			repaint();
			
		}
		public void move4(){
			if(radius!=0)
				{
				radius+=20;
			    repaint();
			    }
		}
		public void move5(){
			
			k=0;
			repaint();
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			if(k==0)
			{
				 x=(int)(Math.random()*301);
				 y=(int)(Math.random()*301);
				 k++;
			}
			
			int xcenter=getWidth();
			int ycenter=getHeight();
			int a=20;
			int m=(xcenter/2+(int)(Math.cos(Math.PI/36*i)*Length))+(int)(radius*(Math.cos(Math.PI/36*i)));
			int n=(ycenter-50-(int)(Math.sin(Math.PI/36*i)*Length))-(int)(radius*(Math.sin(Math.PI/36*i)));
			int j1=(m-x-16)*(m-x-16)+(n-y-16)*(n-y-16);
			if(j1<196)
			{
				a=0;
				radius=0;
				g.setColor(Color.RED);
				g.drawString("the bool is hit!", x+20, y+20);	
			}
			if(k==1&&j1<196)
			{
				j++;
			}
			String s=String.valueOf(j);
			g.drawString("the number is:" , 220, 400);
			g.setColor(Color.RED);
			g.drawString(s, 300, 400);
			g.setColor(Color.BLACK);
			if(m<0||n<0)
			{
				radius=0;
				g.setColor(Color.RED);
				g.drawString("please again!", 250, 350);
				
			}
			
			g.drawLine(xcenter/2,ycenter-50,xcenter/2+(int)(Math.cos(Math.PI/36*i)*Length),ycenter-50-(int)(Math.sin(Math.PI/36*i)*Length));
			g.drawLine(xcenter/2+8,ycenter-50,xcenter/2+(int)(Math.cos(Math.PI/36*i)*Length)+8,ycenter-50-(int)(Math.sin(Math.PI/36*i)*Length));
			g.drawOval(x+10, y+10,  a, a);
			g.drawOval((xcenter/2+(int)(Math.cos(Math.PI/36*i)*Length))+(int)(radius*(Math.cos(Math.PI/36*i))),(ycenter-50-(int)(Math.sin(Math.PI/36*i)*Length))-(int)(radius*(Math.sin(Math.PI/36*i))),8,8);
		   
		}
		
	}
}
