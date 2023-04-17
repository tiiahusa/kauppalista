package com.example.kauppalista;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class GroceryList {

    private static GroceryList list = null; // GroceryList singleton setting
    private SortedMap<String, Grocery> listByName = new TreeMap<>(); //GroceryList order by grocery name
    private SortedMap<LocalDateTime, Grocery> listByTime = new TreeMap<>(); // Grocerylist order by adding time
    private ArrayList<Grocery> returnList = new ArrayList<>();
    private ArrayList<Grocery> groceries = new ArrayList<>();
    private GroceryList() { // builder must be private for singleton grocery list

    }

    public static GroceryList getInstance() { // Do list if we haven't it yet
        if (list == null) {
            list = new GroceryList();
        }
        return list;
    }

    public void addGroceryToList (Grocery grocery) {
        groceries.add(grocery);
    }

    public void deleteGroceryFromList (String id) {
        int i = 0;
        for (Grocery gro: groceries) {
            if(gro.getId().equals(id)) {
                break;
            }
            i++;
        }
        groceries.remove(i);
    }

    public ArrayList<Grocery> getGroceries() {
        return groceries;
    }

    public void orderListByName() {
        listByName.clear();
        for (Grocery gro: groceries) {
            listByName.put(gro.getGrocery(), gro);
        }
        groceries.clear();
        for(String key : listByName.keySet() ) {
            groceries.add(listByName.get(key));
        }
    }

    public void orderListByTime() {
        listByTime.clear();
        for (Grocery gro: groceries) {
            listByTime.put(gro.getTime(), gro);
        }
        groceries.clear();
        for(LocalDateTime key : listByTime.keySet() ) {
            groceries.add(listByTime.get(key));
        }

    }

    public Grocery getGroceryById (int id) {
        return groceries.get(id);
    }

}