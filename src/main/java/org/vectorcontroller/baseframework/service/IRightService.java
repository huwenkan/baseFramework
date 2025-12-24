package org.vectorcontroller.baseframework.service;

import org.vectorcontroller.baseframework.pojo.po.SysMenu;

import java.util.List;
import java.util.Map;

public interface IRightService {
    List<SysMenu> getUserMenu(String username);
}
