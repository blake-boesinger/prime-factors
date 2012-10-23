

class Discount {
    public int getDiscountQuantity() {
        return discountQuantity;
    }

    public int getDiscountedPrice() {
        return discountAmount;
    }

    Discount(int discountQuantity, int discountAmount) {
        this.discountQuantity = discountQuantity;
        this.discountAmount = discountAmount;
    }

    private int discountQuantity;
    private int discountAmount;
}
