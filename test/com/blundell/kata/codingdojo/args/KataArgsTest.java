package com.blundell.kata.codingdojo.args;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataArgsTest {

    @Test
    public void testCanParseBooleanInput() throws Exception {
        String schema = "";
        KataArgs parser = new KataArgs(schema);

        assertEquals(true, parser.get("boolFlag"));
    }
}
