package com.bishe.controller;

import com.bishe.mapper.ProductNodeMapper;
import com.bishe.pojo.Product;
import com.bishe.pojo.Productnode;
import com.bishe.pojo.Productnodefc;
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
    public String addproductnode(String productnodenumber,String productnumber,String parentnodenumber,String productNodeName){
        List<Productnode> product =  productNodeMapper.selectByNumber(productnumber);
        List<Productnode> parentnode =  productNodeMapper.selectByNumber(parentnodenumber);
        if(product == null || product.isEmpty()){
            return "添加失败,节点所要添加到的对应产品模板不存在，请检查对应产品编号是否正确!";
        }else if(parentnode == null || parentnode.isEmpty()){
            return "添加失败,父节点不存在,请检查父节点号是否正确!";
        }
        int lft = parentnode.get(0).getRht();
        int rht = lft+1;
        productNodeMapper.updatenodelft(lft);
        productNodeMapper.updatenoderht(lft);
        addProductNode(productnodenumber,productnumber,parentnodenumber,productNodeName,lft,rht);
        return "添加成功";
    }
    @RequestMapping("/selectAllproductnode")
    public List<Productnode> selectAllproductnode(){
        return productNodeMapper.selectList(null);
    }
    @RequestMapping("/selectAllNodeFc")
    public List<Productnodefc> selectAllNodeFc(){
        return productNodeMapper.selectallnodefc();
    }
}