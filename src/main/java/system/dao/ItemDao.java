package system.dao;

import system.model.Item;

import java.util.List;

public interface ItemDao {
    Item getItemById(int id);
    List<Item> getItemList();
}
