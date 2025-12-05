package com.pedidosProject.Pedidos.Spring.entities;

import org.springframework.beans.factory.annotation.Autowired;


public class Order {

    private int code;
    private double value;
    private double discount;

    public Order() {
    }

    public Order(int code, double value, double discount) {
        this.code = code;
        this.value = value;
        this.discount = discount;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
