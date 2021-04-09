package com.bishe.controller;

import com.bishe.mapper.ProductmodelMapper;
import com.bishe.pojo.Productmodel;
import com.bishe.pojo.Productmodelchildren;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productmodelController {
    @Autowired
    private Productmodel productmodel;
    @Autowired
    private ProductmodelMapper productmodelMapper;
    @RequestMapping("/addproductmodellists")
    public String addProductModelLists(@RequestBody List<Productmodel> productmodellist){
        for (Productmodel p:productmodellist){
            try{
                productmodelMapper.insert(p);
            }catch (Exception e){
                return "操作失败";
            }
        }
        return "操作成功";
    }
    @RequestMapping("/selectallproductmodel")
    public List<Productmodel> selectAllProductModel(){
        return productmodelMapper.selectList(null);
    }
    @RequestMapping("/deleteproductmodellists")
    public String deleteProductModelLists(@RequestBody List<Integer> idlist){
        try {
            productmodelMapper.deleteBatchIds(idlist);
        }catch (Exception e){
            return "删除失败";
        }
        return "删除成功";
    }
}
