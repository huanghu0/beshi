package com.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.pojo.Productinstance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductinstanceMapper extends BaseMapper<Productinstance> {
    @Insert("INSERT into productinstance (pname,model,details) VALUES (#{pname},#{model},#{details})")
    public int addproductinstance(String pname,String model,String details);
}
