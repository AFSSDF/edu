package com.bdqn.edu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 职员信息
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 职员姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否在职
     */
    private Boolean is_exist;

    private Date gmt_create;

    private Date gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getIs_exist() {
        return is_exist;
    }

    public void setIs_exist(Boolean is_exist) {
        this.is_exist = is_exist;
    }
    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }
    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        "id=" + id +
        ", name=" + name +
        ", email=" + email +
        ", is_exist=" + is_exist +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
