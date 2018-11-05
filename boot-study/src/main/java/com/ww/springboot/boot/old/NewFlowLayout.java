package com.ww.springboot.boot.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * @author wanwei
 * @TODO  页面布局
 * @date: 2018年9月27日 下午4:45:11 
 */
public class NewFlowLayout extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlabel1=new JLabel("Display the border type",JLabel.CENTER);
	private JCheckBox jchkTitled;
	private JRadioButton jrbLoweredBevel,jrbRaisedBevel,jrbEtched,jrbline,jrbMatte,jrbEmpty;
	private JRadioButton jrbAboveBottom,jrbBottom,jrbBelowBottom,jrbAboveTop,jrbTop,jrbBelowTop,jrbLeft,jrbCenter,jrbRight;
	private TitledBorder JLabel1Border=new TitledBorder("!!!!!");
	public NewFlowLayout()
	{   
	
		jlabel1.setBackground(Color.YELLOW);
		jlabel1.setBorder(JLabel1Border);
		Border border=new BevelBorder(BevelBorder.LOWERED,Color.RED,Color.blue);
		jlabel1.setText("!!!!!!");
		jlabel1.setBorder(border);
		
		JPanel jpanel1=new JPanel();
		jpanel1.setLayout(new GridLayout(3,2));
		jpanel1.add(jrbAboveBottom= new JRadioButton("Above Botton"));
		jpanel1.add(jrbAboveTop= new JRadioButton("Above top"));
		jpanel1.add(jrbBottom= new JRadioButton("Botton"));
		jpanel1.add(jrbTop= new JRadioButton("top"));
		jpanel1.add(jrbBelowBottom= new JRadioButton("Below Botton"));
		jpanel1.add(jrbBelowTop= new JRadioButton("Below top"));
		jpanel1.setBorder(new TitledBorder("Position"));
		add(new JLabel("Good!",JLabel.CENTER),BorderLayout.NORTH);
		add(jlabel1,BorderLayout.CENTER);
		add(jpanel1,BorderLayout.SOUTH);
		
	}
	
	
	
	public static void main(String []args){
		
		JFrame frame=new NewFlowLayout();
		frame.setTitle("newflowlayout");
		frame.setSize(350, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
}
