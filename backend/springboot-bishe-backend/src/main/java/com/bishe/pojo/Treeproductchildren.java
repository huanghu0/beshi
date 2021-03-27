package com.bishe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treeproductchildren implements Serializable {
    private int pid;
    private int parentid;
    private String pname;
    private String model;
    private int count;
    private List<Treeproductchildren> children = new ArrayList<>();
    public Treeproductchildren(int pid,int parentid,String pname,String model,int count){
        this.pid = pid;
        this.parentid = parentid;
        this.pname = pname;
        this.model = model;
        this.count = count;
    }
}

