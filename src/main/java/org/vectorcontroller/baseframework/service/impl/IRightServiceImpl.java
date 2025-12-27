package org.vectorcontroller.baseframework.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vectorcontroller.baseframework.exeception.BusinessException;
import org.vectorcontroller.baseframework.mapper.right.*;
import org.vectorcontroller.baseframework.pojo.po.right.*;
import org.vectorcontroller.baseframework.service.IRightService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IRightServiceImpl implements IRightService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysButtonPermissionMapper sysButtonPermissionMapper;
    @Autowired
    private SysResourcePermissionMapper sysResourcePermissionMapper;

    /**
     * 保存角色
     *
     * @param role 角色信息
     */
    @Override
    public void saveRole(SysRole role) {
        sysRoleMapper.insert(role);
    }

    /**
     * 分页获取角色列表
     *
     * @param pageNum  页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 分页结果，包含角色列表和总数
     */
    @Override
    public Page<SysRole> getRole(Integer pageNum, Integer pageSize) {
        // 设置默认值
        if (pageNum == null || pageNum < 1) pageNum = 1;
        if (pageSize == null || pageSize < 1) pageSize = 10;

        // 创建分页对象
        Page<SysRole> page = new Page<>(pageNum, pageSize);

        // 返回完整的分页结果，包含数据列表和总数
        return sysRoleMapper.selectPage(page, null);
    }

    /**
     * 获取用户按钮权限
     *
     * @param pageNum  页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 用户的按钮权限信息
     */
    @Override
    public Page<SysButtonPermission> getButton(Integer pageNum, Integer pageSize) {
        // 创建分页对象
        Page<SysButtonPermission> page = new Page<>(pageNum, pageSize);
        return sysButtonPermissionMapper.selectPage(page, null);
    }

    /**
     * 获取用户资源权限
     *
     * @param pageNum  页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 用户的资源权限信息
     */
    @Override
    public Page<SysResourcePermission> getResource(Integer pageNum, Integer pageSize) {
        // 创建分页对象
        Page<SysResourcePermission> page = new Page<>(pageNum, pageSize);
        return sysResourcePermissionMapper.selectPage(page, null);
    }

    /**
     * 保存按钮权限信息
     *
     * @param sysButtonPermission 按钮权限信息
     */
    @Override
    public void saveButton(SysButtonPermission sysButtonPermission) {
        sysButtonPermission.setButtonCode(UUID.randomUUID().toString());
        sysButtonPermissionMapper.insert(sysButtonPermission);
    }

    /**
     * 保存资源权限信息
     *
     * @param sysResourcePermission 资源权限信息
     */
    @Override
    public void saveResource(SysResourcePermission sysResourcePermission) {
        sysResourcePermission.setResourceCode(UUID.randomUUID().toString());
        sysResourcePermissionMapper.insert(sysResourcePermission);
    }

    /**
     * 删除角色
     *
     * @param id 角色ID
     */
    @Override
    public void deleteRole(Integer id) {
        sysRoleMapper.deleteById(id);
    }

    /**
     * 删除按钮权限
     *
     * @param id 按钮权限ID
     */
    @Override
    public void deleteButton(Integer id) {
        sysButtonPermissionMapper.deleteById(id);
    }

    /**
     * 删除资源权限
     *
     * @param id 资源权限ID
     */
    @Override
    public void deleteResource(Integer id) {
        sysResourcePermissionMapper.deleteById(id);
    }


    /**
     * 获取用户菜单权限
     *
     * @param username 用户名
     * @return 用户的菜单权限信息
     */
    @Override
    public List<SysMenu> getUserMenu(String username) {
        // 1. 获取用户信息，根据用户名查找用户
        SysUser user = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));

        // 检查用户是否存在
        if (user == null) {
            throw new BusinessException(500, "用户不存在");
        }

        // 2. 获取用户的角色列表（通过中间表 user_role 来查找）
        List<SysRole> roles = sysRoleMapper.selectList(Wrappers.<SysRole>lambdaQuery().in(SysRole::getId, sysUserRoleMapper.selectList(Wrappers.<SysUserRole>lambdaQuery().eq(SysUserRole::getUserId, user.getId())).stream().map(SysUserRole::getRoleId).collect(Collectors.toList())));

        // 3. 获取角色对应的所有菜单ID
        // 获取所有角色的菜单ID，去重处理
        List<String> menuIds = roles.stream().flatMap(role -> sysRoleMenuMapper.selectList(Wrappers.<SysRoleMenu>lambdaQuery().eq(SysRoleMenu::getRoleId, role.getId())).stream().map(SysRoleMenu::getMenuId)) // 获取每个角色的菜单ID
                .distinct() // 去重
                .collect(Collectors.toList());

        // 4. 根据菜单ID查询菜单信息
        List<SysMenu> menus = sysMenuMapper.selectList(Wrappers.<SysMenu>lambdaQuery().in(SysMenu::getId, menuIds));

        // 5. 返回用户的菜单权限
        return menus;
    }
}
