package com.ww.springboot.boot.model;

public class Md5 {

      private  long id;
     
	 //密文
      private  String cipherText;
     
	 //明文
      private  String text;
     
	 //保留
      private  String info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCipherText() {
		return cipherText;
	}

	public void setCipherText(String cipherText) {
		this.cipherText = cipherText;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Md5 [id=" + id + ", cipherText=" + cipherText + ", text=" + text + ", info=" + info + "]";
	}
      
      
      
}
