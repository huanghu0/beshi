package com.bishe.utils;


import com.bishe.pojo.Productmodelchildren;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProductModelUtil {
    private volatile static ProductModelUtil INSTANCE;

    // 构造方法私有化
    private ProductModelUtil() {

    }

    // 获取树工具单例 （DCL单例）
    public static ProductModelUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (ProductModelUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductModelUtil();
                }
            }
        }
        return INSTANCE;
    }

    public Productmodelchildren enquireTree(List<Productmodelchildren
                > productmodelItemList) {

        if (productmodelItemList.isEmpty()) {
            return null;
        }

        // 过滤空对象
        List<Productmodelchildren> treeItems = productmodelItemList.stream().filter(treeItem -> treeItem != null).collect(Collectors.toList());

        // 存储 id treeItem
        HashMap<Integer, Productmodelchildren> itemMap = new HashMap<>();
        treeItems.forEach(treeItem -> {
            itemMap.put(treeItem.getPnum(), treeItem);
        });

        // 声明一个变量存放根节点
        Productmodelchildren root = null;

        // 数据组装
        for (Productmodelchildren treeItem : treeItems) {
            int parentid = treeItem.getParentid();
            if (parentid == 0) {
                // 说明该节点为根节点
                root = treeItem;
                continue;
            }
            Productmodelchildren parent = itemMap.get(parentid);
            parent.getChildren().add(treeItem);
        }
        return root;
    }
}
