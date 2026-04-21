package com.diy.framework.web.server.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LecturesServlet extends HttpServlet {

    @Override
    public void init(final ServletConfig config) throws ServletException {
        System.out.println("init called.");
        super.init(config);
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet called.");
        request.getRequestDispatcher("lecture-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost called.");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()))) {
            String collect = br.lines().collect(Collectors.joining());
            System.out.println(collect);
        }

        // TODO json 변환해야함.
    }

    @Override
    protected void doPut(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPut called.");
        response.getWriter().write("put lectures");
    }

    @Override
    protected void doDelete(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doDelete called.");
        response.getWriter().write("delete lectures");
    }
}
