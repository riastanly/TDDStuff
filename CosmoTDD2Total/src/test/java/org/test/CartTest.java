package org.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    @Test
    public void calculateTotalShouldReturnZeroForEmptyCart() {
        List<CartItem> items = List.of(
                new CartItem("Apple", 0.5, 3),
                new CartItem("Banana", 0.3, 2)
        );

        Cart cart = new Cart();
        double total = cart.calculateTotal(items);

        assertEquals(2.1, total, 0.001);
    }
}