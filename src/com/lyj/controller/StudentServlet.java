package com.lyj.controller;

import com.lyj.Dao.IStudentDao;
import com.lyj.Dao.Impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet(name="StudentServlet",urlPatterns = "/StudentServlet")
public class StudentServlet extends HttpServlet {
      IStudentDao studentDao=new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        switch (action){
            case "login":
                login(request,response);
                break;
            default:
                break;

        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        Integer id = studentDao.getStudent(username, password);
        if(id>0){
            //登录成功
            String remember = request.getParameter("remember");
            if(remember!=null){
                Cookie cookie = new Cookie("username", URLEncoder.encode(username,"utf-8"));
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("id",id);
            response.sendRedirect("index.jsp");
        }else {
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
