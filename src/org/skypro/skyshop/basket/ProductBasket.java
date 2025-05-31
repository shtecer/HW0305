package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> productsBasket = new ArrayList<>();

    public void addProductInBasket(Product product) {
        productsBasket.add(product);
    }

    public int summOfBasket() {
        int summ = 0;
        for (Product product : productsBasket) {
            if (product != null) {
                summ += product.getPrice();
            }
        }
        return summ;
    }

    public void printProductBasket() {
        int count = 0;
        int specialCount = 0;
        for (Product product : productsBasket) {
            if (product != null) {
                System.out.println(product);
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

    public boolean checkContains(String name) {
        boolean check = false;
        for (Product p : productsBasket) {
            if (p != null && name.equals(p.getName())) {
                check = true;
                break;
            }
        }
        return check;
    }

    public void clearProductBasket() {
        productsBasket.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = productsBasket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        return removedProducts;
    }

}