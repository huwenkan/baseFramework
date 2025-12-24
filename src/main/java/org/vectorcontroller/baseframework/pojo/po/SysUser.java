package org.vectorcontroller.baseframework.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("username")
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String status;
    private String createTime;
    private String updateTime;
}
