package com.bishe.controller;

import com.bishe.mapper.ProductMapper;
import com.bishe.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productController {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private Product product;
    @Autowired
    private productNodeController productNodeController;
    @RequestMapping("/addproduct/{productnumber}/{productname}")
    public String addProduct(@PathVariable("productnumber") String productnumber,@PathVariable("productname") String productname){
        product.setProductnumber(productnumber);
        product.setProductname(productname);
        if(productMapper.insert(product) == 1){
            productNodeController.addProductNode(productnumber,productnumber,null,productname,1,2);
            return "添加成功";
        }
        return "添加失败，请检查产品是否已经存在!";
    }
    @RequestMapping("/selectallproducts")
    public List<Product> selectAllProducts(){
        return productMapper.selectList(null);
    }
}
