package com.blundell.kata.codingdojo.args;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KataArgsTest {

    @Test(expected = KataArgs.ParseException.class)
    public void testEmptyArgsThrowsException() {
        KataArgs parser = new KataArgs("");

        parser.parse("");
    }

    @Test(expected = KataArgs.ParseException.class)
    public void testEmptySchemaWithArgsThrowsException() {
        KataArgs parser = new KataArgs("");

        parser.parse("-b");
    }

    @Test(expected = KataArgs.ParseException.class)
    public void testSchemeNotMatchingInputThrowsException() {
        KataArgs parser = new KataArgs("1|boolean|a");

        parser.parse("-s");
    }

    @Test
    public void testSchemeMatchingInputDoesntThrowException() {
        KataArgs parser = new KataArgs("1|boolean|a");

        parser.parse("-a");

        assertNoException();
    }

    @Test
    public void testParseTrueReturnsTrue() {
        KataArgs parser = new KataArgs("1|boolean|a");

        parser.parse("-a");

        assertTrue(parser.get("-a"));
    }

    @Test
    public void testParseFalseReturnsFalse() {
        KataArgs parser = new KataArgs("1|boolean|a");

        parser.parse("");

        assertTrue(parser.get("-a"));
    }

    public void assertNoException() {
        assertTrue(true);
    }
}
