package com.bdqn.edu.service;

import com.bdqn.edu.entity.Curriculum;
import com.bdqn.edu.entity.Curriculum;

import java.util.List;

/**
 * <p>
 * 课程信息 服务类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface CurriculumService {
    int saveCurriculum(Curriculum curriculum);

    int modifyCurriculum(Curriculum curriculum);

    int removeCurriculum(Long id);

    List<Curriculum> findCurriculumList();

    Integer countCurriculum();

    Curriculum findCurriculumById(Long id);
}
