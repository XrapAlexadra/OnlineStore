package com.github.xrapalexandra.kr.model;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Integer> basket = new ArrayList<>();

    public void addProductId(int productId){
        if (!basket.contains(productId))
            basket.add(productId);
    }

    public void delProduct(Integer productId){
        basket.remove(productId);
    }

    public List<Integer> getOrdersIds(){
        return new ArrayList<>(basket);
    }

}
