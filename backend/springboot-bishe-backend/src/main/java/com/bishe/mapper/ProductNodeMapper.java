package com.bishe.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.pojo.Productnode;
import com.bishe.pojo.Productnodefc;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductNodeMapper extends BaseMapper<Productnode> {
    @Select("select * from productnode where productnodenumber = #{number}")
    List<Productnode> selectByNumber(@Param("number") String number);
    @Update("update productnode set lft = lft+2 where lft >= #{lft}")
    int updatenodelft(@Param("lft") int lft);
    @Update("update productnode set rht = rht+2 where rht >= #{lft}")
    int updatenoderht(@Param("lft") int lft);
    @Select("SELECT node.productnodenumber, node.productnumber,node.parentnodenumber,node.productnodename,node.lft,node.rht,(COUNT(parent.productnodename) - 1) AS depth\n" +
            " FROM productnode AS node,\n" +
            " productnode AS parent\n" +
            " WHERE node.lft BETWEEN parent.lft AND parent.rht\n" +
            " GROUP BY node.productnodename\n" +
            " ORDER BY node.lft;")
    List<Productnodefc> selectallnodefc();
}
