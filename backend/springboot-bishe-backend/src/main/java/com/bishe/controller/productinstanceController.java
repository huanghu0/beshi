package com.bishe.controller;

import com.bishe.mapper.ProductinstanceMapper;
import com.bishe.pojo.Productinstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productinstanceController {
    @Autowired
    private ProductinstanceMapper productinstanceMapper;
    @Autowired
    private Productinstance productinstance;
    @RequestMapping("/selectallproductinstancelist")
    public List<Productinstance> selectAllProductInstanceLists(){
        return productinstanceMapper.selectList(null);
    }
    @RequestMapping("/addproductinstance")
    public String addProductInstance(String pname,String model,String details){
        try{
            productinstanceMapper.addproductinstance(pname,model,details);
        }catch (Exception e){
            return "添加失败";
        }
        return "添加成功";
    }
}
