package system.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "carts")
public class ItemInOrder implements Serializable {
    private int id;
    private int cartNumber;
    private int itemId;
    private int quantity;
    private int total;

    public ItemInOrder() {
    }

    public ItemInOrder(int cartNumber, int itemId, int quantity, int total) {
        this.cartNumber = cartNumber;
        this.itemId = itemId;
        this.quantity = quantity;
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "cartslist_id")
    public int getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(int cartNumber) {
        this.cartNumber = cartNumber;
    }

    @Column(name = "items_id")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "total")
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
