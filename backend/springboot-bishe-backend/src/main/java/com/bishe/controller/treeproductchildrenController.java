package com.bishe.controller;

import com.alibaba.fastjson.JSON;
import com.bishe.mapper.TreeproductchildrenMapper;
import com.bishe.pojo.Treeproduct;
import com.bishe.pojo.Treeproductchildren;
import com.bishe.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class treeproductchildrenController {
    @Autowired
    private TreeproductchildrenMapper treeproductchildrenMapper;
    @Autowired
    private Treeproductchildren treeproductchildren;
    @Autowired
    private treeproductController treeproductcontroller;
    @RequestMapping("/selectalltreeproductchildren")
    public String selectAllTreeProductChildren(){
        List<Treeproduct> tlist = treeproductcontroller.selectAllTreeProducts();
        List<Treeproductchildren> treeproductchildrenList = new ArrayList<>();
        for (Treeproduct t:
             tlist) {
            treeproductchildrenList.add(new Treeproductchildren(t.getPid(),t.getParentid(),t.getPname(),t.getModel(),t.getCount()));
        }
        Treeproductchildren alltreechildren = TreeUtil.getInstance().enquireTree(treeproductchildrenList);
        return JSON.toJSONString(alltreechildren);
    }
}
