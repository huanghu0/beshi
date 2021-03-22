package com.bishe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Productnodefc implements Serializable {
    private String productnodenumber;
    private String productnumber;
    private String parentnodenumber;
    private String productnodename;
    private int lft;
    private int rht;
    private int depth;
}
