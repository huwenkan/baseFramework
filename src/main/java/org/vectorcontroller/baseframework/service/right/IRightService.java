package org.vectorcontroller.baseframework.service.right;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.vectorcontroller.baseframework.pojo.po.right.SysButtonPermission;
import org.vectorcontroller.baseframework.pojo.po.right.SysMenu;
import org.vectorcontroller.baseframework.pojo.po.right.SysResourcePermission;
import org.vectorcontroller.baseframework.pojo.po.right.SysRole;

import java.util.List;

public interface IRightService {
    List<SysMenu> getUserMenu(String username);

    void saveRole(SysRole role);

    /**
     * 分页获取角色列表
     *
     * @param pageNum  页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 分页结果，包含角色列表和总数
     */
    Page<SysRole> getRole(Integer pageNum, Integer pageSize);

    /**
     * 获取按钮权限列表
     *
     * @param pageNum  页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 分页结果，包含按钮权限列表和总数
     */
    Page<SysButtonPermission> getButton(Integer pageNum, Integer pageSize);

    /**
     * 获取资源权限列表
     *
     * @param pageNum  页码，默认为1
     * @param pageSize 每页大小，默认为10
     * @return 分页结果，包含资源权限列表和总数
     */
    Page<SysResourcePermission> getResource(Integer pageNum, Integer pageSize);

    /**
     * 保存按钮权限信息
     *
     * @param sysButtonPermission
     */
    void saveButton(SysButtonPermission sysButtonPermission);

    /**
     * 保存资源权限信息
     *
     * @param sysResourcePermission
     */
    void saveResource(SysResourcePermission sysResourcePermission);

    /**
     * 删除角色
     *
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 删除按钮权限
     *
     * @param id
     */
    void deleteButton(Integer id);

    /**
     * 删除资源权限
     *
     * @param id
     */
    void deleteResource(Integer id);

    /**
     * 修改角色信息
     *
     * @param role
     */
    void updateRole(SysRole role);

    /**
     * 修改按钮权限信息
     *
     * @param sysButtonPermission
     */
    void updateButton(SysButtonPermission sysButtonPermission);

    /**
     * 修改资源权限信息
     *
     * @param sysResourcePermission
     */
    void updateResource(SysResourcePermission sysResourcePermission);

    /**
     * 获取所有角色列表
     *
     * @return
     */
    List<SysRole> getAllRoles();

    /**
     * 获取已分配角色列表
     *
     * @param id   用户id
     * @param type 用户类型
     * @return
     */
    List<SysRole> getAssignedRoles(Long id, String type);

    /**
     * 分配权限
     *
     * @param id  用户id
     * @param roleIds  角色id
     * @param type    用户类型
     */
    void assignPermissions(Long id, List<Long> roleIds, String type);
}
