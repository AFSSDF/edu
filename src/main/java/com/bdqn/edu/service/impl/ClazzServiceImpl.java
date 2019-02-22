package com.bdqn.edu.service.impl;

import com.bdqn.edu.condition.ClazzCondition;
import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.mapper.ClazzMapper;
import com.bdqn.edu.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 班级信息 服务实现类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public int saveClazz(Clazz clazz) {
        return clazzMapper.insertClazz(clazz);
    }

    @Override
    public int modifyClazz(Clazz clazz) {
        return clazzMapper.updateClazz(clazz);
    }

    @Override
    public int removeClazz(Long id) {
        return clazzMapper.deleteClazz(id);
    }

    @Override
    public List<Clazz> findClazzList() {
        return clazzMapper.listClazz();
    }

    @Override
    public Integer countClazz() {
        return clazzMapper.countClazz();
    }

    @Override
    public Clazz findClazzById(Long id) {
        return clazzMapper.selectClazzById(id);
    }

    @Override
    public List<Clazz> findClazzListByCondition(ClazzCondition clazzCondition) {
        return clazzMapper.listClazzByCondition(clazzCondition);
    }
}
