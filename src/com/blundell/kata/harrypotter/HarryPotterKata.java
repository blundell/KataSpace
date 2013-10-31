package com.blundell.kata.harrypotter;

import java.util.List;

public class HarryPotterKata {

    private List<RowlingBook> books;

    public HarryPotterKata(List<RowlingBook> books) {
        this.books = books;
    }

    public void buy(RowlingBook book) {
        books.add(book);
    }

    public double total() {
        return books.size() * 8;
    }
}
