package com.blundell.kata.harrypotter;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HarryPotterKataShould {

    private HarryPotterKata kata;

    @Before
    public void setUp() {
        kata = new HarryPotterKata(new ArrayList<RowlingBook>());
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

}
