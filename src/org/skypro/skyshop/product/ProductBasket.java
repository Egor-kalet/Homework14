package org.skypro.skyshop.product;

import java.util.*;

public class ProductBasket {

    private Map<String,LinkedList<Product>> basket = new HashMap<>();
    String basketName = "Корзина 1";


    public void adProduct(Product product){
        if (product != null) {
            if (!basket.containsKey(basketName)){
                basket.put(basketName, new LinkedList<Product>());
            }
            basket.get(basketName).add(product);
        }
    }

    public void clearBasket(){
        basket.clear();

    }

    public void getBasket(){
        int sum = 0;
        int specialProducts = 0;
        if (!(basket.isEmpty())){
            for (Product element: basket.get(basketName)){
                System.out.println(element.toString());
                sum += element.getPrice();
                if (element.isSpecial()){
                    specialProducts++;
                }
            }
        }

        if (basket.isEmpty()){
            System.out.println("в корзине пусто");
        }else {
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + specialProducts);
        }
    }

    public boolean findProduct(String product){
        for (Product element: basket.get(basketName)){
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
        for (Product element: basket.get(basketName)){
            if (element != null){
                total += element.getPrice();
            }
        }
        return total;
    }

    public LinkedList<Product> deleteProduct(String name){
        LinkedList<Product> deleted = new LinkedList<>();
        if (name == null){
            System.out.println("Имя не задано");
        }else
        {
            for (LinkedList<Product> list: basket.values()) {
                Iterator<Product> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Product element = iterator.next();
                    if (Objects.equals(element.getName(), name)) {
                        deleted.add(element);
                        iterator.remove();
                    }
                }
            }
        }
        if (deleted.isEmpty()){
            System.out.println("Список пуст");
        }
        return deleted;
    }


}
