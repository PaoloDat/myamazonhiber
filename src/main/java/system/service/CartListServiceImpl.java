package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.CartListDao;
import system.model.CartList;

@Service
public class CartListServiceImpl implements CartListService {
    @Autowired
    private CartListDao cartListDao;

    public CartList addCart(CartList cartList) {
        return cartListDao.addCart(cartList);
    }

    public int getLastId() {
        return cartListDao.getLastId();
    }
}
