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
public class Productinstance implements Serializable {
    @TableId("pnum")
    private int pnum;
    private String pname;
    private String model;
    private String details;
}
