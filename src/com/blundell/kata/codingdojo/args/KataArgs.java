package com.blundell.kata.codingdojo.args;

/**
 * http://codingdojo.org/cgi-bin/wiki.pl?KataArgs
 */
public class KataArgs {

    private final String schema;

    public KataArgs(String schema) {
        this.schema = schema;
    }

    public void parse(String... args) {
        throw new ParseException();
    }

    public boolean get(String flag) {
        return true;
    }

    protected static class ParseException extends RuntimeException {

    }
}
