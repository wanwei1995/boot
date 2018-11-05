package com.ww.springboot.boot.system.model;

import com.ww.springboot.boot.model.BaseEntity;

public class Role extends BaseEntity {

    private static final long serialVersionUID = -4701495300813131241L;

    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer isDeleted;

    /**
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    /**
     * 
     * @return is_deleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 
     * @param isDeleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + ", isDeleted=" + isDeleted + "]";
    }
}
