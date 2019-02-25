package com.bdqn.edu.service;

import com.bdqn.edu.condition.ClazzCondition;
import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.entity.Clazz;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.logging.Level;

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

    @CachePut(key = "#clazz.id")
    int modifyClazz(Clazz clazz);

    @CacheEvict(key = "#id")
    int removeClazz(Long id);

    @Cacheable(key = "list")
    List<Clazz> findClazzList();

    Integer countClazz();

    @Cacheable(key = "#id")
    Clazz findClazzById(Long id);

    @Cacheable(keyGenerator = "keyGenerator")
    List<Clazz> findClazzListByCondition(ClazzCondition clazzCondition);
}
