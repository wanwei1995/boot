package com.ww.springboot.boot.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 * @author wanwei
 * @TODO   图形化界面基础
 * @date: 2018年9月27日 下午4:43:56 
 */
public class NewMassage extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbt1=new JButton("<=");
	private JButton jbt2=new JButton("=>");
	private JPanel panel=new JPanel();
	ButtonGroup bg=new ButtonGroup();
	
	private JRadioButton red=new JRadioButton("Red");
	private JRadioButton yellow=new JRadioButton("Yellow");
	private JRadioButton white=new JRadioButton("White");
	private JRadioButton gray=new JRadioButton("Gray");
	private JRadioButton green=new JRadioButton("Green");
	
	protected MessagePanel massage=new MessagePanel();
	private TitledBorder Title=new TitledBorder("Select Massage Panel Background");
	public NewMassage(){
		panel.setLayout(new GridLayout());
		panel.add(red);
		panel.add(yellow);
		panel.add(gray);
		panel.add(green);
		panel.add(white);
		panel.setBorder(Title);
		add(panel,BorderLayout.NORTH);
		JPanel panel2=new JPanel();
		add(massage);
		panel2.add(jbt1);
		panel2.add(jbt2);
		add(panel2,BorderLayout.SOUTH);
		jbt1.addActionListener(new jbt1Listener());
		jbt2.addActionListener(new jbt2Listener());
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				massage.setBackground(Color.RED);
				repaint();
			}
		});
		yellow.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				massage.setBackground(Color.yellow);
				repaint();
			}
		});
		gray.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				massage.setBackground(Color.gray);
				repaint();
			}
		});
		green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				massage.setBackground(Color.GREEN);
				repaint();
			}
		});
		white.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				massage.setBackground(Color.WHITE);
				repaint();
			}
		});
		
		
	}
	class jbt1Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			massage.move1();
		}
	}
	class jbt2Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			massage.move2();
		}
	}
public static void main(String []args){
		
		JFrame frame=new NewMassage();
		frame.setTitle("newflowlayout");
		frame.setSize(350, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class MessagePanel extends JPanel{
	private int radius=0;
	public void move1(){
		radius-=10;
		repaint();
	}
	public void move2(){
		radius+=10;
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("Welcome to java", getWidth()/2-50+radius, getHeight()/2);
	}
}


