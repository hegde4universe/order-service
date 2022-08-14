package com.hegde.orderservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PaymentRequestDto {
    private int orderId;
    private double amount;
}
