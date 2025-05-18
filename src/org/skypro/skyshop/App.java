package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.articles.SearchEngine;
import org.skypro.skyshop.articles.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

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

        //Добавление товара в корзину
        basket.addProductInBasket(product[0]);
        basket.addProductInBasket(product[1]);
        basket.addProductInBasket(product[2]);
        basket.addProductInBasket(product[3]);
        basket.addProductInBasket(product[4]);

        //Добавление товара в заполненную корзину, в которой нет свободного места
        basket.addProductInBasket(product[5]);
        System.out.println();

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


        SearchEngine searchEngine = new SearchEngine(10);
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


        System.out.println(Arrays.toString(searchEngine.search("лимон")));
        System.out.println(Arrays.toString(searchEngine.search( "картофель")));
        System.out.println(Arrays.toString(searchEngine.search( "нарезка")));
    }


}