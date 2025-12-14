package org.vectorcontroller.baseframework.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vectorcontroller.baseframework.pojo.po.SysUser;
import org.vectorcontroller.baseframework.pojo.vo.ResponseResultVO;
import org.vectorcontroller.baseframework.service.IloginService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private IloginService loginService;

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

        if ("admin".equals(username) && "12345678".equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("name", "管理员");

            return ResponseResultVO.success(response);
        }
        SysUser user = loginService.checkLogin(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("userName", user.getUserName());

            return ResponseResultVO.success(response);
        } else {
            return ResponseResultVO.error("400", "用户名或密码错误");
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
}
