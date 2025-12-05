package com.pedidosProject.Pedidos.Spring.services;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {


    public double getShippingFee(double value) {
        if (value < 100.0) {
            return 20.0; // Frete para valores abaixo de 100
        } else if (value < 200.0) {
            // Se chegou aqui, o valor é >= 100 e < 200
            return 12.0; // Frete para valores entre 100 e 199.99
        } else {
            // Valor >= 200
            return 0.0; // Frete grátis
        }
    }
}