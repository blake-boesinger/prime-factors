

import com.google.common.base.Optional;

import java.util.HashMap;
import java.util.Map;

public class Checkout {

    public Checkout() {
        prices.put('A', new Price(50, Optional.of(new Discount(3, 130))));
        prices.put('B', new Price(30, Optional.of(new Discount(2, 45))));
        prices.put('D', new Price(15, Optional.<Discount>absent()));
        prices.put('C', new Price(20, Optional.<Discount>absent()));
    }


    Map<Character, Price> prices = new HashMap<Character, Price>();

    public int scan(String scanned) {
        if (scanned.length() == 0) {
            return 0;
        }
        return calcTotal(scanned);
    }

    private int calcTotal(String scanned) {

        int total = 0;
        for (Character character : prices.keySet()) {
            final int count = count(scanned, character);
            total += priceForItem(character, count);
        }
        return total;
    }

    private int priceForItem(char item, int count) {

        final Optional<Discount> optionalDiscount = prices.get(item).getOptionalDiscount();
        if (optionalDiscount.isPresent()) {
            return calcTotalPriceForItemWhenDiscount(item, count, optionalDiscount.get());
        } else {
            return priceForItemGivenQuantity(item, count);
        }
    }

    private int calcTotalPriceForItemWhenDiscount(char item, int count, Discount discount) {
        int total = 0;

        int discountQuantity = discount.getDiscountQuantity();
        int priceForDiscountQuantity = discount.getDiscountedPrice();

        int times = count / discountQuantity;
        int nonDiscountedTimes = count % discountQuantity;

        for (int i = 0; i < times; i++) {
            total += priceForDiscountQuantity;
        }

        return calcTotalPriceForItemWhenNoDiscount(item, nonDiscountedTimes, total);
    }

    private int calcTotalPriceForItemWhenNoDiscount(char item, int nonDiscounted, int totalSoFar) {
         return priceForItemGivenQuantity(item, nonDiscounted) + totalSoFar;
    }

    private int priceForItemGivenQuantity(char item, int times) {
        int total = 0;
        for (int i = 0; i < times; i++) {
            total += prices.get(item).getPrice();
        }
        return total;
    }

    private int count(String scanned, char itemToCount) {
        final char[] chars = scanned.toCharArray();

        int count = 0;
        for (char c : chars) {
            if (c == itemToCount) {
                count++;
            }
        }
        return count;
    }


}
