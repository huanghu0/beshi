package com.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.pojo.Admin;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    @Select("select * from admin where account = #{account}")
    public List<Admin> selectByAccount(int account);
    @Select("select * from admin where telnum = #{telnum}")
    public List<Admin> selectByTelnum(String Telnum);
    @Select("select * from admin where account = #{account} AND password = #{password}")
    public List<Admin> selectByAccount(int account,String password);
}
