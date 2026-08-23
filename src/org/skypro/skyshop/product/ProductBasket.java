package org.skypro.skyshop.product;

import java.util.Objects;

public class ProductBasket {

    private Product[] basket = new Product[5];


    public void adProduct(Product product){
        if (product != null) {

            int c = 0;

            for (int i = 0; i < basket.length; i++) {
                if (basket[i] == null) {
                    basket[i] = product;
                    c = 1;
                    break;
                }
            }
            if (c == 0) {
                System.out.println("Невозможно добавить продукт");
            }
        }
    }

    public void clearBasket(){
        for (int i = 0; i < basket.length; i++){
            basket[i] = null;
        }
    }

    public void getBasket(){
        int sum = 0;
        int i = 0;
        int c = 0;
        int specialProducts = 0;
        for (Product element: basket){
            if (element != null){
                System.out.println(element.toString());
                sum += element.getPrice();
                c = 1;
                if (element.isSpecial()){
                    specialProducts++;
                }
            }
        }
        if (c == 0){
            System.out.println("в корзине пусто");
        }else {
            System.out.println("Итого: " + sum);
        }
        System.out.println("Специальных товаров: " + specialProducts);
    }

    public boolean findProduct(String product){
        for (Product element: basket){
            if (element != null){
                if (Objects.equals(element.getName(),product)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getTotalPrice(){
        int total = 0;
        for (Product element: basket){
            if (element != null){
                total += element.getPrice();
            }
        }
        return total;
    }

}
