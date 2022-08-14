package com.hegde.orderservice.service;

import com.hegde.orderservice.dto.OrderRequestDto;
import com.hegde.orderservice.dto.OrderResponseDto;
import com.hegde.orderservice.dto.PaymentRequestDto;
import com.hegde.orderservice.entity.Order;
import com.hegde.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public OrderResponseDto saveOrder(OrderRequestDto orderRequest) {
        Order order = new Order();
        order.setOrderId(orderRequest.getOrderId());
        order.setItem(orderRequest.getItem());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        orderRepository.save(order);

        //call payment-service to get payment status and transactionId
        PaymentRequestDto paymentRequestDto = PaymentRequestDto.builder().orderId(orderRequest.getOrderId()).amount(orderRequest.getPrice()).build();
        OrderResponseDto responseDto = restTemplate.postForObject("http://localhost:9192/payment/makePayment",
                                                                    paymentRequestDto, OrderResponseDto.class);
        String info = responseDto.getPaymentStatus().equalsIgnoreCase("SUCCESS") ? "Order placed!" : "Order failed, please try again";
        return OrderResponseDto.builder().paymentStatus(responseDto.getPaymentStatus())
                                         .transactionId(responseDto.getTransactionId())
                                         .message(info).build();
    }
}
