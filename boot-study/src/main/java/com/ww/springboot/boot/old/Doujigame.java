package com.ww.springboot.boot.old;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author wanwei
 * @TODO 豆鸡
 * @date: 2018年9月27日 下午4:42:54 
 */
public class Doujigame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Doujigame(){
		add(new composition());   
	}

	public static void main(String []args)
	{
	    JFrame frame =new Doujigame();
		frame.setTitle("doujigame");
		frame.setSize(500, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	static class composition extends JPanel{
		private int radius=250;
		private int radius2=150;
		private int radius3=250;
		private int radius4=150;
		private double []datax=new double[50];
		private double []datay=new double[50];
		private int m=0;
		private int n=0;
		public composition(){
			
		Timer timer =new Timer(10,new ballmoveListener());
		timer.start();
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			for(int i=0;i<7;i++)
			{
				g.drawLine(radius-20-10*i+10, radius2+20*i-20, radius-20-10*(i+1)+10, radius2+20*(i+1)-20);
				g.drawLine(radius+20+10*i-10, radius2+20*i-20, radius+20+10*(i+1)-10, radius2+20*(i+1)-20);
				for(int j=0;j<i+1;j++)
			      { if(j==0)
			      { g.setColor(Color.blue);
					g.drawOval(radius-5+20*j-10*i,radius2-5+20*i,10,10);
			      }
			      else
			      { g.setColor(Color.BLACK);
					g.drawOval(radius-5+20*j-10*i,radius2-5+20*i,10,10);
			      }  
					if(i==6)
						g.drawLine(radius-5+20*j-10*i+5,radius2-5+20*i+10,radius-5+20*j-10*i+5,radius2-5+20*i+200);
			      }
				
		
		    }
			g.drawLine(radius-20-10*7+10, radius2+20*7-20, radius-20-10*7+10, radius2+20*7+175);
			g.drawLine(radius+20+10*7-10, radius2+20*7-20, radius+20+10*7-10, radius2+20*7-20+195);
	        g.drawLine( radius-20-10*7+10, radius2+20*7+175, radius+20+10*7-10, radius2+20*7-20+195);
		    g.drawLine(radius-20+10, radius2-20, radius-20+10, radius2-20-30);
		    g.drawLine(radius+20-10, radius2-20,radius+20-10, radius2-20-30);
		    for(int i = 0;i<m;i++)
		    {
		    	for(int j=i-1;j>=0;j--)
		    	{
		    		if(datax[i]==datax[j])
		    		{
		    			datay[i]-=10;
		    			datax[j]+=0.01;	
		    		}
		    		
		    	}
		    g.setColor(Color.RED);
	    	g.drawOval((int)datax[i], (int)datay[i]-20, 10, 10);
		    }
		    if(m>=50)
			   {  String s="full";
				  g.drawString(s, 250, 550); 
			   }
		    else
		    {
		    
		    int a=(int)(Math.random()*2);
		    if(radius4<290)
		    {
		    if(a==0)
		    radius3-=10;
		    else
		    radius3+=10;
		    radius4+=20;
		    }
		    else 
		   { 
		    	if(radius4<470)
		       {
		    	radius4+=20;
		       }
		       else
		       {
			    datax[m]=radius3;
				datay[n]=radius4;
		    	
		    	radius3=250;
		    	radius4=150;
		    	m++;
		    	n++;
		       }
		   }
		}
		   
		    g.setColor(Color.RED);
			g.drawOval(radius3-5, radius4-5-20, 10, 10);
		}
		class ballmoveListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
	            repaint();	
	   }  
	  }
	 }
	}
	

