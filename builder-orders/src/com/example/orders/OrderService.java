package com.example.orders;

import java.util.List;

public class OrderService {
    public Order createOrder(String id, String email, List<OrderLine> lines,
                             Integer discount, boolean expedited, String notes) {
        Order.Builder b = new Order.Builder(id, email);
        for (OrderLine l : lines) b.addLine(l);
        if (discount != null) b.setDiscountPercent(discount);
        b.setExpedited(expedited);
        if (notes != null) b.setNotes(notes);
        return b.build();
    }
}
