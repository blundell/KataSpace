package com.blundell.kata.sevendigital;

/**
 * https://github.com/7digital/kata-checkout
 */
public class Checkout {

    Pricer pricerA = new PricerA();
    Pricer pricerB = new PricerB();
    Pricer pricerC = new PricerC();
    Pricer pricerD = new PricerD();

    public int scan(Item... items) {

        int total = 0;
        for (Item item : items) {
            total += pricerA.calculatePrice(item);
            total += pricerB.calculatePrice(item);
            total += pricerC.calculatePrice(item);
            total += pricerD.calculatePrice(item);
        }

        return total;
    }

    public static abstract class Item {
        final int price;

        Item(int price) {
            this.price = price;
        }

        int getPrice() {
            return price;
        }
    }

    public static class A extends Item {

        A() {
            super(50);
        }
    }

    public static class B extends Item {

        B() {
            super(30);
        }
    }

    public static class C extends Item {

        C() {
            super(20);
        }
    }

    public static class D extends Item {

        D() {
            super(15);
        }
    }

    static abstract class Pricer {

        int howMany = 0;
        final int groupDiscount;
        final int discountAmount;

        Pricer(int groupDiscount, int discountAmount) {
            this.groupDiscount = groupDiscount;
            this.discountAmount = discountAmount;
        }

        public int calculatePrice(Item item) {
            if (!isCorrectItemType(item)) {
                return 0;
            }
            checkForDiscountPossibility(item);
            return potentiallyApplyDiscount(item.getPrice());

        }

        protected abstract boolean isCorrectItemType(Item item);

        private void checkForDiscountPossibility(Item item) {
            if (isCorrectItemType(item)) {
                howMany++;
            }
        }

        private int potentiallyApplyDiscount(int total) {
            if (hitDiscountTotal()) {
                total = applyDiscount(total);
                howMany = 0;
            }
            return total;
        }

        private boolean hitDiscountTotal() {
            return howMany == groupDiscount;
        }

        private int applyDiscount(int total) {
            return total - discountAmount;
        }

    }

    static class PricerA extends Pricer {

        PricerA() {
            super(3, 20);
        }

        @Override
        protected boolean isCorrectItemType(Item item) {
            return item instanceof A;
        }
    }

    static class PricerB extends Pricer {

        PricerB() {
            super(2, 15);
        }

        @Override
        protected boolean isCorrectItemType(Item item) {
            return item instanceof B;
        }
    }

    static class PricerC extends Pricer {

        PricerC() {
            super(-1, 0);
        }

        @Override
        protected boolean isCorrectItemType(Item item) {
            return item instanceof C;
        }
    }

    static class PricerD extends Pricer {

        PricerD() {
            super(-1, 0);
        }

        @Override
        protected boolean isCorrectItemType(Item item) {
            return item instanceof D;
        }
    }

}
