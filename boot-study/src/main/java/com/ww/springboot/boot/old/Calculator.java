package com.ww.springboot.boot.old;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author wanwei
 * @TODO 计算器
 * @date: 2018年9月27日 下午4:56:13 
 */
public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton jbt=new JButton("add");
	JButton jbt2=new JButton("subtract");
	JButton jbt3=new JButton("multiply");
	JButton jbt4=new JButton("divide");
	JTextField text=new JTextField(5);
	JTextField text2=new JTextField(5);
	JTextField text3=new JTextField(5);
	
	public Calculator(){
		
		JPanel panel=new JPanel();
		JPanel panel2=new JPanel();
		panel.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		panel.add(new JLabel("first numble"));
		panel.add(text);
		panel.add(new JLabel("next numble"));
		panel.add(text2);
		panel.add(new JLabel("result"));
		panel.add(text3);
		panel2.add(jbt);
		panel2.add(jbt2);
		panel2.add(jbt3);
		panel2.add(jbt4);
		setLayout(new GridLayout(2,1,5,5));
		this.add(panel);
		this.add(panel2);
		jbt.addActionListener(new jbtlistener());
		jbt2.addActionListener(new jbtlistener2());
		jbt3.addActionListener(new jbtlistener3());
		jbt4.addActionListener(new jbtlistener4());
	}
      public static void main(String[]args){
    	  
    	  JFrame frame =new Calculator();
    	  frame.setTitle("calculator");
    	  frame.setSize(500, 100);
    	  frame.setLocationRelativeTo(null);
    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  frame.setVisible(true);  
      }   
   class jbtlistener implements ActionListener{
	   public void actionPerformed(ActionEvent e){
		   double first=Double.parseDouble(text.getText());
		   double next=Double.parseDouble(text2.getText());
		   double add=first+next;
		   String s=String.valueOf(add);
		   text3.setText(s);   
	   }
   }
   class jbtlistener2 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
		   double first=Double.parseDouble(text.getText());
		   double next=Double.parseDouble(text2.getText());
		   double add=first-next;
		   String s=String.valueOf(add);
		   text3.setText(s);   
	   }
   }
   class jbtlistener3 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
		   double first=Double.parseDouble(text.getText());
		   double next=Double.parseDouble(text2.getText());
		   double add=first*next;
		   String s=String.valueOf(add);
		   text3.setText(s);   
	   }
   }
   class jbtlistener4 implements ActionListener{
	   public void actionPerformed(ActionEvent e){
		   double first=Double.parseDouble(text.getText());
		   double next=Double.parseDouble(text2.getText());
		   double add=first/next;
		   String s=String.valueOf(add);
		   text3.setText(s);   
	   }
   }
}
