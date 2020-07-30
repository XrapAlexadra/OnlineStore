package com.github.xrapalexandra.kr.service.impl;

import com.github.xrapalexandra.kr.dao.OrderDao;
import com.github.xrapalexandra.kr.dao.ProductDao;
import com.github.xrapalexandra.kr.model.*;
import com.github.xrapalexandra.kr.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Transactional
public class DefaultOrderService implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int MAX_NUMBER_ORDER_ON_PAGE = 4;

    private final OrderDao orderDao;
    private final ProductDao productDao;

    public DefaultOrderService(OrderDao orderDao, ProductDao productDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
    }

    @Override
    public void addOrder(Integer[] orderQuantities,
                         Integer[] productIds) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<OrderContent> orderContentList = createOrderContent(orderQuantities, productIds);
        Order order = new Order(user, orderContentList, Status.ORDER);
        order.setId(orderDao.addOrder(order));
        logger.info("{} add into DataBase", order);
    }

    private List<OrderContent> createOrderContent(Integer[] orderQuantities,
                                                  Integer[] productIds) {
        List<OrderContent> orderContentList = new ArrayList<>();
        List<Product> productList = productDao.getProductListByIds(Arrays.asList(productIds));
        for (int i = 0; i < productIds.length; i++) {
            orderContentList.add(
                    new OrderContent(productList.get(i), orderQuantities[i]));
        }
      return orderContentList;
    }

    @Override
    public List<Order> getUserOrders(String login) {
        return orderDao.getUserOrders(login);
    }

    @Override
    public Page<Order> getAllOrders(int page) {
        return orderDao.getAllOrders(page,MAX_NUMBER_ORDER_ON_PAGE);
    }

    @Override
    public void changeOrderStatus(Integer orderId, Status status) {
        orderDao.changeOrderStatus(orderId, status);
        logger.info("Order id {} change status {}.", orderId, status);
    }

    @Override
    public void writeOffOrders() {
        List<Order> paidOrders = orderDao.getPaidOrders();
        if (paidOrders != null)
            for (Order order : paidOrders) {
                productDao.updateQuantityByOrder(order);
                logger.info("Update products quantity with order id{}", order);
                orderDao.deleteOrder(order.getId());
                logger.info("{} delete from DataBase", order.getId());
            }
    }
}
