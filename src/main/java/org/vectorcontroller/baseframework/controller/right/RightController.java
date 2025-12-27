package org.vectorcontroller.baseframework.controller.right;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vectorcontroller.baseframework.pojo.po.right.SysButtonPermission;
import org.vectorcontroller.baseframework.pojo.po.right.SysMenu;
import org.vectorcontroller.baseframework.pojo.po.right.SysResourcePermission;
import org.vectorcontroller.baseframework.pojo.po.right.SysRole;
import org.vectorcontroller.baseframework.pojo.vo.ResponseResultVO;
import org.vectorcontroller.baseframework.service.right.IRightService;

import java.util.List;

@RestController
@RequestMapping("/right")
public class RightController {
    @Autowired
    private IRightService rightService;

    /**
     * 分配角色权限
     */
    @PostMapping("/assignPermissions")
    public ResponseResultVO assignPermissions(Long id, @RequestParam("roleIds") List<Long> roleIds, String type) {
        rightService.assignPermissions(id, roleIds, type);
        return ResponseResultVO.success(null);
    }
    /**
     * 获取用户已分配的角色
     */
    @GetMapping("/getAssignedRoles")
    public ResponseResultVO getAssignedRoles(Long id, String type) {
        List<SysRole> assignedRoles = rightService.getAssignedRoles(id, type);
        return ResponseResultVO.success(assignedRoles);
    }

    /**
     * 获取所有角色
     */
    @GetMapping("/getAllRoles")
    public ResponseResultVO getAllRoles (){
        return ResponseResultVO.success(rightService.getAllRoles());
    }

    @GetMapping("/getUserMenu")
    public ResponseResultVO getUserRight(HttpServletRequest request) {
        String username = request.getSession().getAttribute("username").toString();
        List<SysMenu> userRight = rightService.getUserMenu(username);
        return ResponseResultVO.success(userRight);
    }

    /**
     * 编辑角色
     */
    @PostMapping("/updateRole")
    public ResponseResultVO editRole(SysRole role) {
        rightService.updateRole(role);
        return ResponseResultVO.success(null);
    }

    /**
     * 删除角色
     */
    @PostMapping("/deleteRole")
    public ResponseResultVO deleteRole(Integer id) {
        rightService.deleteRole(id);
        return ResponseResultVO.success(null);
    }

    /**
     * 保存角色
     *
     * @param role
     * @return
     */
    @PostMapping("/saveRole")
    public ResponseResultVO saveRole(SysRole role) {
        rightService.saveRole(role);
        return ResponseResultVO.success(null);
    }

    /**
     * 分页查询角色信息
     */
    @GetMapping("/getRole")
    public ResponseResultVO getRole(Integer pageNum, Integer pageSize) {
        Page<SysRole> result = rightService.getRole(pageNum, pageSize);
        return ResponseResultVO.success(result);
    }

    /**
     * 编辑按钮权限
     */
    @PostMapping("/updateButton")
    public ResponseResultVO editButton(SysButtonPermission sysButtonPermission) {
        rightService.updateButton(sysButtonPermission);
        return ResponseResultVO.success(null);
    }

    /**
     * 删除按钮权限
     */
    @PostMapping("/deleteButton")
    public ResponseResultVO deleteButton(Integer id) {
        rightService.deleteButton(id);
        return ResponseResultVO.success(null);
    }

    /**
     * 保存按钮权限信息
     *
     * @param sysButtonPermission
     * @return
     */
    @PostMapping("/saveButton")
    public ResponseResultVO saveButton(SysButtonPermission sysButtonPermission) {
        rightService.saveButton(sysButtonPermission);
        return ResponseResultVO.success(null);
    }

    /**
     * 分页按钮权限信息
     */
    @GetMapping("/getButton")
    public ResponseResultVO getButton(Integer pageNum, Integer pageSize) {
        Page<SysButtonPermission> result = rightService.getButton(pageNum, pageSize);
        return ResponseResultVO.success(result);
    }
    /**
     * 编辑资源权限
     */
    @PostMapping("/updateResource")
    public ResponseResultVO editResource(SysResourcePermission sysResourcePermission) {
        rightService.updateResource(sysResourcePermission);
        return ResponseResultVO.success(null);
    }

    /**
     * 删除资源权限
     */
    @PostMapping("/deleteResource")
    public ResponseResultVO deleteResource(Integer id) {
        rightService.deleteResource(id);
        return ResponseResultVO.success(null);
    }

    /**
     * 保存资源权限信息
     *
     * @param sysResourcePermission
     * @return
     */
    @PostMapping("/saveResource")
    public ResponseResultVO saveResource(SysResourcePermission sysResourcePermission) {
        rightService.saveResource(sysResourcePermission);
        return ResponseResultVO.success(null);
    }

    /**
     * 分页资源权限信息
     */
    @GetMapping("/getResource")
    public ResponseResultVO getResource(Integer pageNum, Integer pageSize) {
        Page<SysResourcePermission> result = rightService.getResource(pageNum, pageSize);
        return ResponseResultVO.success(result);
    }

}
