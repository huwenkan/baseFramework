package org.vectorcontroller.baseframework.service.impl;

import org.springframework.stereotype.Service;
import org.vectorcontroller.baseframework.pojo.po.right.SysUser;
import org.vectorcontroller.baseframework.service.IloginService;

@Service
public class IloginServiceImpl implements IloginService {

    @Override
    public SysUser checkLogin(String username, String password) {
        return null;
    }
}
