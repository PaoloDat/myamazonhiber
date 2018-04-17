package system.dao;

import system.model.CartList;

public interface CartListDao {
   CartList addCart(CartList cartList);
   int getLastId ();
}
