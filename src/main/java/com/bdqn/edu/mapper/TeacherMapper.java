package com.bdqn.edu.mapper;

import com.bdqn.edu.condition.TeacherCondition;
import com.bdqn.edu.entity.Teacher;
import java.util.List;

/**
 * <p>
 * 职员信息 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface TeacherMapper {

    int insertTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacher(Long id);

    List<Teacher> listTeacher();

    Integer countTeacher();

    Teacher selectTeacherById(Long id);

    List<Teacher> listTeacherByCondition(TeacherCondition teacherCondition);
}
