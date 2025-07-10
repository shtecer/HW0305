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
        return productsBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printProductBasket() {
        boolean isEmpty = productsBasket.values().stream()
                .flatMap(Collection::stream)
                .findAny()
                .isEmpty();
        if (isEmpty) {
            System.out.println("В корзине пусто.");
            return;
        }
        productsBasket.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(product.toString()));
        int specialCount = getSpecialCount();
            System.out.println("Итого: " + this.summOfBasket());
            System.out.println("Специальных товаров: " + specialCount);
    }

    private int getSpecialCount() {
        return (int) productsBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
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