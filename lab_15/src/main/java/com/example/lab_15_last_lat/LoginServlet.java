package com.example.lab_15_last_lat;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

@WebServlet(name = "LogServlet", value = "/LogServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String inputLogin = (String) request.getParameter("login");
        String inputPass = (String) request.getParameter("password");
        String login = "";
        String password = "";
        String fileName = "logins.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        boolean rightPass = false;

        while (scanner.hasNextLine()){
            login = scanner.nextLine();
            if (scanner.hasNextLine()) {
                password = scanner.nextLine();
            }
            if(inputLogin.equals(login) && inputPass.equals(password)){
                rightPass = true;
                HttpSession session = request.getSession();
                session.setAttribute("login", inputLogin);
                session.setAttribute("password", inputPass);
                break;
            }
        }

        if (rightPass){
            response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("loginPage.html");
        }

    }
}
