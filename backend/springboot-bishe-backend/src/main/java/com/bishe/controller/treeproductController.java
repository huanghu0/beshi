package com.bishe.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bishe.mapper.TreeproductMapper;
import com.bishe.pojo.Treeproduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class treeproductController {
    @Autowired
    private TreeproductMapper treeproductMapper;
    @Autowired
    private Treeproduct treeproduct;
    @RequestMapping("/addtreeproduct")
    public String addTreeProduct(int pid,int parentid,String pname,String model,int count){
        treeproduct.setPid(pid);
        treeproduct.setParentid(parentid);
        treeproduct.setPname(pname);
        treeproduct.setModel(model);
        treeproduct.setCount(count);
        try {
            treeproductMapper.insert(treeproduct);
        }catch (Exception e){
            return "添加失败!";
        }
        return "添加成功";
    }
    @RequestMapping("/selectalltreeproduct")
    public List<Treeproduct> selectAllTreeProducts(){
        return treeproductMapper.selectList(null);
    }
    @RequestMapping("/addtreeproductlists")
    public String addTreeProductLists(List<Treeproduct> tlist){
        for (Treeproduct t:
             tlist) {
            try {
                treeproductMapper.insert(t);
            }catch (Exception e){
                return "操作失败";
            }
        }
        return "操作成功";
    }
    @RequestMapping("/deletetreeproductlists")
    public String deleteTreeProductLists(List<Integer> idlist){
        try{
            treeproductMapper.deleteBatchIds(idlist);
        }catch (Exception e){
            return "删除失败";
        }
        return "删除成功";
    }
    @RequestMapping("/updatetreeproduct")
    public String updateTreeProduct(int pid,String pname){
        try{
            QueryWrapper<Treeproduct> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("pid",pid);
            treeproduct.setPname(pname);
            treeproductMapper.update(treeproduct,queryWrapper);
        }catch (Exception e){
            return "更新失败";
        }
        return "更新成功";
    }
}
