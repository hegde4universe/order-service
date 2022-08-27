package com.hegde.orderservice.controller;

import com.hegde.orderservice.dto.OrderRequestDto;
import com.hegde.orderservice.dto.OrderResponseDto;
import com.hegde.orderservice.entity.Order;
import com.hegde.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/book")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderRequest) {
        return orderService.saveOrder(orderRequest);
    }
}
