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
    private GroceryList() { // builder must be private for singleton grocery list

    }

    public static GroceryList getInstance() { // Do list if we haven't it yet
        if (list == null) {
            list = new GroceryList();
        }
        return list;
    }

    public void addGroceryToList (Grocery grocery) {
        listByName.put(grocery.getGrocery(), grocery);
        listByTime.put(grocery.getTime(), grocery);
    }

    public ArrayList<Grocery> getListByName() {
        returnList.clear();
        for(String key : listByName.keySet() ) {
            returnList.add(listByName.get(key));
        }
        return returnList;
    }

    public ArrayList<Grocery> getListByTime() {
        returnList.clear();
        for(LocalDateTime key : listByTime.keySet() ) {
            returnList.add(listByTime.get(key));
        }
        return returnList;

    }

}
