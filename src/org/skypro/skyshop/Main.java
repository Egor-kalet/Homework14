package org.skypro.skyshop;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Product tomato = new SimpleProduct("Tomato",50);
        Product cheese = new DiscountedProduct("Cheese",100, 20);
        Product sausage = new FixPriceProduct("Sausage");
        Product onion = new SimpleProduct("Onion",40);
        Product mushroom = new SimpleProduct("Mushroom",70);
        Product cucumber = new SimpleProduct("Cucumber",60);

        ProductBasket pb = new ProductBasket();

        //1
        System.out.println("1/////////////////////////");
        pb.adProduct(tomato);
        pb.adProduct(cheese);
        pb.adProduct(sausage);
        pb.adProduct(onion);
        pb.adProduct(mushroom);

        //2
        System.out.println("2/////////////////////////");
        pb.adProduct(cucumber);

        //3
        System.out.println("3/////////////////////////");
        pb.getBasket();

/*
        //4
        System.out.println("4/////////////////////////");
        System.out.println(pb.getTotalPrice());

        //5
        System.out.println("5/////////////////////////");
        System.out.println(pb.findProduct("Onion"));

        //6
        System.out.println("6/////////////////////////");
        System.out.println(pb.findProduct("carrot"));

        //7
        System.out.println("7/////////////////////////");
        pb.clearBasket();

        //8
        System.out.println("8/////////////////////////");
        pb.getBasket();

        //9
        System.out.println("9/////////////////////////");
        System.out.println(pb.getTotalPrice());

        //10
        System.out.println("10/////////////////////////");
        System.out.println(pb.findProduct("Onion"));
*/

    }
}