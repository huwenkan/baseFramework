package org.vectorcontroller.baseframework.pojo.po.right;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.vectorcontroller.baseframework.pojo.po.Base;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysPermission extends Base {
    private String permissionCode;
    private String permissionName;
    private String description;
}
