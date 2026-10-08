package com.colegio.plural.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) {

        String uri = request.getRequestURI();

        if (uri.equals("/usuarios/login")) {
            return true;
        }

        if (uri.equals("/usuarios")) {
            return true;
        }

        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
            return true;
        }

        Object usuarioLogado =
                request.getSession().getAttribute("usuarioLogado");

        if (usuarioLogado == null) {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            return false;
        }

        return true;
    }
}
