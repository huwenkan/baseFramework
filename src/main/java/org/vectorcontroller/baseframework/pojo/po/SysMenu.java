package org.vectorcontroller.baseframework.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.vectorcontroller.baseframework.enums.MenuType;
import org.vectorcontroller.baseframework.enums.Status;

@Data
public class SysMenu {
    @TableId(type = IdType.AUTO)
    private Integer id;                 // 菜单ID
    private String code;                // 菜单唯一标识
    private String name;                // 菜单名称
    private MenuType type;              // 菜单类型（NAVIGATION为导航，MENU为普通菜单）
    private String parentCode;          // 父级菜单标识
    private String pageUrl;             // 菜单页面URL
    private Status status;              // 菜单状态
    private java.sql.Timestamp createTime;  // 创建时间
    private java.sql.Timestamp updateTime;  // 更新时间
}
