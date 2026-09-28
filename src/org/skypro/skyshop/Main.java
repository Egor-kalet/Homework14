package org.skypro.skyshop;

import org.skypro.skyshop.Exceptions.BestResultNotFound;
import org.skypro.skyshop.Exceptions.DiscountProductDiscountException;
import org.skypro.skyshop.Exceptions.ProductNameException;
import org.skypro.skyshop.Exceptions.ProductPriceException;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Product tomato = null;
        Product cheese = null;
        Product sausage = null;
        Product onion = null;
        Product mushroom = null;
        Product cucumber = null;
        Product bread = null;
        Product chocolate = null;
        Product water = null;

        try {
            tomato = new SimpleProduct("Tomato", 50);
            cheese = new DiscountedProduct("Cheese", 100, 30);
            sausage = new FixPriceProduct("Sausage");
            onion = new SimpleProduct("Onion", 40);
            mushroom = new SimpleProduct("Mushroom", 70);
            cucumber = new SimpleProduct("Cucumber", 60);
            bread = new SimpleProduct("Bread", 30);
            chocolate = new SimpleProduct("Сhocolate", 70);
            water = new SimpleProduct("Water", 40);
        } catch (ProductNameException e) {
            System.out.println("Значение названия товара пустое или задано некорректно");
        } catch (ProductPriceException e) {
            System.out.println("Цена товара должна быть больше нуля");
        } catch (DiscountProductDiscountException e) {
            System.out.println("Процент скидки должен быть числом в диапазоне от 0 до 100 включительно");
        }


        ProductBasket pb = new ProductBasket();

        Article f1 = new Article("Гран-при Монако: битва титанов на улицах княжества",
                "Обзор захватывающей гонки Формулы-1 в Монако, стратегии пилотов, неожиданные обгоны и борьба за чемпионские очки в самом престижном этапе сезона.");
        Article rally = new Article("Дакар-2025: экстремальный марафон через пустыни и горы",
                "Репортаж о легендарном ралли-рейде Дакар, сложнейшие этапы по пескам Саудовской Аравии, технические поломки и героизм экипажей на пределе возможностей.");
        Article nascar = new Article("Дайтона-500: 200 кругов адреналина на овале скорости",
                "Анализ главной гонки NASCAR, тактика драфтинга, массовые аварии на высокой скорости и борьба за победу в самой престижной гонке Америки.");
        Article drift = new Article("Короли заноса: чемпионат мира по дрифту в Японии",
                "Репортаж с этапа D1 Grand Prix, техника управляемого заноса, оценка судей за стиль и точность, интервью с пилотами о мастерстве контроля автомобиля.");
        Article lemans = new Article("24 часа Ле-Мана: марафон выносливости для машин и пилотов",
                "Хроника легендарной гонки на выносливость, смена экипажей, ночные заезды, борьба прототипов LMP1 и GT-классов за победу в самом сложном испытании автоспорта.");
        Article moto = new Article("MotoGP: королевский класс мотоциклетных гонок",
                "Обзор сезона MotoGP, противостояние заводских команд, невероятные наклоны в поворотах и скорость свыше 350 км/ч на прямых участках трасс.");
        Article karting = new Article("От картинга до Формулы-1: где рождаются чемпионы",
                "Исследование роли картинга как стартовой площадки для будущих звезд автоспорта, методики тренировок юных пилотов и развитие гоночных навыков с детства.");
        Article gtClass = new Article("Нюрбургринг-24: адская гонка на Северной петле",
                "Репортаж о суточной гонке на легендарной трассе Нюрбургринг, сложнейшие погодные условия, плотный трафик из 200 машин и борьба за выживание на трассе.");
        Article electric = new Article("Формула-E: тихая революция в мире автоспорта",
                "Анализ развития электрических гоночных серий, особенности стратегии с управлением энергией, городские трассы и привлечение новой аудитории к автоспорту.");
        Article historicle = new Article("Гудвудский фестиваль скорости: путешествие в прошлое автоспорта",
                "Обзор знаменитого фестиваля в Гудвуде, подъем на холм на классических болидах, встречи с легендами гонок и атмосфера праздника автомобильной истории.");


        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(tomato);
        searchEngine.add(cheese);
        searchEngine.add(sausage);
        searchEngine.add(onion);
        searchEngine.add(mushroom);
        searchEngine.add(cucumber);
        searchEngine.add(bread);
        searchEngine.add(chocolate);
        searchEngine.add(water);


        searchEngine.add(f1);
        searchEngine.add(rally);
        searchEngine.add(nascar);
        searchEngine.add(drift);
        searchEngine.add(lemans);
        searchEngine.add(moto);
        searchEngine.add(karting);
        searchEngine.add(gtClass);
        searchEngine.add(electric);
        searchEngine.add(historicle);


        System.out.println();
        Map<String, Searchable> results2 = searchEngine.search("Cucumber");
        System.out.println();
        Map<String, Searchable> results3 = searchEngine.search("марафон");
        System.out.println();
        Map<String, Searchable> results4 = searchEngine.search("o");
        System.out.println();
        Map<String, Searchable> results5 = searchEngine.search(",");


        System.out.println("1/////////////////////////");

        pb.adProduct(tomato);
        pb.adProduct(cheese);
        pb.adProduct(sausage);
        pb.adProduct(onion);
        pb.adProduct(mushroom);
        pb.adProduct(cucumber);
        pb.adProduct(bread);
        pb.adProduct(chocolate);
        pb.adProduct(water);


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

        pb.adProduct(tomato);
        pb.adProduct(cheese);
        pb.adProduct(sausage);
        pb.adProduct(onion);
        pb.adProduct(mushroom);
        pb.adProduct(cucumber);
        pb.adProduct(bread);
        pb.adProduct(chocolate);
        pb.adProduct(water);

        //9
        System.out.println("9/////////////////////////");
        System.out.println(pb.getTotalPrice());

        //10
        System.out.println("10/////////////////////////");
        System.out.println(pb.findProduct("Onion"));


        System.out.println(pb.deleteProduct("carrot"));

        System.out.println(pb.deleteProduct("Mushroom"));
        pb.getBasket();


    }
}