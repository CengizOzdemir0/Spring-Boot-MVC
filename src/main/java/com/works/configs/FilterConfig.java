package com.works.configs;

import com.works.entities.Login;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
        System.out.println("Server UP");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        String[] urls = {"/","/adminLogin","/register", "/adminRegister","/error"};
        boolean loginStatus = true;
        if ( url.contains("/h2-console") ) {
            loginStatus = false;
        }
        for( String item : urls ) {
            if ( item.equals(url) ) {
                loginStatus = false;
            }
        }
        if ( loginStatus ) {
            boolean sessionControl = req.getSession().getAttribute("user") == null;
            if ( sessionControl ) {
                res.sendRedirect("/");
            }else {
                // kullanıcı sisteme girince isimin üst kısımda yazması için buradan alacağız.
                Login login = (Login) req.getSession().getAttribute("user");
                // açılacak olan bütün sayfalara veri gönderme işlemleri
                req.setAttribute("user",login);
                chain.doFilter(req, res);
            }
        }else {
            chain.doFilter(req, res);
        }



    }

    @Override
    public void destroy() {
        System.out.println("Server DOWN");
    }

}
