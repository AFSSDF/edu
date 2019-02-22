package com.bdqn.edu.service;

import com.bdqn.edu.condition.ClazzCondition;
import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.entity.Clazz;

import java.util.List;

/**
 * <p>
 * 班级信息 服务类
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface ClazzService {
    int saveClazz(Clazz clazz);

    int modifyClazz(Clazz clazz);

    int removeClazz(Long id);

    List<Clazz> findClazzList();

    Integer countClazz();

    Clazz findClazzById(Long id);

    List<Clazz> findClazzListByCondition(ClazzCondition clazzCondition);
}
