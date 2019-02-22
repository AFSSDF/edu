package com.bdqn.edu.service.impl;

import com.bdqn.edu.condition.CurriculumCondition;
import com.bdqn.edu.entity.Curriculum;
import com.bdqn.edu.mapper.CurriculumMapper;
import com.bdqn.edu.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程信息 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Override
    public int saveCurriculum(Curriculum curriculum) {
        return curriculumMapper.insertCurriculum(curriculum);
    }

    @Override
    public int modifyCurriculum(Curriculum curriculum) {
        return curriculumMapper.updateCurriculum(curriculum);
    }

    @Override
    public int removeCurriculum(Long id) {
        return curriculumMapper.deleteCurriculum(id);
    }

    @Override
    public List<Curriculum> findCurriculumList() {
        return curriculumMapper.listCurriculum();
    }

    @Override
    public Integer countCurriculum() {
        return curriculumMapper.countCurriculum();
    }

    @Override
    public Curriculum findCurriculumById(Long id) {
        return curriculumMapper.selectCurriculumById(id);
    }

    @Override
    public List<Curriculum> findCurriculumListByCondition(CurriculumCondition curriculumCondition) {
        return curriculumMapper.listCurriculumByCondition(curriculumCondition);
    }
}
