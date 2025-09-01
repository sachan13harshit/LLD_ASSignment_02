package com.example.orders;

public class OrderLine {
    private final String sku;
    private final int quantity;
    private final int unitPriceCents;

    public OrderLine(String sku, int quantity, int unitPriceCents) {
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("SKU required");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        if (unitPriceCents < 0) throw new IllegalArgumentException("Price must be >= 0");
        this.sku = sku;
        this.quantity = quantity;
        this.unitPriceCents = unitPriceCents;
    }

    public String getSku() { return sku; }
    public int getQuantity() { return quantity; }
    public int getUnitPriceCents() { return unitPriceCents; }

}
