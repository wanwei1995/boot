package com.ww.springboot.boot.old;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @author wanwei
 * @TODO 画板
 * @date: 2018年9月27日 下午4:58:37 
 */
public class FigurePanel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbt1=new JButton("Line");
	private JButton jbt2=new JButton("Rectangle");
	private JButton jbt3=new JButton("Oval");
	private JButton jbt4=new JButton("Filled");
	private diagram diagram=new diagram();
	public FigurePanel(){
		JPanel panel1 =new JPanel();
		panel1.add(jbt1);
		panel1.add(jbt2);
		panel1.add(jbt3);
		panel1.add(jbt4);
		add(panel1,BorderLayout.SOUTH);
		add(diagram);
		jbt1.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				diagram.change1();
			}
		});
		jbt2.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				diagram.change2();
			}
		});
		jbt3.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				diagram.change3();
			}
		});
		jbt4.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				diagram.change4();
			}
		});
	}
public static void main(String []args){
		
		JFrame frame=new FigurePanel();
		frame.setTitle("Exercise");
		frame.setSize(400,300 );
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

class diagram extends JPanel{
	int a[]={10,10,40,40};
	int b[]={10,40,40,10};
	private int type=0;
	private boolean Filled=false;
	public void change1(){
		type=1;
		repaint();
	}
    public void change2(){
		type=2;
		repaint();
	}
    public void change3(){
	     type=3;
	     repaint();
    }
    public void change4(){
	     Filled=!Filled;
	     repaint();
    }
	protected void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(Color.green);
	g.fillPolygon(a,b,4);
		switch(type){
		case 0:g.drawString("NO PAINT!!",200,150);break;
		case 1:g.drawLine(10, 10, getWidth()/2, getHeight()/2);break;
		case 2:if(Filled)
			   g.fillRect(10, 10,  getWidth()/2, getHeight()/2);
		       else
		       g.drawRect(10, 10,  getWidth()/2, getHeight()/2);break;
		case 3:if(Filled)
			   g.fillOval(10, 10,  getWidth()/2, getHeight()/2);
	          else
	           g.drawOval(10, 10,  getWidth()/2, getHeight()/2);break;
	  }
	}	
  }
}
