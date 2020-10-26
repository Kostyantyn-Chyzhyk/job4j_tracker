package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public void add(Item item) {
        item.setId(ids++);
        items[size++] = item;
    }

    public Item[] findAll(){
        int size = 0;
        Item[] itemsWithoutNull = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[size] = item;
                size++;
            }
        }
        itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
        return itemsWithoutNull;
    }

    public Item[] findByName(String key){
        int size = 0;
        Item[] itemsNames = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                itemsNames[index] = item;
                size++;
            }
        }
        itemsNames = Arrays.copyOf(itemsNames, size);
        return itemsNames;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.length; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean t = false;
        int i = this.indexOf(id);
        if (i != -1){
            items[i].setName(item.getName());
            t = true;
        }
        return t;
    }
}
