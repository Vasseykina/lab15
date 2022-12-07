package com.example.lab_15_last_lat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Products products = new Products();
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        HttpSession session = request.getSession();

        products.addProduct(name, description);
        products.setData();
        response.sendRedirect("index.jsp");
    }
}
