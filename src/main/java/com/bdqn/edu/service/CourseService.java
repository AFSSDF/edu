package com.bdqn.edu.service;

import com.bdqn.edu.condition.CourseCondition;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.CourseResultMap;

import java.util.List;

/**
 * <p>
 * 排课信息 服务类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface CourseService {
    int saveCourse(Course course);

    int modifyCourse(Course course);

    int removeCourse(Long id);

    List<Course> findCourseList();

    Integer countCourse();

    Course findCourseById(Long id);

    List<CourseResultMap> findCourseListByCondition(CourseCondition courseCondition);
}
