package com.github.xrapalexandra.kr.web.servlet;


import com.github.xrapalexandra.kr.service.ProductService;
import com.github.xrapalexandra.kr.service.impl.DefaultProductService;
import com.github.xrapalexandra.kr.web.WebUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminProductServlet", urlPatterns = {"/adminProduct"})
public class AdminProductServlet extends HttpServlet {

    ProductService productService = DefaultProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("productList", productService.getProductList(1));
        req.setAttribute("pageJsp", "/pages/adminProductList.jsp");
        WebUtils.forwardJSP("index", req, resp);
    }

}