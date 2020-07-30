package com.github.xrapalexandra.kr.service;

import com.github.xrapalexandra.kr.model.Order;
import com.github.xrapalexandra.kr.model.Status;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    void addOrder(Integer[] orderQuantities,
                  Integer[] productIds);

    List<Order> getUserOrders(String login);

    Page<Order> getAllOrders(int page);

    void changeOrderStatus(Integer orderId, Status status);

    void writeOffOrders();
}
