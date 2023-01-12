package com.hbnu.Lwenku.controller;

import com.hbnu.Lwenku.model.Hon;
import com.hbnu.Lwenku.model.User;
import com.hbnu.Lwenku.service.HonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/BookServlet")
public class HonController extends HttpServlet {
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
    HonService honService=new HonService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dowhat=request.getParameter("dowhat");
        if ("search".equals(dowhat)){
            String by=request.getParameter("by");
            String param = request.getParameter("search");
            List<Hon> hons = honService.search(param, by);
            request.setAttribute("all",hons);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
        if ("add".equals(dowhat)){
            int heat=0;
            String cover =request.getParameter("cover");
            String name=request.getParameter("name");
            String author=request.getParameter("author");
            if (request.getParameter("heat")!=""){
                heat=Integer.parseInt(request.getParameter("heat"));
            }
            String date1=request.getParameter("date");
            String price=request.getParameter("price");
            Hon hon=new Hon();
            hon.setCover(cover);
            hon.setName(name);
            hon.setAuthor(author);
            hon.setHeat(heat);
            try {
                hon.setDate(sdf.parse(date1));
            }catch (ParseException e){
                System.out.println("日期转换出错："+e.getMessage());
            }
            hon.setPrice(price);
            honService.addHon(hon);
            response.sendRedirect(request.getContextPath()+"/BookServlet?dowhat=getall");
        }
        if ("update".equals(dowhat)){
            int heat=0;
            String cover =request.getParameter("cover");
            String name=request.getParameter("name");
            List<Hon> hons = honService.search(name, "1");
            String author=request.getParameter("author");
            if (request.getParameter("heat")!=""){
                heat=Integer.parseInt(request.getParameter("heat"));
            }
            String date1=request.getParameter("date");
            String price=request.getParameter("price");
            Hon hon=new Hon();
            hon.setId(hons.get(0).getId());
            hon.setCover(cover);
            hon.setName(name);
            hon.setAuthor(author);
            hon.setHeat(heat);
            try {
                hon.setDate(sdf.parse(date1));
            }catch (ParseException e){
                System.out.println("日期转换出错："+e.getMessage());
            }
            hon.setPrice(price);
            honService.updateHon(hon);
            response.sendRedirect(request.getContextPath()+"/BookServlet?dowhat=getall");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dowhat=request.getParameter("dowhat");
        if ("getall".equals(dowhat)){
            List<Hon> all=honService.getAllHon();
            request.setAttribute("all",all);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
        if("searchhot".equals(dowhat)){
            List<Hon> all=honService.orderByHot();
            request.setAttribute("all",all);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
        if("searchdate".equals(dowhat)){
            List<Hon> all=honService.orderByDate();
            request.setAttribute("all",all);
            request.getRequestDispatcher("/result.jsp").forward(request,response);
        }
        if("searchprice".equals(dowhat)){
            String year=request.getParameter("year");
            request.getSession().setAttribute("year",year);
            List<Hon> all=honService.getHonByPrice(year);
            request.setAttribute("all",all);
            request.getRequestDispatcher("/price.jsp").forward(request,response);
        }
        if ("recommend".equals(dowhat)){
            String name=request.getParameter("name");
            honService.toRecommend(name);
            HttpSession session=request.getSession();
            session.setAttribute("tipre","推荐成功，会有更多人看到这本书");
            request.getRequestDispatcher("/controller.jsp").forward(request,response);
        }
        if ("del".equals(dowhat)){
            User now=(User) request.getSession().getAttribute("now");
            String id=request.getParameter("id");
            if (honService.delHon(Integer.parseInt(id),now.getRoles().get(0).getId().toString())){
                response.sendRedirect(request.getContextPath()+"/BookServlet?dowhat=getall");
            }else {
                request.getSession().setAttribute("tipre","权限不够");
                request.getRequestDispatcher("/controller.jsp").forward(request,response);
            }
        }
        if("update".equals(dowhat)){
            User now=(User) request.getSession().getAttribute("now");
            String name=request.getParameter("name");
            if (honService.toUpdateUser(now.getRoles().get(0).getId().toString())){
                Hon hon = honService.search(name, "1").get(0);
                request.getSession().setAttribute("all",hon);
                response.sendRedirect(request.getContextPath()+"/update.jsp");
            }else {
                request.getSession().setAttribute("tipre","权限不够");
                request.getRequestDispatcher("/controller.jsp").forward(request,response);
            }

        }
    }
}
