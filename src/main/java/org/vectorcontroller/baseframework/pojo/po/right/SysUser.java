package org.vectorcontroller.baseframework.pojo.po.right;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.vectorcontroller.baseframework.pojo.po.Base;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends Base {
    @TableField("username")
    private String username;
    private String password;
    private String displayName;
    private String email;
    private String status;
}
