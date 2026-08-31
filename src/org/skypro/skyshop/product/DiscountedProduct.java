package org.skypro.skyshop.product;

import org.skypro.skyshop.Exceptions.DiscountProductDiscountException;
import org.skypro.skyshop.Exceptions.ProductPriceException;

public class DiscountedProduct extends Product{
    private int basePrice;
    private int discount;


    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0){
            throw new ProductPriceException();
        }

        if (discount < 0 || discount > 100){
            throw new DiscountProductDiscountException();
        }
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
