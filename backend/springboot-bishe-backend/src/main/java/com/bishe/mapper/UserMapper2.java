package com.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper2 extends BaseMapper<User> {
}
