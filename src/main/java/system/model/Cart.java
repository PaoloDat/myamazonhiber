package system.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int totalPrice;
    private int totalQuantity;
    private List<ItemInCart> order = new ArrayList<ItemInCart>();

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public List<ItemInCart> getOrder() {
        return order;
    }

    public void setOrder(List<ItemInCart> order) {
        this.order = order;
    }

    public void addItem (ItemInCart itemInCart) {
        order.add(itemInCart);
        this.totalPrice += itemInCart.getTotal();
        this.totalQuantity += itemInCart.getQuantity();
    }
}
