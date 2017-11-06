package com.itemsharing.itemservice.service.impl;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.repository.ItemRepository;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ItemServiceImpl implements ItemService {

    private static final Logger LOG = LoggerFactory.getLogger(ItemService.class);

    ItemRepository itemRepository;
    UserService userService;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, UserService userService) {
        this.itemRepository = itemRepository;
        this.userService = userService;
    }

    @Override
    public Item addItemByUser(Item item, String username) {
        Item localItem = itemRepository.findByName(item.getName());

        if(localItem != null) {
            LOG.info("Item with name {} already exists. Nothing will be done.", item.getName());
            return null;
        }
        else {
            item.setAddDate(new Date());

            User user = userService.getUserByUsername(username);
            item.setUser(user);
            Item newItem = itemRepository.save(item);

            return newItem;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public List<Item> getItemByUsername(String username) {
        return null;
    }

    @Override
    public Item getItemById(Long id) {
        return null;
    }

    @Override
    public Item updateItem(Item item) throws IOException {
        return null;
    }

    @Override
    public void deleteItemById(Long id) {

    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
