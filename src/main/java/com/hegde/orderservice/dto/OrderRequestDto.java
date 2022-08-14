package com.hegde.orderservice.dto;

import lombok.Getter;

@Getter
public class OrderRequestDto {

    private int orderId;
    private String item;
    private int quantity;
    private double price;
}
