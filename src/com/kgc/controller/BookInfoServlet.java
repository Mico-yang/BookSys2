package com.kgc.controller;

import com.kgc.entity.bookInfo;
import com.kgc.entity.bookType;
import com.kgc.service.BookService;
import com.kgc.service.impl.BookServiceImpl;
import com.kgc.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/BookInfoServlet")
public class BookInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String method = request.getParameter("method");
        if("insert".equals(method)){
            doInsertBook(request, response);
        }else if ("delete".equals(method)){
            doDeleteBook(request, response);
        }else if ("findOne".equals(method)){
            doFindOne(request, response);
        }else if ("update".equals(method)){
            doUpdate(request, response);
        }else{
            doList(request, response);
        }
    }

    protected void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page == null){
            page="1"; //默认显示第一页
        }
        int currentPage = Integer.parseInt(page);
        //取调转
        BookService bookService = new BookServiceImpl();
        List<bookInfo> list = bookService.findAll();
        PageBean pb = new PageBean();
        //记录数  为pb设置记录数，已计算出总页面数
        pb.setTotalRows(list.size());
        pb.setCurrPage(currentPage);
        PageBean pageBean = bookService.findAllPage(pb);


        request.setAttribute("pb",pageBean);
        request.getRequestDispatcher("listBook.jsp").forward(request,response);
    }

    protected void doDeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        //取调转
        BookService bookService = new BookServiceImpl();
        bookService.deleteBook(id);
        response.sendRedirect("/BookInfoServlet");
    }

    protected void doInsertBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        Double price = Double.parseDouble(request.getParameter("book_price"));
        String pub = request.getParameter("book_pub");
        int state = Integer.parseInt(request.getParameter("book_state"));
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        bookInfo bookInfo = new bookInfo(name,author,price,pub,state,typeId);

        //取调转
        BookService bookService = new BookServiceImpl();
        bookService.insertBook(bookInfo);
        response.sendRedirect("BookInfoServlet");
    }

    protected void doFindOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        //取调转
        BookService bookService = new BookServiceImpl();
        bookInfo book = bookService.findOne(id);
        //book回显要修改的数据
        request.setAttribute("book",book);
        //回显图书分类
        request.setAttribute("tlist",bookService.findAllType());
        request.getRequestDispatcher("updateBook.jsp").forward(request,response);

    }

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("book_id"));
        String name = request.getParameter("book_name");
        String author = request.getParameter("book_author");
        Double price = Double.parseDouble(request.getParameter("book_price"));
        String pub = request.getParameter("book_pub");
        int state = Integer.parseInt(request.getParameter("book_state"));
        int typeId = Integer.parseInt(request.getParameter("type_id"));
        bookInfo bookInfo = new bookInfo(id,name,author,price,pub,state,typeId);

        //取调转
        BookService bookService = new BookServiceImpl();
        bookService.updateBook(bookInfo);
        response.sendRedirect("BookInfoServlet");
    }
}
