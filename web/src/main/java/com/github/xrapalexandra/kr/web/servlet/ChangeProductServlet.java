package com.github.xrapalexandra.kr.web.servlet;

import com.github.xrapalexandra.kr.model.Product;
import com.github.xrapalexandra.kr.service.ProductService;
import com.github.xrapalexandra.kr.service.impl.DefaultProductService;
import com.github.xrapalexandra.kr.web.WebUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChangeProductServlet extends HttpServlet {

    ProductService productService = DefaultProductService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("pId") == null)
            WebUtils.forward("adminProduct", req, resp);
        Product product = productService.getProductById(Integer.parseInt(req.getParameter("pId")));
        req.setAttribute("product", product);
        req.setAttribute("pageJsp", "/pages/changeProduct.jsp");
        WebUtils.forwardJSP("index", req, resp);
//        Product product = new Product();
//        product.setName(req.getParameter("name"));
//        product.setPrice(Integer.parseInt(req.getParameter("price")));
//        product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
//        product.setId(Integer.parseInt(req.getParameter("productId")));
//        if (!productService.updateProduct(product))
//            req.setAttribute("error", "Невозможно изменить товар! Такой уже существует!");
//        WebUtils.forward("productList", req, resp);
    }
}
