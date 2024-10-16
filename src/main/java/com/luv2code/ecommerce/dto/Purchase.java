package com.luv2code.ecommerce.dto;

import com.luv2code.ecommerce.entity.Address;
import com.luv2code.ecommerce.entity.Customer;
import com.luv2code.ecommerce.entity.Order;
import com.luv2code.ecommerce.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter

//OVA KLASA SLUZI ZA SLANJE PODATAKA IZMEDJU ANGULAR FRONT-ENDA I SPRING BOOT BACK-ENDA
public class Purchase {
    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
