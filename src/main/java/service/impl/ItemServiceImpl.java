package service.impl;

import java.util.List;

import dao.impl.ItemDAOImpl;
import dao.ItemDAO;
import model.Item;
import service.ItemService;

public class ItemServiceImpl implements  ItemService {

    private ItemDAO itemDAO = new ItemDAOImpl();

    @Override
    public List<Item> getAllItem() {
        return itemDAO.getAllItem();
    }

    @Override
    public Item getItemById(int id) {
        return itemDAO.getItemById(id);
    }

    @Override
    public boolean addItem(Item item) {
        return itemDAO.addItem(item);
    }

    @Override
    public boolean updateItemById(Item item) {
        return itemDAO.updateItemById(item);
    }

    @Override
    public boolean removeItemById(int id) {
        return itemDAO.removeItemById(id);
    }
}
	

