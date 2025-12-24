package org.vectorcontroller.baseframework.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vectorcontroller.baseframework.pojo.po.SysMenu;
import org.vectorcontroller.baseframework.pojo.vo.ResponseResultVO;
import org.vectorcontroller.baseframework.service.IRightService;

import java.util.List;

@RestController
@RequestMapping("/right")
public class RightController {
    @Autowired
    private IRightService rightService;

    @GetMapping("/getUserMenu")
    public ResponseResultVO getUserRight(HttpServletRequest request) {
        String username = request.getSession().getAttribute("username").toString();
        List<SysMenu> userRight = rightService.getUserMenu(username);
        return ResponseResultVO.success(userRight);
    }
}
