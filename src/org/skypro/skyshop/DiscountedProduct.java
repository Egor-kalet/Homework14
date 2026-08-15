package org.skypro.skyshop;

public class DiscountedProduct extends Product{
    private int basePrice;
    private int discount;


    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getPrice() {
        double finalPrice = basePrice - (basePrice * (discount/100d));
        return (int) finalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return  getName() + ": " + getPrice() + " (" + getDiscount() + ")";
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
