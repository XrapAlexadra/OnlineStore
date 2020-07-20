package com.github.xrapalexandra.kr.web.servlet;

import com.github.xrapalexandra.kr.model.OrderDTO;
import com.github.xrapalexandra.kr.model.Product;
import com.github.xrapalexandra.kr.model.User;
import com.github.xrapalexandra.kr.service.BasketService;
import com.github.xrapalexandra.kr.service.ProductService;
import com.github.xrapalexandra.kr.service.impl.DefaultBasketService;
import com.github.xrapalexandra.kr.service.impl.DefaultProductService;
import com.github.xrapalexandra.kr.web.BasketBean;
import com.github.xrapalexandra.kr.web.WebUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class BasketServlet extends HttpServlet {

    ProductService productService = DefaultProductService.getInstance();
    BasketService basketService = DefaultBasketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        BasketBean bean = (BasketBean) session.getAttribute("basket");
        if (bean != null) {
            List<Product> basket = new ArrayList<>();
            for (int product_id : bean.getOrders())
                basket.add(productService.getProductById(product_id));
            req.setAttribute("basket", basket);
        }

        User user = (User) session.getAttribute("user");
        if (user != null) {
            List<OrderDTO> orderInProcess = basketService.getOrdersByUserId(user.getUserId());
            req.setAttribute("orderInProcess", orderInProcess);
        }
        req.setAttribute("pageJsp", "/pages/basket.jsp");
        WebUtils.forwardJSP("index", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }
}
