package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import com.codegym.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/users")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "remove":
                removeUser(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    private void removeUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.remove(id);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response) {
        String query = request.getParameter("q");
        List<User> users = null;
        if (query == null || query == "") {
            users = userService.findAll();
        } else {
            users = userService.findById(Integer.parseInt(query));
        }
        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addUser(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }
    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        userService.add(user);
        try {
            response.sendRedirect("/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
