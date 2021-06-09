package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "remove":
                removeProduct(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.get(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response){
        List<Product> products = productService.display();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
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
                addProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String origin = request.getParameter("origin");
        Product product = new Product(id, name, price, description, origin);
        productService.update(id, product);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.remove(id);
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String origin = request.getParameter("origin");
        productService.add(new Product(name, price, description, origin));
        try {
            response.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
