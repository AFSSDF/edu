package com.bdqn.edu.test;

import com.bdqn.edu.entity.Teacher;
import com.bdqn.edu.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherTest {
    @Autowired
    private TeacherService teacherService;

    @Test
    public void saveTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("田红帅");
        teacher.setEmail("601363752@qq.com");
        teacher.setIsDelete(false);
        System.out.println(teacherService.saveTeacher(teacher));
    }

    @Test
    public void removeTeacher() {
        System.out.println(teacherService.removeTeacher(new Long(1)));
    }

    @Test
    public void modifyTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(new Long(2));
        teacher.setName("田红帅");
        teacher.setEmail("601363752@qq.com");
        teacher.setIsDelete(false);
        System.out.println(teacherService.modifyTeacher(teacher));
    }

    @Test
    public void findTeacherList() {
        List<Teacher> teacherList = teacherService.findTeacherList();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Test
    public void findTeacherById(){
        System.out.println(teacherService.findTeacherById(new Long(2)));
    }
}
