package com.ww.springboot.boot.old;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * @author wanwei
 * @TODO 计时器
 * @date: 2018年9月27日 下午4:57:10 
 */
public class Gettime extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	gettime time=new gettime();
	public Gettime(){
		add(time);
		Timer time =new Timer(1000,new gettimeListener());
		time.start();
	}
	public static void main(String[]args)
	{
		JFrame frame=new Gettime();
		frame.setTitle("move a circle");
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	class gettimeListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			time.move();	
		}
		
	}
	class gettime extends JPanel{
		private int s=0;
		private int S;
		private int m;
		private int h;
		public void move(){
			s++;
			repaint();
		}
		
		protected void paintComponent(Graphics g){
		    super.paintComponent(g);
		    S=s%60;
		    m=s/60%60;
		    h=s/3600%24;
		    g.drawString(String.valueOf(S), 100, 20);
		    g.drawString(":", 90, 20);
		    g.drawString(String.valueOf(m), 80, 20);
		    g.drawString(":", 70, 20);
		    g.drawString(String.valueOf(h), 60, 20);
		    
		}
		}
		
	} 
