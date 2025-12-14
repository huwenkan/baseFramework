package org.vectorcontroller.baseframework.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysPermission {
    @TableId(type = IdType.AUTO)
    private String id;
    private String permissionCode;
    private String permissionName;
    private String description;
    private String createTime;
    private String updateTime;
}
