package org.vectorcontroller.baseframework.service;

import org.vectorcontroller.baseframework.pojo.po.SysUser;

public interface IloginService {
    SysUser checkLogin(String username, String password);
}
