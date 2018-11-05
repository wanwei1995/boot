package com.ww.springboot.boot.old;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Drawlinepaintcomponent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbt = new JButton("move");
	private JButton jbt2 = new JButton("move2");
	private kbb canvas = new kbb();

	public Drawlinepaintcomponent() {
		JPanel panel = new JPanel();
		panel.add(jbt);
		panel.add(jbt2);
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
		Timer timer = new Timer(100, new jbtListener3());
		timer.start();
		jbt.addActionListener(new jbtListener());
		jbt2.addActionListener(new jbtListener2());

	}

	class jbtListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.move();
		}

	}

	class jbtListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.move2();
		}

	}

	class jbtListener3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.move3();
		}

	}

	class kbb extends JPanel {

		private int radiusx = 0;
		private int radiusy = 0;

		public void move() {
			radiusx += 100;
			repaint();
		}

		public void move2() {
			radiusy += 100;
			repaint();
		}

		public void move3() {
			radiusy += 1;
			repaint();
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawLine(0, 100, 300, 100);
			g.drawLine(0, 200, 300, 200);
			g.drawLine(0, 300, 300, 300);
			g.setColor(Color.RED);
			g.drawLine(100, 0, 100, 300);
			g.drawLine(200, 0, 200, 300);
			g.drawLine(300, 0, 300, 300);
			g.setColor(Color.BLACK);
			g.drawOval(radiusx, radiusy, 100, 100);

		}

	}

	public static void main(String[] args) {

		JFrame drawline = new Drawlinepaintcomponent();
		drawline.setTitle("drawline a form");
		drawline.setSize(300, 300);
		drawline.setLocationRelativeTo(null);
		drawline.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawline.setVisible(true);
	}
}
