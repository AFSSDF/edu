package com.bdqn.edu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 排课信息
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 班级id
     */
    private Long clazz_id;

    /**
     * 教室id
     */
    private Long room_id;

    /**
     * 课程id
     */
    private Long curriculum_id;

    /**
     * 职员id
     */
    private Long teacher_id;

    /**
     * 上课日期
     */
    private Date begin;

    /**
     * 上课时段
     */
    private String period;

    private Date gmt_create;

    private Date gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(Long clazz_id) {
        this.clazz_id = clazz_id;
    }
    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }
    public Long getCurriculum_id() {
        return curriculum_id;
    }

    public void setCurriculum_id(Long curriculum_id) {
        this.curriculum_id = curriculum_id;
    }
    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }
    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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
        return "Course{" +
        "id=" + id +
        ", clazz_id=" + clazz_id +
        ", room_id=" + room_id +
        ", curriculum_id=" + curriculum_id +
        ", teacher_id=" + teacher_id +
        ", begin=" + begin +
        ", period=" + period +
        ", gmt_create=" + gmt_create +
        ", gmt_modified=" + gmt_modified +
        "}";
    }
}
