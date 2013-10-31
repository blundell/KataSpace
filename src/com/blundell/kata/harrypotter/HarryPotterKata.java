package com.blundell.kata.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class HarryPotterKata {

    private static final int MAX_DISCOUNT = 25;
    public static final Map<Integer, Integer> discountLookup = new HashMap<Integer, Integer>();

    static {
        discountLookup.put(0, 0);
        discountLookup.put(1, 0);
        discountLookup.put(2, 5);
        discountLookup.put(3, 10);
        discountLookup.put(4, 20);
        discountLookup.put(5, 25);
    }

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
        double totalPrice = 0D;
        for (Integer integer : books.values()) {
            totalPrice += (integer * 8);
        }

        if (books.size() == 1) {
            return totalPrice;
        }

        int discountRatio = books.size();

        double discountPercentage = discountLookup.get(discountRatio);

        if (discountPercentage > MAX_DISCOUNT) {
            discountPercentage = MAX_DISCOUNT;
        }

        totalPrice -= (discountPercentage / 100) * totalPrice;

        return totalPrice;
    }
}
