package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Введите корректную цену");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Неверный процент");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return basePrice - (basePrice * discount / 100);
    }


    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (с учетом скидки " + discount + " %)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getSearchableName() {
        return getName();
    }
}