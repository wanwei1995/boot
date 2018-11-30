package com.ww.springboot.boot.model;

/**
 * @author wanwei
 * @TODO   导航基础类
 * @date: 2018年11月30日 上午10:05:06 
 */
public class UrlManage {

	
	private Long id;
	
	private Long pId;
	
	private String code;
	
	private String name;
	
	private String url;
	
	private String right = "true";
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UrlManage [id=" + id + ", pId=" + pId + ", code=" + code + ", name=" + name + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}
}
