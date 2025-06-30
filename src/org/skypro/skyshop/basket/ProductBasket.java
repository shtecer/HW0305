package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsBasket = new HashMap<>();

    public void addProductInBasket(Product product) {
        String name = product.getName();
        productsBasket.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public int summOfBasket() {
        int summ = 0;
        for (List<Product> productList : productsBasket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    summ += product.getPrice();
                }
            }
        }
        return summ;
    }

    public void printProductBasket() {
        int count = 0;
        int specialCount = 0;
        for (List<Product> productList : productsBasket.values()) {
            for (Product product : productList) {
                if (product != null) {
                    System.out.println(product.toString());
                    if (product.isSpecial()) {
                        specialCount++;
                    }
                }
                count++;
            }
            System.out.println("Итого: " + this.summOfBasket());
            System.out.println("Специальных товаров: " + specialCount);

            if (count == 0) {
                System.out.println("В корзине пусто");
            }
        }
    }

    public boolean checkContains(String name) {
            return productsBasket.containsKey(name);
        }


    public void clearProductBasket() {
        productsBasket.clear();
    }

    public List<Product> removeProductsByName(String name) {
        return productsBasket.remove(name);
    }
}