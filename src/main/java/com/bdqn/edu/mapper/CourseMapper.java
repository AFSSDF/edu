package com.bdqn.edu.mapper;

import com.bdqn.edu.condition.CourseCondition;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.entity.CourseResultMap;

import java.util.List;

/**
 * <p>
 * 排课信息 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface CourseMapper {
    int insertCourse(Course course);

    int updateCourse(Course course);

    int deleteCourse(Long id);

    List<Course> listCourse();

    Integer countCourse();

    Course selectCourseById(Long id);

    List<CourseResultMap> listCourseByCondition(CourseCondition courseCondition);
}
