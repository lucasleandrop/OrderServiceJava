package com.pedidosProject.Pedidos.Spring;

import com.pedidosProject.Pedidos.Spring.entities.Order;
import com.pedidosProject.Pedidos.Spring.services.OrderService;
// Remova a importação de ShippingService aqui, pois ele é injetado em OrderService
import java.util.Scanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedidosSpringApplication implements CommandLineRunner {


    private final OrderService orderService;


    public PedidosSpringApplication(OrderService orderService) {
        this.orderService = orderService;

    }

    public static void main(String[] args) {
        SpringApplication.run(PedidosSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- CÁLCULO DE PEDIDO ---");

        System.out.print("Digite o código do pedido: ");
        int code = sc.nextInt();

        System.out.print("Digite o valor base do pedido (R$): ");
        double value = sc.nextDouble();

        System.out.print("Digite a porcentagem de desconto (ex: 15 para 15%): ");
        double discount = sc.nextDouble();

        Order order = new Order(code, value, discount);


        double finalValue = orderService.calculateFinalValue(order);

        System.out.println("\n--- DETALHES DO PEDIDO ---");
        System.out.println("Código do Pedido: " + order.getCode());
        System.out.printf("Valor Original: R$ %.2f%n", order.getValue());
        System.out.printf("Desconto Aplicado: %.2f%%%n", order.getDiscount());
        System.out.printf("Valor Total a Pagar (com frete de ): R$ **%.2f**%n", finalValue);

        sc.close();
    }
}