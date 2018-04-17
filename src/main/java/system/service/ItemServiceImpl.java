package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.dao.ItemDao;
import system.model.Item;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    public Item getItemById(int id) {
        return itemDao.getItemById(id);
    }

    public List<Item> getItemList() {
        return itemDao.getItemList();
    }
}
