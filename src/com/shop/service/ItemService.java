package com.shop.service;

import java.util.*;

import com.shop.domain.Item;

public class ItemService {
	
	public Collection<Item> fetchAllItems() {
		
		return (Collection<Item>)database().values();
}




private Map<Integer,Item> database() {
	Map<Integer,Item> items=new HashMap<>();
	items.put(1, new Item(1, "lamp", 64.78f));
	items.put(2, new Item(2, "table", 94.56f));
	items.put(3, new Item(3, "chair", 124.00f));
	return items;
}

public Item getItemById(int id) {
	return database().get(id);
}




}
