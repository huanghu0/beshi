package com.bishe.controller;

import com.bishe.mapper.DictionaryMapper;
import com.bishe.pojo.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryController {
    @Autowired
    private Dictionary dictionary;
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @RequestMapping("/adddictionary")
    public String addDictionary(@RequestBody Dictionary resdictionary){
        dictionary.setKey(resdictionary.getKey());
        dictionary.setDname(resdictionary.getDname());
        dictionary.setRepresent(resdictionary.getRepresent());
        try{
            dictionaryMapper.addDictionary(dictionary.getDname(),dictionary.getRepresent());
        }catch (Exception e){
            return "添加失败";
        }
        return "添加成功";
    }
    @RequestMapping("/selectalldictionary")
    public List<Dictionary> selectAllDictionary(){
        return dictionaryMapper.selectAllDictionary();
    }
    @RequestMapping("/selectByDname")
    public List<Dictionary> selectByDname(String dname){
        return dictionaryMapper.selectByDname(dname);
    }
}

