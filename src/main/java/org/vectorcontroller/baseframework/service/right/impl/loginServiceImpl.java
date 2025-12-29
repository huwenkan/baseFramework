package org.vectorcontroller.baseframework.service.right.impl;

import org.springframework.stereotype.Service;
import org.vectorcontroller.baseframework.pojo.po.right.SysUser;
import org.vectorcontroller.baseframework.service.right.IloginService;

@Service
public class loginServiceImpl implements IloginService {

    @Override
    public SysUser checkLogin(String username, String password) {
        return null;
    }
}
