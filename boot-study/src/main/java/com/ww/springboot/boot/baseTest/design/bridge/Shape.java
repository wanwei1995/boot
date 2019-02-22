package com.ww.springboot.boot.baseTest.design.bridge;

//形状
public abstract class Shape {
	private Color color;
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}
	
	public abstract void draw();

}
