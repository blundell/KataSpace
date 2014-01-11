package com.blundell.kata.codingdojo.args;

/**
 * http://codingdojo.org/cgi-bin/wiki.pl?KataArgs
 */
public class KataArgs {

    private static final String DELIM_COUNT_AND_NAME = "|";

    private final String schema;

    public KataArgs(String schema) {
        this.schema = schema;
    }

    public void parse(String... args) {
        String arg = args[0].replace("-", "");
        if (arg.isEmpty() || !schema.contains(arg)) {
            throw new ParseException();
        }
    }

    public boolean get(String flag) {
        return true;
    }

    protected static class ParseException extends RuntimeException {

    }
}
