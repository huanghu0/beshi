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
public class Dictionary implements Serializable {
//    @TableId("key")
    private int key;
    private String dname;
    private String represent;
}
