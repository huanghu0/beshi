package com.bishe.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treeproduct implements Serializable {
    @TableId("pid")
    private int pid;
    private int parentid;
    private String pname;
    private String model;
    private int count;
}
