package com.clinic.model;

public class Bill {
    private int billId;
    private int visitId;
    private double totalAmount;
    private String paymentStatus;

    public Bill() {}

    public Bill(int visitId, double totalAmount, String paymentStatus) {
        this.visitId = visitId;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    // getters and setters
}
