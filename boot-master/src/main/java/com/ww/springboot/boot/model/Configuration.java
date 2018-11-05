package com.ww.springboot.boot.model;

/**
 * @author wanwei
 * @TODO  系统参数
 * @date: 2018年9月12日 下午4:36:05 
 */
public class Configuration extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Override
	public String toString() {
		return "Configuration [id=" + id + ", configNo=" + configNo + ", descrC=" + descrC + ", value=" + value
				+ ", isDeleted=" + isDeleted + "]";
	}

	private String configNo;
	
	private String descrC;
	
	private String value;
	
	private String isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConfigNo() {
		return configNo;
	}

	public void setConfigNo(String configNo) {
		this.configNo = configNo;
	}

	public String getDescrC() {
		return descrC;
	}

	public void setDescrC(String descrC) {
		this.descrC = descrC;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
}
