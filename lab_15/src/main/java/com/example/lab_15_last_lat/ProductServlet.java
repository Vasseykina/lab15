package com.example.lab_15_last_lat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ID = Integer.parseInt(request.getParameter("id"));
        Products products = new Products();
        Product product = products.getProduct(ID);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1 align=\"center\">Billboard</h1>");
        out.println("<h4>" + product.getName() + "<h4>");
        out.println("<h4>" + "Description: "+ product.getDescription() + "<h4>");
        out.println("<a href=\"index.jsp\">Back</a>");

        out.println("</body>");
        out.println("<html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
