package com.bishe.utils;
import com.bishe.pojo.Treeproductchildren;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
public class TreeUtil {

        private volatile static TreeUtil INSTANCE;

        // 构造方法私有化
        private TreeUtil() {

        }

        // 获取树工具单例 （DCL单例）
        public static TreeUtil getInstance() {
            if (INSTANCE == null) {
                synchronized (TreeUtil.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new TreeUtil();
                    }
                }
            }
            return INSTANCE;
        }

        public Treeproductchildren enquireTree(List<Treeproductchildren
                > treeItemList) {

            if (treeItemList.isEmpty()) {
                return null;
            }

            // 过滤空对象
            List<Treeproductchildren> treeItems = treeItemList.stream().filter(treeItem -> treeItem != null).collect(Collectors.toList());

            // 存储 id treeItem
            HashMap<Integer, Treeproductchildren> itemMap = new HashMap<>();
            treeItems.forEach(treeItem -> {
                itemMap.put(treeItem.getPid(), treeItem);
            });

            // 声明一个变量存放根节点
            Treeproductchildren root = null;

            // 数据组装
            for (Treeproductchildren treeItem : treeItems) {
                int parentid = treeItem.getParentid();
                if (parentid == 0) {
                    // 说明该节点为根节点
                    root = treeItem;
                    continue;
                }
                Treeproductchildren parent = itemMap.get(parentid);
                parent.getChildren().add(treeItem);
            }
            return root;
        }

    }

