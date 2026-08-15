package org.skypro.skyshop;

import java.util.Objects;

public abstract class Product {
    private final String name;


    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
}
