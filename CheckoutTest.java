

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

public class CheckoutTest {

    public CheckoutTest() {
        prices.put('A', new Price(50, Optional.of(new Discount(3, 130))));
        prices.put('B', new Price(30, Optional.of(new Discount(2, 45 ))));
        prices.put('D', new Price(15, Optional.<Discount>absent()));
        prices.put('C', new Price(20, Optional.<Discount>absent()));
    }

    @Test
    public void scanEmpty() {
        assertEquals(0, scan(""));
    }

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

    Map<Character, Price> prices = new HashMap<Character, Price>();

    @Test
    public void scanA() {
        assertEquals(50, scan("A"));
    }

    @Test
    public void scanAA() {
        assertEquals(100, scan("AA"));
    }

    @Test
    public void scanAAA() {
        assertEquals(130, scan("AAA"));
    }

    @Test
    public void scanCDBA() {
        assertEquals(115, scan("CDBA"));
    }

    @Test
    public void scanAAAB() {
        assertEquals(160, scan("AAAB"));
    }


    @Test
    public void scanAAABB() {
        assertEquals(175, scan("AAABB"));
    }


    @Test
    public void scanDABABA() {
        assertEquals(190, scan("DABABA"));
    }


    @Test
    public void AAABBD() {
        assertEquals(190, scan("AAABBD"));
    }

    @Test
    public void scanAAAA() {
        assertEquals(180, scan("AAAA"));
    }

    @Test
    public void scanAAAAA() {
        assertEquals(230, scan("AAAAA"));
    }


    @Test
    public void scanAAAAAA() {
        assertEquals(260, scan("AAAAAA"));
    }


    @Test
    public void scanB() {
        assertEquals(30, scan("B"));
    }

    @Test
    public void scanAB() {
        assertEquals(80, scan("AB"));
    }

    private int scan(String scanned) {
        if (scanned.length() == 0) {
            return 0;
        }

        return calcPrices(scanned);
    }

    private int calcPrices(String scanned) {

        int total = 0;

        for (Character  character : prices.keySet()) {
            final int count = count(scanned, character);
            total += priceForItem(character, count);
        }

        return total;
    }

    private int priceForItem(char item, int count) {
        int total = 0;

        int nonDiscounted = count;

        final Optional<Discount> optionalDiscount = prices.get(item).getOptionalDiscount();
        if ( optionalDiscount.isPresent()) {

            final Discount discount = optionalDiscount.get();
            int quantity = discount.getDiscountQuantity();
            int discountedPrice = discount.getDiscountedPrice();

            int times = count / quantity;
            nonDiscounted = count % quantity;


            for (int i = 0; i < times; i++) {
                      total += discountedPrice;
                  }

        }





        for (int i = 0; i < nonDiscounted; i++) {
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
