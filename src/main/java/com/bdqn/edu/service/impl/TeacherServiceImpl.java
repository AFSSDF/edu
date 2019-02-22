package com.bdqn.edu.service.impl;

import com.bdqn.edu.condition.TeacherCondition;
import com.bdqn.edu.entity.Teacher;
import com.bdqn.edu.mapper.ClazzMapper;
import com.bdqn.edu.mapper.TeacherMapper;
import com.bdqn.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 职员信息 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int saveTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }

    @Override
    public int modifyTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int removeTeacher(Long id) {
        return teacherMapper.deleteTeacher(id);
    }

    @Override
    public List<Teacher> findTeacherList() {
        return teacherMapper.listTeacher();
    }

    @Override
    public Integer countTeacher() {
        return teacherMapper.countTeacher();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return teacherMapper.selectTeacherById(id);
    }

    @Override
    public List<Teacher> findTeacherListByCondition(TeacherCondition teacherCondition) {
        return teacherMapper.listTeacherByCondition(teacherCondition);
    }
}
