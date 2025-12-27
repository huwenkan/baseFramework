package org.vectorcontroller.baseframework.pojo.po;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class Base {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
    @TableLogic
    private Integer deleted; // 逻辑删除字段
}
