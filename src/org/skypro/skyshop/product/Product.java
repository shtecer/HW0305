package org.skypro.skyshop.product;

import org.skypro.skyshop.articles.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private  String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ввод имени обязятелен");
        }
        this.name = name;
        }

    public String getName() {
        return name;
    }


    public abstract int getPrice();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public abstract String toString();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }
    @Override
    public String getContentType() {
        return " PRODUCT";
    }
}
