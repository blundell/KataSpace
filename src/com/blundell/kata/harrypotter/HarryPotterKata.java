package com.blundell.kata.harrypotter;

import java.util.Map;

public class HarryPotterKata {

    private static final int MAX_DISCOUNT = 25;
    private Map<RowlingBook, Integer> books;

    public HarryPotterKata(Map<RowlingBook, Integer> books) {
        this.books = books;
    }

    public void buy(RowlingBook book) {
        int totalNumberBought = 0;
        if (books.containsKey(book)) {
            totalNumberBought = books.get(book);
        }
        books.put(book, ++totalNumberBought);
    }

    public double total() {
        if (books.isEmpty()) {
            return 0;
        }

        double totalPrice = 0D;
        for (Integer integer : books.values()) {
            totalPrice += (integer * 8);
        }

        if (books.size() == 1) {
            return totalPrice;
        }

        int discountRatio = books.size() - 1;

        double discountPercentage = discountRatio * 5;

        if (discountPercentage > MAX_DISCOUNT) {
            discountPercentage = MAX_DISCOUNT;
        }

        totalPrice -= (discountPercentage / 100) * totalPrice;

        return totalPrice;
    }
}
