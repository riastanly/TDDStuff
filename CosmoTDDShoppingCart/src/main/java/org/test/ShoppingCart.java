package org.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private float manualDiscount = 0;
    private static final Map<String, Float> discountCodes = Map.of(
            "HOLIDAY25", 25f,
            "SUMMER10", 10f
    );

    public int getItemCount() {
        int count = 0;
        for (Item item : items) {
            count += item.getQuantity();
        }
        return count;
    }

    public void addItem(Item newItem, int quantity) {
        for (Item item : items) {
            if (item.getId().equals(newItem.getId())) {
                if (item.getQuantity() + quantity > 10) {
                    throw new IllegalArgumentException("Maximum quantity exceeded");
                }
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        newItem.setQuantity(quantity);
        items.add(newItem);
    }

    public float getTotalCost() {
        float total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        float discountToApply = manualDiscount;
        if (total > 150) {
            discountToApply += 10;
        }
        return applyDiscount(total, discountToApply);
    }

    public float applyDiscount(float total, float discount) {
        return (total - (discount/100) * total);
    }

    public void applyDiscount(float discount) {
        this.manualDiscount = discount;
    }

    public void applyDiscountCode(String code) {
        if (discountCodes.containsKey(code)) {
            this.manualDiscount = discountCodes.get(code);
        } else {
            throw new IllegalArgumentException("Invalid discount code");
        }
    }

    public void removeItem(String id) {
        Iterator<Item> iterator = items.iterator();
        boolean hasItem = false;
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId().equals(id)) {
                hasItem = true;
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                } else {
                    iterator.remove();
                }
                break;
            }
        }

        if (!hasItem) {
            throw  new IllegalArgumentException("Item not found");
        }
    }

    public void clear() {
        items.clear();
        manualDiscount = 0;
    }

    public void updateQuantity(String id, int quantity){
        for (Item item : items) {
            if (id.equals(item.getId())) {
                if (quantity > 10) {
                    throw new IllegalArgumentException("Maximum quantity exceeded");
                }
                item.setQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }

    public Item getItem(String id) {
        for (Item item: items) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
}
