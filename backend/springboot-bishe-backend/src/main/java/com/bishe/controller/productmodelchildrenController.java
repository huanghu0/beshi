package com.bishe.controller;

import com.alibaba.fastjson.JSON;
import com.bishe.mapper.ProductmodelchildrenMapper;
import com.bishe.pojo.Productmodel;
import com.bishe.pojo.Productmodelchildren;
import com.bishe.utils.ProductModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class productmodelchildrenController {
    @Autowired
    private ProductmodelchildrenMapper productmodelchildrenMapper;
    @Autowired
    private Productmodelchildren productmodelchildren;
    @Autowired
    private productmodelController productmodelcontroller;
    @RequestMapping("/selectallproductmodelchildren")
    public String selectAllProductModelChildren(){
        List<Productmodel> plist = productmodelcontroller.selectAllProductModel();
        List<Productmodelchildren> productmodelchildrenList = new ArrayList<>();
        for (Productmodel p : plist){
            productmodelchildrenList.add(new Productmodelchildren(p.getPnum(),p.getParentid(),p.getPname(),p.getModel(),p.getCount()));
        }
        Productmodelchildren allproductmodelchildren = ProductModelUtil.getInstance().enquireTree(productmodelchildrenList);
        return JSON.toJSONString(allproductmodelchildren);
    }
}
