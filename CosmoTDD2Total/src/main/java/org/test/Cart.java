package org.test;

import java.util.List;

public class Cart {
    public double calculateTotal(List<CartItem> items) {
        /*if (items.size() > 0) {
            double total = 0;
            for (CartItem item : items) {
               total += item.getQuantity() * item.getPrice();
            }
            return total;
        }
        return 0;*/
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}