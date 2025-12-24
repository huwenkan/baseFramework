package org.vectorcontroller.baseframework.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Long Id;
    private String roleName;
    private String description;
    private String status;
    private String createTime;
    private String updateTime;
}
