package com.pedidosProject.Pedidos.Spring.services;

import com.pedidosProject.Pedidos.Spring.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

//    Injetado serviço de frete
    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }


    public double calculateFinalValue(Order order) {

        double totalWithDiscount = order.getValue() * (1 - (order.getDiscount() / 100.0));


        double shippingFee = shippingService.getShippingFee(totalWithDiscount);


        return totalWithDiscount + shippingFee;
    }
}