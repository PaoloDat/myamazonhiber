package system.service;

import system.model.CartList;

public interface CartListService {
    CartList addCart(CartList cartList);
    int getLastId ();
}
