package com.hbnu.Lwenku.controller;


import com.hbnu.Lwenku.model.User;
import com.hbnu.Lwenku.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserServlet")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        String dowhat=request.getParameter("dowhat");
        if("logon".equals(dowhat)){  //注册
            String username=request.getParameter("id");
            String password=request.getParameter("password");
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            if(userService.registry(user)){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }else{
                HttpSession session=request.getSession();
                session.setAttribute("erro","注册错误");
                response.sendRedirect(request.getContextPath()+"/logon.jsp");
            }
        }
        if("login".equals(dowhat)){  //登录
            String autologin =request.getParameter("autologin");
            String username=request.getParameter("id");
            String password=request.getParameter("password");
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            if ((user=userService.login(user))!=null){
                request.setAttribute("id",username);
                HttpSession session=request.getSession();
                session.setAttribute("now",user);  //储存当前登录用户
                if(autologin !=null){
                    Cookie cookie =new Cookie("autologin",username + "-" +password);
                    cookie.setMaxAge(Integer.parseInt(autologin));
                    cookie.setPath(request.getContextPath());
                    response.addCookie(cookie);
                }
                request.getRequestDispatcher("/controller.jsp").forward(request,response);  //登录成功
            }else {
                HttpSession session=request.getSession();
                session.setAttribute("errop","再想想你的密码");
                request.getRequestDispatcher("/login.jsp").forward(request,response);  //登录失败返回登录页面并输出错误信息
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dowhat=request.getParameter("dowhat");
        if ("logout".equals(dowhat)){
            request.getSession().removeAttribute("now");
            Cookie cookie =new Cookie("autologin","null");
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }
}
