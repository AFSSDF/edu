package com.bdqn.edu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 课程信息
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 阶段
     */
    private String stage;

    /**
     * 名称
     */
    private String name;

    /**
     * 章节
     */
    private String chapter;

    private Date gmt_create;

    private Date gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
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
        return "Curriculum{" +
        "id=" + id +
        ", stage=" + stage +
        ", name=" + name +
        ", chapter=" + chapter +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
