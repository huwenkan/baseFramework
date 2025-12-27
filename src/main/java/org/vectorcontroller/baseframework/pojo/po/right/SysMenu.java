package org.vectorcontroller.baseframework.pojo.po.right;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.vectorcontroller.baseframework.enums.MenuType;
import org.vectorcontroller.baseframework.enums.Status;
import org.vectorcontroller.baseframework.pojo.po.Base;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends Base {
    private String code;                // 菜单唯一标识
    private String name;                // 菜单名称
    private MenuType type;              // 菜单类型（NAVIGATION为导航，MENU为普通菜单）
    private String parentCode;          // 父级菜单标识
    private String pageUrl;             // 菜单页面URL
    private Status status;              // 菜单状态
}
