package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 expected, but not enforced
    private final boolean expedited;
    private final String notes;

    private Order(Builder p) {
        this.id = p.id;
        this.customerEmail = p.customerEmail;
        this.lines = List.copyOf(p.lines);
        this.discountPercent = p.discountPercent;
        this.expedited = p.expedited;
        this.notes = p.notes;
    }

    public String getId() {
        return id; 
    }
    public String getCustomerEmail() { 
        return customerEmail;
    }
    public List<OrderLine> getLines() { 
        return List.copyOf(lines);
    } 
    public Integer getDiscountPercent() { 
        return discountPercent;
    }
    public boolean isExpedited() { 
        return expedited;
    }
    public String getNotes() { 
        return notes; 
    }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    public static class Builder {
        private String id;
        private String customerEmail;
        private List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id , String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            lines.add(line);
            return this; 
        }
        public Builder setDiscountPercent(Integer discountPercent) { 
            this.discountPercent = discountPercent;
            return this;
        }
        public Builder setExpedited(boolean expedited) { 
            this.expedited = expedited;
            return this;
        }
        public Builder setNotes(String notes) { 
            this.notes = notes;
            return this;
        }

        public Order build(){
            return new Order(this);
        }
    }
}
