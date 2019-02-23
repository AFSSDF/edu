package com.bdqn.edu.condition;

import java.util.Date;

/**
 * <p>
 * 排课信息 条件
 * </p>
 *
 * @author Li
 * @since 2019-02-21
 */
public class CourseCondition {
    private String teacherName;
    private String clazzName;
    private String curriculumName;
    private Date begin;
    private Date end;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
