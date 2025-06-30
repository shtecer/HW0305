package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.articles.BestResultNotFound;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Product[] product = new Product[6];
        product[0] = new SimpleProduct("яблоко", 150);
        product[1] = new FixPriceProduct("банан");
        product[2] = new DiscountedProduct("лимон", 200, 15);
        product[3] = new DiscountedProduct("апельсин", 220, 30);
        product[4] = new SimpleProduct("киви", 240);
        product[5] = new SimpleProduct("виноград", 280);

        ProductBasket basket = new ProductBasket();

        basket.addProductInBasket(product[0]);
        basket.addProductInBasket(product[1]);
        basket.addProductInBasket(product[2]);
        basket.addProductInBasket(product[3]);
        basket.addProductInBasket(product[4]);


        //Печать содержимого корзины с несколькими товарами
        basket.printProductBasket();
        System.out.println();

        //Получение стоимости корзины с несколькими товарами
        System.out.println("Стоимость корзины: " + basket.summOfBasket());
        System.out.println();

        //Поиск товара, который есть в корзине
        System.out.println(basket.checkContains("лимон"));
        System.out.println();

        //Поиск товара, которого нет в корзине
        System.out.println(basket.checkContains("грейпфрут"));
        System.out.println();

        //Очистка корзины
        basket.clearProductBasket();

        System.out.println("Печать содержимого пустой корзины:");
        basket.printProductBasket();
        System.out.println();

        //Получение стоимости пустой корзины
        System.out.println("Стоимость корзины: " + basket.summOfBasket());
        System.out.println();

        //Поиск товара по имени в пустой корзине
        System.out.println(basket.checkContains("яблоко"));


        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(product[0]);
        searchEngine.add(product[1]);
        searchEngine.add(product[2]);
        searchEngine.add(product[3]);
        searchEngine.add(product[4]);
        searchEngine.add(product[5]);


        Article article1 = new Article("булочки", "книга рецептов");
        Article article2 = new Article("картофель", "советы по выращиванию");
        Article article3 = new Article("нарезка", "варианты сервировки");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        System.out.println(" ");
        try {
            Product product1= new SimpleProduct("   ", 17);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            Product product2 = new SimpleProduct("Ананас", -5);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            Product product3 = new DiscountedProduct("Томаты", -50, 150);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            Product product4 = new DiscountedProduct("Арбуз", 50, 150);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }


        try {
            Searchable result = searchEngine.findBestMatch("лимон");
            System.out.println("Найдено: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }

        try {
            Searchable result = searchEngine.findBestMatch("черепица");
            System.out.println("Найдено: " + result.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.err.println(e.getMessage());
        }

        ProductBasket basket2 = new ProductBasket();
        basket2.addProductInBasket(product[0]);
        basket2.addProductInBasket(product[1]);
        basket2.addProductInBasket(product[2]);
        basket2.addProductInBasket(product[3]);
        basket2.addProductInBasket(product[4]);

        System.out.println("Корзина2");
        basket2.printProductBasket();

        List<Product> removed = basket2.removeProductsByName("киви");
        System.out.println("Удаленное");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removed) {
                System.out.println(p);
            }
      }

        System.out.println("После удаления");
        basket2.printProductBasket();

        List<Product> removedNonExist = basket2.removeProductsByName("Молоко");
        System.out.println("Удаленное");
        if (removedNonExist == null || removedNonExist.isEmpty()) {
            System.out.println("Ничего нет");
        } else {
            for (Product p : removedNonExist) {
                System.out.println(p);
            }
        }

        basket2.printProductBasket();
    }
}