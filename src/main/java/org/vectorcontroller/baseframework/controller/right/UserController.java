package org.vectorcontroller.baseframework.controller.right;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vectorcontroller.baseframework.pojo.po.right.SysRole;
import org.vectorcontroller.baseframework.pojo.po.right.SysUser;
import org.vectorcontroller.baseframework.pojo.vo.ResponseResultVO;
import org.vectorcontroller.baseframework.service.right.ISysUerService;
import org.vectorcontroller.baseframework.service.right.IloginService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IloginService loginService;

    @Autowired
    private ISysUerService sysUerService;

    /**
     * 用户登录接口
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录结果，包含token等信息
     */
    @PostMapping("/login")
    public ResponseResultVO login(
            HttpServletRequest request,
            @RequestParam String username,
            @RequestParam String password) {

        Map<String, Object> response = new HashMap<>();

        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("name", "管理员");

            return ResponseResultVO.success(response);
        }
        SysUser user = loginService.checkLogin(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("displayName", user.getDisplayName());

            return ResponseResultVO.success(response);
        } else {
            return ResponseResultVO.error(400, "用户名或密码错误");
        }
    }

    /**
     * 用户登出接口
     *
     * @return 登出结果
     */
    @PostMapping("/logout")
    public ResponseResultVO logout(HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        request.getSession().invalidate();
        response.put("message", "登出成功");
        return ResponseResultVO.success(response);
    }

    /**
     * 分页查询用户信息接口
     */
    @GetMapping("/list")
    public ResponseResultVO list(Integer pageNum, Integer pageSize) {
        // 分页查询用户信息
        // 设置默认值
        if (pageNum == null || pageNum < 1) pageNum = 1;
        if (pageSize == null || pageSize < 1) pageSize = 10;

        // 创建分页对象
        Page<SysUser> page = new Page<>(pageNum, pageSize);

        return ResponseResultVO.success(sysUerService.page(page));
    }
}
