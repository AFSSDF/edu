package com.bdqn.edu.mapper;

import com.bdqn.edu.condition.CurriculumCondition;
import com.bdqn.edu.entity.Curriculum;
import com.bdqn.edu.entity.Curriculum;

import java.util.List;

/**
 * <p>
 * 课程信息 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface CurriculumMapper {
    int insertCurriculum(Curriculum curriculum);

    int updateCurriculum(Curriculum curriculum);

    int deleteCurriculum(Long id);

    List<Curriculum> listCurriculum();

    Integer countCurriculum();

    Curriculum selectCurriculumById(Long id);

    List<Curriculum> listCurriculumByCondition(CurriculumCondition curriculumCondition);
}
