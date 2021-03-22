package com.bishe.controller;

import com.bishe.mapper.ProductNodeMapper;
import com.bishe.pojo.Product;
import com.bishe.pojo.Productnode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productNodeController {
    @Autowired
    private ProductNodeMapper productNodeMapper;
    @Autowired
    private Productnode productnode;
    public void addProductNode(String productnodenumber,String productnumber,String parentnodenumber,String productNodeName,int lft,int rht){
        productnode.setProductnodenumber(productnodenumber);
        productnode.setProductnumber(productnumber);
        productnode.setParentnodenumber(parentnodenumber);
        productnode.setProductnodename(productNodeName);
        productnode.setLft(lft);
        productnode.setRht(rht);
        productNodeMapper.insert(productnode);
    }
    @RequestMapping("/addproductnode")
    public String addproductnode(String productnodenumber,String productnumber,String parentnodenumber,String productNodeName,int lft,int rht){
        int abs = rht - lft;
        List<Productnode> product =  productNodeMapper.selectByNumber(productnumber);
        List<Productnode> parentnode =  productNodeMapper.selectByNumber(parentnodenumber);
        if(abs != 1){
            return "添加失败,节点rht必须只比lft值大1";
        }else if(product == null || product.isEmpty()){
            return "添加失败,节点所要添加到的对应产品模板不存在，请检查对应产品是否存在!";
        }else if(parentnode == null || parentnode.isEmpty()){
            return "添加失败,父节点不存在,请检查父节点是否天写正确!";
        }else if(parentnode.get(0).getLft()>= lft || parentnode.get(0).getRht() < lft){
            return "添加失败,节点的lft必须大于父节点的lft小于等于父节点的rht,当前父节点的lft和rht分别为"+parentnode.get(0).getLft()+','+parentnode.get(0).getRht();
        }
        productNodeMapper.updatenodelft(lft);
        productNodeMapper.updatenoderht(lft);
        addProductNode(productnodenumber,productnumber,parentnodenumber,productNodeName,lft,rht);
        return "添加成功";
    }
}