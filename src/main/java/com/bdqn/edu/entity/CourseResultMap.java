package com.bdqn.edu.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 排课信息
 * </p>
 *
 * @author Li
 * @since 2019-02-21
 */
public class CourseResultMap implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 班级
     */
    private Clazz clazz;

    /**
     * 教室
     */
    private Room room;

    /**
     * 课程
     */
    private Curriculum curriculum;

    /**
     * 职员
     */
    private Teacher teacher;

    /**
     * 上课日期
     */
    private Date begin;

    /**
     * 上课时段
     */
    private String period;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }


    public String getClazzName() {
        return clazz != null ? clazz.getName() : "";
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", clazz=" + clazz +
                ", room=" + room +
                ", curriculum=" + curriculum +
                ", teacher=" + teacher +
                ", begin=" + begin +
                ", period='" + period + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
