package com.blundell.kata.sevendigital;

import org.junit.Test;

import static com.blundell.kata.sevendigital.Checkout.*;
import static org.junit.Assert.assertEquals;

/**
 * https://github.com/7digital/kata-checkout
 */
public class CheckoutTest {

    private final A ITEM_A = new A();
    private final B ITEM_B = new B();

    @Test
    public void testOneEqualsOne() throws Exception {
        assertEquals(1, 1);
    }

    @Test
    public void testACosts50Quid() throws Exception {
        int total = new Checkout().scan(ITEM_A);

        assertEquals(50, total);
    }

    @Test
    public void testBCosts30Quid() throws Exception {
        int total = new Checkout().scan(new B());

        assertEquals(30, total);
    }

    @Test
    public void testCCosts20Quid() throws Exception {
        int total = new Checkout().scan(new C());

        assertEquals(20, total);
    }

    @Test
    public void testDCosts15Quid() throws Exception {
        int total = new Checkout().scan(new D());

        assertEquals(15, total);
    }

    @Test
    public void testTwoACost100Quid() throws Exception {
        int total = new Checkout().scan(ITEM_A, ITEM_A);

        assertEquals(100, total);
    }

    @Test
    public void testThreeACost130Quid() throws Exception {
        int total = new Checkout().scan(ITEM_A, ITEM_A, ITEM_A);

        assertEquals(130, total);
    }

    @Test
    public void testTwoBCost45Quid() throws Exception {
        int total = new Checkout().scan(ITEM_B, ITEM_B);

        assertEquals(45, total);
    }

    @Test
    public void testFourBCost90Quid() throws Exception {
        int total = new Checkout().scan(ITEM_B, ITEM_B, ITEM_B, ITEM_B);

        assertEquals(90, total);
    }

    @Test
    public void testSixACost260Quid() throws Exception {
        int total = new Checkout().scan(ITEM_A, ITEM_A, ITEM_A, ITEM_A, ITEM_A, ITEM_A);

        assertEquals(260, total);
    }
}
