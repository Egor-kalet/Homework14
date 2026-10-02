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
        if (!(basket.isEmpty())){
            basket.values().stream()
                    .flatMap(List::stream)
                    .forEach(e -> System.out.println(e.toString()));
        }
        int sum = basket.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();

        if (basket.isEmpty()){
            System.out.println("в корзине пусто");
        }else {
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + getSpecialCount(basket.get(basketName)));
        }
    }

    public boolean findProduct(String product){

        return basket.get(basketName).stream()
                .anyMatch(e -> Objects.equals(e.getName(), product));

    }

    public int getTotalPrice(){
        int total = basket.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
        return total;
    }

    public LinkedList<Product> deleteProduct(String name){
        LinkedList<Product> deleted = new LinkedList<>();
        if (name == null){
            System.out.println("Имя не задано");
        }else
        {
            deleted.addAll(basket.get(basketName).stream()
                    .filter(e -> Objects.equals(e.getName(), name))
                    .toList());
            basket.get(basketName).removeIf(e -> Objects.equals(e.getName(), name));
        }
        if (deleted.isEmpty()){
            System.out.println("Список пуст");
        }
        return deleted;
    }

    private long getSpecialCount(List<Product> products) {
        return products.stream()
                .filter(Product::isSpecial)
                .count();
    }

}
