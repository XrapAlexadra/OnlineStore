package com.github.xrapalexandra.kr.dao;

import com.github.xrapalexandra.kr.model.Order;
import com.github.xrapalexandra.kr.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;


public interface ProductDao {

    Integer saveProduct(Product product);

    void deleteProduct(Integer productId);

    Product getProductById(Integer id);

    Page<Product> getProductList(int page, int number);

    void updateQuantityByOrder(Order order);

    List<Product> getProductListByIds(List<Integer> ids);

    Product getProductByName(String name);
}
