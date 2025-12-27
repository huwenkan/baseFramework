package org.vectorcontroller.baseframework.pojo.po.right;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.vectorcontroller.baseframework.pojo.po.Base;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysResourcePermission extends Base {
    private String resourceCode;
    private String resourceName;
    private String resourceType;
    private String resourcePath;
    private String description;
    private String status;
}
