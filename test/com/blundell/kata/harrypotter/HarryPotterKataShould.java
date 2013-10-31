package com.blundell.kata.harrypotter;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HarryPotterKataShould {

    private HarryPotterKata kata;

    @Before
    public void setUp() {
        kata = new HarryPotterKata(new HashMap<RowlingBook, Integer>());
    }

    @Test
    public void testNoBooks_costs$0_0() throws Exception {
        assertEquals(0D, kata.total());
    }

    @Test
    public void testTwoBooksTheSame_costs$16_0() throws Exception {
        kata.buy(RowlingBook.ONE);
        kata.buy(RowlingBook.ONE);

        assertEquals(16D, kata.total());
    }

    @Test
    public void testTwoBooksDifferent_costs$15_2() throws Exception {
        kata.buy(RowlingBook.ONE);
        kata.buy(RowlingBook.TWO);

        assertEquals(15.2D, kata.total());
    }

    @Test
    public void testThreeBooksDifferent_costs$21_6() throws Exception {
        kata.buy(RowlingBook.ONE);
        kata.buy(RowlingBook.TWO);
        kata.buy(RowlingBook.THREE);

        assertEquals(21.6D, kata.total());
    }

}
