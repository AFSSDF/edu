package com.bdqn.edu.mapper;

import com.bdqn.edu.condition.ClazzCondition;
import com.bdqn.edu.entity.Clazz;
import com.bdqn.edu.entity.Clazz;

import java.util.List;

/**
 * <p>
 * 班级信息 Mapper 接口
 * </p>
 *
 * @author Li
 * @since 2019-02-19
 */
public interface ClazzMapper {
    int insertClazz(Clazz clazz);

    int updateClazz(Clazz clazz);

    int deleteClazz(Long id);

    List<Clazz> listClazz();

    Integer countClazz();

    Clazz selectClazzById(Long id);

    List<Clazz> listClazzByCondition(ClazzCondition clazzCondition);
}
