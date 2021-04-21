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
public class Admin implements Serializable {
    private int account;
    private String name;
    private String password;
    private String telnum;
}
