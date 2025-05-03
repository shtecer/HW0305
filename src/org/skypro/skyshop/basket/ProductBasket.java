package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private int lengthOfProduct = 5;
    private Product[] basket;

    public ProductBasket() {
        this.basket = new Product[lengthOfProduct];

    }

    public void addProductInBasket(Product product) {
        int count = 0;
        for (int i = 0; i < lengthOfProduct; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            } else {
                count++;
            }
        }
        if (count >= 5) {
            System.out.println("Невозможно добавить продукт");
        }
    }


    public int summOfBasket() {
        int summ = 0;
        for (Product product : basket) {
            if (product != null) summ += product.getPrice();
        }
        return summ;
    }

    public void printProductBasket() {
        int count = 0;
        for (Product product : basket) {
            if (product != null) System.out.println(product);
            count++;
        }
        System.out.println("Итого: " + this.summOfBasket());

        if (count == 0) System.out.println("В корзине пусто");
    }

    public boolean checkAvailability(String name) {
        boolean check = false;
        for (Product p : basket) {
            if (p == null) continue;
            if (name.equals(p.getName())) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void clearProductBasket() {
        for (int i = 0; i < lengthOfProduct; i++) {
            basket[i] = null;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(basket);
    }
}