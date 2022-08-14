package com.hegde.orderservice.service;

import com.hegde.orderservice.dto.OrderRequestDto;
import com.hegde.orderservice.dto.OrderResponseDto;
import com.hegde.orderservice.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

 OrderResponseDto saveOrder(OrderRequestDto orderRequest);

}
