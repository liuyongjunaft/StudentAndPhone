package com.lyj.controller;

import com.lyj.Dao.IPhoneDao;
import com.lyj.Dao.Impl.PhoneDaoImpl;
import com.lyj.entity.Phone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "PhoneServlet",urlPatterns = "/PhoneServlet")
public class PhoneServlet extends HttpServlet {
        IPhoneDao phoneDao=new PhoneDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        switch (action){
            case "getPhoneBySid":
                getPhoneBySid(request,response);
                break;
            case "getPhoneBYid":
                getPhoneBYid(request,response);
                break;
            case "upDatePhone":
                upDatePhone(request,response);
                break;
            case "deletePhoneById":
                deletePhoneById(request,response);
                break;
            case "addPhone":
                addPhone(request,response);
                break;
            case "deletePhoneAll":
                deletePhoneAll(request,response);
                break;
            default:
                break;
        }

    }

    private void deletePhoneAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        String[] str=id.split(",");
        System.out.println(str);
        int num;
        if(str.length>0){
            for(int i=0;i<str.length;i++){
                num= Integer.parseInt(str[i]);
                phoneDao.deletePhoneById(num);
            }
        }
       response.sendRedirect("PhoneServlet?action=getPhoneBySid");
    }

    private void addPhone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String relation = request.getParameter("relation");
        String tel = request.getParameter("tel");
        Integer sid = (Integer)request.getSession().getAttribute("id");

        Integer count1 = phoneDao.countPhoneByRelation(relation);
        if(count1>0){
            request.setAttribute("msg","关系重复了");
            request.getRequestDispatcher("addPhone.jsp").forward(request,response);
            return;
        }
        Phone phone = new Phone(relation, tel, sid);
        Integer count = phoneDao.addPhone(phone);
        if (count>0){
            response.sendRedirect("PhoneServlet?action=getPhoneBySid");
        }
    }

    private void deletePhoneById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Integer count = phoneDao.deletePhoneById(Integer.parseInt(id));
        if (count>0){
            response.sendRedirect("PhoneServlet?action=getPhoneBySid");
        }
    }

    private void upDatePhone(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String relation = request.getParameter("relation");
        String tel = request.getParameter("tel");
        String id = request.getParameter("id");
        int i_id = Integer.parseInt(id);
        Integer count = phoneDao.upDatePhone(i_id,relation,tel);
        if(count>0){
            request.setAttribute("msg","已修改成功");
            request.getRequestDispatcher("PhoneServlet?action=getPhoneBySid").forward(request,response);
        }

    }

    private void getPhoneBYid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Phone phone = phoneDao.getPhoneBYid(Integer.parseInt(id));
        request.setAttribute("phone",phone);
        request.getRequestDispatcher("upDatePhone.jsp").forward(request,response);

    }


    private void getPhoneBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer sid = (Integer)request.getSession().getAttribute("id");
        List<Phone> list = phoneDao.getPhoneBySid(sid);
        request.setAttribute("list",list);
        request.getRequestDispatcher("phonelist.jsp").forward(request,response);
    }


}
