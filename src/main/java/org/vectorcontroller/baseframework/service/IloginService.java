package org.vectorcontroller.baseframework.service;

import org.vectorcontroller.baseframework.pojo.po.right.SysUser;

public interface IloginService {
    SysUser checkLogin(String username, String password);
}
