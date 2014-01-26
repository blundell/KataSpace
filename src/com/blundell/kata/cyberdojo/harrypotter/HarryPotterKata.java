package com.blundell.kata.cyberdojo.harrypotter;

import java.util.HashMap;
import java.util.Map;

public class HarryPotterKata {

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
        int totalBooks = 0;
        double totalPrice = 0D;
        int uniqueBookCount = 0;
        for (Integer bookCount : books.values()) {
            totalBooks += bookCount;
            totalPrice += (bookCount * 8);
            if (bookCount == 1) {
                uniqueBookCount++;
            }
        }

        int bookTypesCount = books.size();

        double discountPercentage = discountLookup.get(bookTypesCount);

        double nonDiscountApplicablePrice = (totalBooks - uniqueBookCount) * 8;

        double totalDiscount = (discountPercentage / 100) * (totalPrice - nonDiscountApplicablePrice);

        totalPrice -= totalDiscount;

        return totalPrice;
    }
}
