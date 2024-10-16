package com.luv2code.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// OVA KLASA SLUZI ZA SLANJE JAVA OBJEKTA KAO JSON OBJEKAT
@Getter
@Setter
@AllArgsConstructor
public class PurchaseResponse {
    private String orderTrackingNumber;
}
