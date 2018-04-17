package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.ItemInOrdertDao;
import system.model.ItemInOrder;

@Service
public class ItemInOrderServiceImpl implements ItemInOrderService {

    @Autowired
    private ItemInOrdertDao itemInOrdertDao;

    public void addtoDb(ItemInOrder itemInOrder) {
        itemInOrdertDao.addtoDb(itemInOrder);
    }
}
