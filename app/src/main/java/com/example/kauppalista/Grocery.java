package com.example.kauppalista;

import android.os.Build;

import java.time.LocalDateTime;

public class Grocery {

    private String grocery;
    private String rem;
    private LocalDateTime time;
    private String id;

    public Grocery(String grocery, String rem) {
        this.grocery = grocery;
        this.rem = rem;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // If version is ok, take time
            this.time = LocalDateTime.now();
        }
        id = "NCC-" + (int)(Math.random() * 90000 + 1000);
    }

    public String getGrocery() {
        return grocery;
    }

    public String getRem() {
        return rem;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTimeToString() {
        return time.toString();
    }

    public void setGrocery(String grocery) {
        this.grocery = grocery;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // If version is ok, take time
            this.time = LocalDateTime.now();
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setRem(String rem) {
        this.rem = rem;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) { // If version is ok, take time
            this.time = LocalDateTime.now();
        }
    }
}
