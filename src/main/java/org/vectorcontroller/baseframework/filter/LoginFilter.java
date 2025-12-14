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

        // 放行登录接口
        if (uri.endsWith(".html") || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith("/user/login")) {
            chain.doFilter(req, res);
            return;
        }

        // 获取 Session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.setStatus(401);
            response.getWriter().write("未登录");
            return;
        }

        chain.doFilter(req, res);
    }
}
