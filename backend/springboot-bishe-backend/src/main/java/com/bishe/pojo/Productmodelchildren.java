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
public class Productmodelchildren implements Serializable {
    private int pnum;
    private int parentid;
    private String pname;
    private String model;
    private int count;
    private List<Productmodelchildren> children = new ArrayList<>();
    public Productmodelchildren(int pnum,int parentid,String pname,String model,int count){
        this.pnum = pnum;
        this.parentid = parentid;
        this.pname = pname;
        this.model = model;
        this.count = count;
    }
}
