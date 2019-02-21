package com.bdqn.edu;

import com.bdqn.edu.entity.Teacher;
import com.bdqn.edu.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EduApplicationTests {

    @Autowired
    private DataSource dataSource;


    @Test
    public void dataSourceTest() {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void contextLoads() {

    }

}
