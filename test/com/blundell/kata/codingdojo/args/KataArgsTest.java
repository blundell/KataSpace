package com.blundell.kata.codingdojo.args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataArgsTest {

    @Test
    public void testCanParseBooleanArg() throws Exception {
        String schema = "";
        KataArgs parser = new KataArgs(schema);

        assertEquals(true, parser.get("boolFlag"));
    }

    @Test(expected = KataArgs.ParseException.class)
    public void testSchemeNotMatchingInputThrowsException() {
        KataArgs kataArgs = new KataArgs("1,b");

        kataArgs.parse("");
    }
}
