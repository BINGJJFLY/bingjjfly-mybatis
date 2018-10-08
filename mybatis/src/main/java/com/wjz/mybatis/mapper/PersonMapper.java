package com.wjz.mybatis.mapper;

import com.wjz.mybatis.pojo.Person;

public interface PersonMapper {

	Person selectById(Long id);
}
