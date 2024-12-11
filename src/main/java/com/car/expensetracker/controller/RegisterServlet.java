package com.car.expensetracker.controller;

import com.car.expensetracker.dao.UserDAO;
import com.car.expensetracker.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserDAO userDAO = new UserDAO();
        boolean isRegistered = userDAO.registerUser(user);

        if (isRegistered) {
            response.sendRedirect("index.jsp?message=Registration successful");
        } else {
            response.sendRedirect("register.jsp?error=Registration failed");
        }
    }
}
