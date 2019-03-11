package com.ww.springboot.boot.rest.dto;

import java.io.Serializable;

/**
 * 页面初始化属性dto
 * @description:
 * @author: syq
 * @create: 2019-03-08 16:33
 **/
public class DianaPageInitDto implements Serializable {

    private static final long serialVersionUID = -7386009080772753205L;

    private String id;


    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
