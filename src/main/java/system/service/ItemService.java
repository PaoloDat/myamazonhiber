package system.service;

import system.model.Item;

import java.util.List;

public interface ItemService {
    Item getItemById(int id);
    List<Item> getItemList();
}
