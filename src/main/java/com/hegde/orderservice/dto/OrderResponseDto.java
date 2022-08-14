package com.hegde.orderservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private String item;
    private int quantity;
    private double price;
    private String paymentStatus;
    private String transactionId;
    private String message;

}
