package ecommerce.com.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        int index = findItemIndex(item.getProductId());
        if (index == -1) {
            items.add(item);
        } else {
            CartItem existingItem = items.get(index);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        }
    }

    public void removeItem(int productId) {
        int index = findItemIndex(productId);
        if (index != -1) {
            items.remove(index);
        }
    }

    public void updateItemQuantity(int productId, int quantity) {
        int index = findItemIndex(productId);
        if (index != -1) {
            CartItem item = items.get(index);
            item.setQuantity(quantity);
        }
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (CartItem item : items) {
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    private int findItemIndex(int productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId() == productId) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
