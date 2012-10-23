

import com.google.common.base.Optional;

class Price {
    private Optional<Discount> optionalDiscount;
    private int price;

    Price(int price, Optional<Discount> optionalDiscount) {
        this.optionalDiscount = optionalDiscount;
        this.price = price;
    }

    public Optional<Discount> getOptionalDiscount() {
        return optionalDiscount;
    }

    public int getPrice() {
        return price;
    }

}
