package com.bdqn.edu.service;

import com.bdqn.edu.condition.TeacherCondition;
import com.bdqn.edu.entity.Teacher;

import java.util.List;

/**
 * <p>
 * 职员信息 服务类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface TeacherService {
    
    int saveTeacher(Teacher teacher);

    int modifyTeacher(Teacher teacher);

    int removeTeacher(Long id);

    List<Teacher> findTeacherList();

    Integer countTeacher();

    Teacher findTeacherById(Long id);

    List<Teacher> findTeacherListByCondition(TeacherCondition teacherCondition);
}
