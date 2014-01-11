package com.blundell.kata.codingdojo.args;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KataArgsTest {

    @Test(expected = KataArgs.ParseException.class)
    public void testSchemeNotMatchingInputThrowsException() {
        KataArgs parser = new KataArgs("1|b");

        parser.parse("");
    }

    @Test
    public void testSchemeMatchingInputDoesntThrowException() {
        KataArgs parser = new KataArgs("1|b");

        parser.parse("-b");

        assertNoException();
    }

    public void assertNoException() {
        assertTrue(true);
    }
}
