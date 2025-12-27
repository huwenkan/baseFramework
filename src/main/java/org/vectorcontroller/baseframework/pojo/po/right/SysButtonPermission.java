package org.vectorcontroller.baseframework.pojo.po.right;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.vectorcontroller.baseframework.pojo.po.Base;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysButtonPermission extends Base {
    private String buttonCode;
    private String buttonName;
    private String menuCode;
    private String description;
    private String status;
}
