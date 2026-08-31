package org.skypro.skyshop.product;

import org.skypro.skyshop.ProductPriceException;

public class SimpleProduct extends Product{
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);

        if (price <= 0){
            throw new ProductPriceException();
        }
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  getName() + ": " + getPrice();
    }


    @Override
    public boolean isSpecial(){
        return false;
    }
}
