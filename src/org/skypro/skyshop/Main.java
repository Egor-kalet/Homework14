package org.skypro.skyshop;

public class Main {
    public static void main(String[] args) {

        Product tomato = new Product("Tomato",50);
        Product cheese = new Product("Cheese",100);
        Product sausage = new Product("Sausage",120);
        Product onion = new Product("Onion",40);
        Product mushroom = new Product("Mushroom",70);
        Product cucumber = new Product("Cucumber",60);


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

    }
}