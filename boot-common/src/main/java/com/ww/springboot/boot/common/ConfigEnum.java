package com.ww.springboot.boot.common;

public enum ConfigEnum {
	
	EMAIL_SENDER("email.sender","邮件发送者"),
	
	EMAIL_PASSWORD("email.password","邮箱密码"),
	
	EMAIL_RECIPIENT("email.recipient","邮件接收者"),
	
	EMAIL_PATH("email.path","邮件存放路径"),
	;
	private String value;
	
	private String name;
	
	ConfigEnum(String value, String name) {
		this.setName(name);
        this.setValue(value);
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	


}
