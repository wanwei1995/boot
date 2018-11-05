package com.ww.springboot.boot.common;

/**
 * 是否
 * 
 */
public enum YesOrNo{
    YES(1, "是"), NO(0, "否");

    YesOrNo(Integer value, String memo) {
        this.value = value;
        this.memo = memo;
    }

    private Integer value;
    private String memo;

    public Integer getValue() {
        return this.value;
    }

    public String getMemo() {
        return this.memo;
    }

    public String getDisplayValue() {
        return this.memo;
    }
}
