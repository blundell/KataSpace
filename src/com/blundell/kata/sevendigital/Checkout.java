package com.blundell.kata.sevendigital;

/**
 * https://github.com/7digital/kata-checkout
 */
public class Checkout {

    Discounter discounterA = new DiscounterA();
    Discounter discounterB = new DiscounterB();

    public int scan(Item... items) {

        int total = 0;
        for (Item item : items) {
            checkForDiscount(item);
            total += item.getPrice();
            total = applyDiscounts(total);
        }

        return total;
    }

    private void checkForDiscount(Item item) {
        discounterA.checkForDiscountPossibility(item);
        discounterB.checkForDiscountPossibility(item);
    }

    private int applyDiscounts(int total) {
        total = discounterA.potentiallyApplyDiscount(total);
        total = discounterB.potentiallyApplyDiscount(total);
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

    public static abstract class Discounter {

        int howMany = 0;
        final int groupDiscount;
        final int discountAmount;
        int subTotal = 0;

        Discounter(int groupDiscount, int discountAmount) {
            this.groupDiscount = groupDiscount;
            this.discountAmount = discountAmount;
        }

        void add(Item item) {
            if (isDiscountableItem(item)) {
                howMany++;
                subTotal += item.getPrice();
            }
            potentiallyApplyDiscount(subTotal);
        }

        public void checkForDiscountPossibility(Item item) {
            if (isDiscountableItem(item)) {
                howMany++;
            }
        }

        protected abstract boolean isDiscountableItem(Item item);

        public int potentiallyApplyDiscount(int total) {
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

    public static class DiscounterA extends Discounter {

        DiscounterA() {
            super(3, 20);
        }

        @Override
        protected boolean isDiscountableItem(Item item) {
            return item instanceof A;
        }
    }

    public static class DiscounterB extends Discounter {

        DiscounterB() {
            super(2, 15);
        }

        @Override
        protected boolean isDiscountableItem(Item item) {
            return item instanceof B;
        }
    }

}
