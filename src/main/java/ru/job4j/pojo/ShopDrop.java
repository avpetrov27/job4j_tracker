package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (; index < products.length - 1; index++) {
            products[index] = products[index + 1];
        }
        products[index] = null;
        return products;
    }
}
