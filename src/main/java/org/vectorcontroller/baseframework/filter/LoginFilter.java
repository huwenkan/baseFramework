package org.vectorcontroller.baseframework.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String uri = request.getRequestURI();

        // 放行静态资源和登录接口
        if (isUnprotectedResource(uri)) {
            chain.doFilter(req, res);
            return;
        }

        // 检查登录状态
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // 返回统一格式的JSON响应
            response.setStatus(200);
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"message\":\"请先登录\"}");
            return;
        }

        chain.doFilter(req, res);
    }

    private boolean isUnprotectedResource(String uri) {
        return uri.endsWith(".html") ||
               uri.endsWith(".css") ||
               uri.endsWith(".js") ||
               uri.endsWith("/user/login") ||
               uri.endsWith("/baseFramework") ||
               uri.endsWith("/") ||
               uri.endsWith(".png") ||
               uri.endsWith(".jpg");
    }
}
