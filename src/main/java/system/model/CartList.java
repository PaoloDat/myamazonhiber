package system.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cartslist")
public class CartList implements Serializable {
    private int id;
    private String name;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "cart_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

