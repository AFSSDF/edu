package com.bdqn.edu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 教室信息
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 教室名称
     */
    private String name;

    /**
     * 是否有投影仪
     */
    private Boolean is_projector;

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
    public Boolean getIs_projector() {
        return is_projector;
    }

    public void setIs_projector(Boolean is_projector) {
        this.is_projector = is_projector;
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
        return "Room{" +
        "id=" + id +
        ", name=" + name +
        ", is_projector=" + is_projector +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
