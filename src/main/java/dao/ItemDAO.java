package dao;

import java.util.List;
import model.Item;

public interface ItemDAO {
    List<Item> getAllItem();
    Item getItemById(int id);
    boolean addItem(Item item);
    boolean updateItemById(Item item);
    boolean removeItemById(int id);
}
