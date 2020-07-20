package com.github.xrapalexandra.kr.model;

public class OrderContentDTO {

    private Integer productId;

    private Integer orderQuantity;

    public OrderContentDTO(Integer productId, Integer orderQuantity) {
        this.productId = productId;
        this.orderQuantity = orderQuantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
