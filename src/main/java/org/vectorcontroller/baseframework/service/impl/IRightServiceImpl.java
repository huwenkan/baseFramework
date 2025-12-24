package org.vectorcontroller.baseframework.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vectorcontroller.baseframework.exeception.BusinessException;
import org.vectorcontroller.baseframework.mapper.*;
import org.vectorcontroller.baseframework.pojo.po.*;
import org.vectorcontroller.baseframework.service.IRightService;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class IRightServiceImpl implements IRightService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    /**
     * 获取用户菜单权限
     * @param username 用户名
     * @return 用户的菜单权限信息
     */
    @Override
    public List<SysMenu> getUserMenu(String username) {
        // 1. 获取用户信息，根据用户名查找用户
        SysUser user = userMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));

        // 检查用户是否存在
        if (user == null) {
            throw new BusinessException(500, "用户不存在");
        }

        // 2. 获取用户的角色列表（通过中间表 user_role 来查找）
        List<SysRole> roles = roleMapper.selectList(
                Wrappers.<SysRole>lambdaQuery().in(SysRole::getId,
                        userRoleMapper.selectList(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, user.getId()))
                                .stream().map(SysUserRole::getRoleId).collect(Collectors.toList())
                )
        );

        // 3. 获取角色对应的所有菜单ID
        // 获取所有角色的菜单ID，去重处理
        List<String> menuIds = roles.stream()
                .flatMap(role -> roleMenuMapper.selectList(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId, role.getId()))
                        .stream().map(SysRoleMenu::getMenuId)) // 获取每个角色的菜单ID
                .distinct() // 去重
                .collect(Collectors.toList());

        // 4. 根据菜单ID查询菜单信息
        List<SysMenu> menus = menuMapper.selectList(
                Wrappers.<SysMenu>lambdaQuery().in(SysMenu::getId, menuIds)
        );

        // 5. 返回用户的菜单权限
        return  menus;
    }
}
