package com.ww.springboot.boot.baseTest.design.builder;

/**
 * @author wanwei
 * @TODO 建造者模式关键在于director来实现建造过程，
 *       且director中的建造方法只要是实现建造接口的实体类都能使用
 *       在使用时不用关心建造过程以及建造内容：过程被director封装，内容被具体的建造类封装
 *       建造者模式使用在内部建造过程相对稳定，不轻易改变的情况下
 * @date: 2018年9月28日 下午1:56:48 
 */
public class Human {
	
	private String head;	
	private String body;	
	private String hand;	
	private String foot;
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getHand() {
		return hand;
	}
	public void setHand(String hand) {
		this.hand = hand;
	}
	public String getFoot() {
		return foot;
	}
	public void setFoot(String foot) {
		this.foot = foot;
	}
	@Override
	public String toString() {
		return "Human [head=" + head + ", body=" + body + ", hand=" + hand + ", foot=" + foot + "]";
	}
	
	

}
