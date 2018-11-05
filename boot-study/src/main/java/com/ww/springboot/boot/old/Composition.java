package com.ww.springboot.boot.old;
import javax.swing.*;
import java.util.Scanner;
import java.awt.event.*;
import java.awt.*;
/**
 * @author wanwei
 * @TODO 迷宫
 * @date: 2018年9月27日 下午4:49:34 
 */
public class Composition extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbt=new JButton("gethinder");
	private JButton jbt2=new JButton("moveup");
	private JButton jbt3=new JButton("movedown");
	private JButton jbt4=new JButton("moveleft");
	private JButton jbt5=new JButton("moveright");
	private NewPanel canvas=new NewPanel();
	public Composition(){
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		add(canvas);
		panel.add(jbt);
		panel.add(jbt2,BorderLayout.NORTH);
		panel.add(jbt3,BorderLayout.SOUTH);
		panel.add(jbt4,BorderLayout.WEST);
		panel.add(jbt5,BorderLayout.EAST);
		add(panel,BorderLayout.SOUTH);
		jbt.addActionListener(new jbtListener());
		jbt2.addActionListener(new jbtListener2());
		jbt3.addActionListener(new jbtListener3());
		jbt4.addActionListener(new jbtListener4());
		jbt5.addActionListener(new jbtListener5());
	}

	
	
	public static void main(String[]args){
		JFrame frame=new Composition();
		frame.setTitle("Composition");
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

class jbtListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		int[]datax=new int[400];
		int[]datay=new int[400];
		Scanner input =new Scanner(System.in);
		System.out.print("Enter numbers of x:");
		for(int i=0;i<10;i++)
		{
			datax[i]=input.nextInt();	
		}
		System.out.print("Enter numbers of y:");
		for(int j=0;j<10;j++)
		{
			datax[j]=input.nextInt();	
		}
		
		canvas.move(datax,datay);
	}
}
class jbtListener2 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		canvas.move2();
	}
}
class jbtListener3 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		canvas.move3();
	}
}
class jbtListener4 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		canvas.move4();
	}
}
class jbtListener5 implements ActionListener{
	public void actionPerformed(ActionEvent e){
		canvas.move5();
	}
}
class NewPanel extends JPanel{
	
	private int[]i1=new int[400];int[]j1=new int[400];
	private int i2=0,j2=0;
	public void move(int datax[],int datay[]){
		
		System.arraycopy(datax,0,i1,0,datax.length);
		System.arraycopy(datay,0,j1,0,datay.length);
		repaint();
	}
	public void move2(){
		j2-=1;
		repaint();
	}
	public void move3(){
		j2+=1;
		repaint();
	}
	public void move4(){
		i2-=1;
		repaint();
	}
	public void move5(){
		i2+=1;
		repaint();
	}
	
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for( int i=0;i<20;i++)
			for( int j=0;j<20;j++)
			{   
				  g.drawRect(10*i,10*j,10,10);
			}
		int x=0;
		int y=0;
		for( int i=0;i<20;i++)
			for( int j=0;j<20;j++)
			{   
				if(i==i1[x]-1&&j==j1[y]-1)
				{
					g.fillRect(10*i,10*j,10,10);
					x++;
					y++;
				}
			}
		if(i2<0||i2>19)
			i2=0;
		if(j2<0||j2>19)
			j2=0;
		g.setColor(Color.RED);
		g.fillRect(10*i2,10*j2,10,10);
	}
}
}