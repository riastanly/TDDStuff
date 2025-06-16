package org.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    @Test
    public void removeNonExistentItem() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.removeItem("2"));
    }
}