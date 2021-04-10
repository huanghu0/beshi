package com.bishe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bishe.pojo.Dictionary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryMapper extends BaseMapper<Dictionary> {
    @Insert("insert into dictionary (dname,represent) values(#{dname},#{represent})")
    public int addDictionary(@Param("dname") String dname,@Param("represent") String represent);
    @Select("select * from dictionary")
    public List<Dictionary> selectAllDictionary();
    @Select("select * from dictionary where dname = #{dname}")
    public List<Dictionary> selectByDname(String dname);

}
