package com.bdqn.edu.service.impl;

import com.bdqn.edu.condition.CourseCondition;
import com.bdqn.edu.entity.Course;
import com.bdqn.edu.mapper.CourseMapper;
import com.bdqn.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 排课信息 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;
    @Override
    public int saveCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    @Override
    public int modifyCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int removeCourse(Long id) {
        return courseMapper.deleteCourse(id);
    }

    @Override
    public List<Course> findCourseList() {
        return courseMapper.listCourse();
    }

    @Override
    public Integer countCourse() {
        return courseMapper.countCourse();
    }

    @Override
    public Course findCourseById(Long id) {
        return courseMapper.selectCourseById(id);
    }

    @Override
    public List<Course> findCourseListByCondition(CourseCondition courseCondition) {
        return courseMapper.listCourseByCondition(courseCondition);
    }
}
