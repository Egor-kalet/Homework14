package org.skypro.skyshop;

public class FixPriceProduct extends Product{

    private static final int FIX_PRICE_PRODUCT = 50;



    public FixPriceProduct(String name) {
        super(name);
    }

    public  int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return  getName() + ": Фиксированная цена " + getPrice();
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
