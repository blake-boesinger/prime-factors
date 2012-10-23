

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public List<Integer> gen(int input) {
        if (input == 1) {
            return new ArrayList<Integer>();
        }
        List<Integer> list = new ArrayList<Integer>();

        final List<Integer> primeFactors = primeFactors(input);


        int i = 0;
        while (product(list) != input) {

                if ( i >= primeFactors.size()) {
                list.add(primeFactors.get(i-1));
                }
                else {
                    list.add(primeFactors.get(i++));

                }


        }
        return list;
    }

    private List<Integer> primeFactors(int input) {
        List<Integer> primeFactors = new ArrayList<Integer>();

        for (int i = 1; i <= input; i++) {
            for (int j = input; j > 0; j--) {
                if (i * j == input) {

                    if (isPrime(i) && !primeFactors.contains(i)) {
                        primeFactors.add(i);
                    }
                    if (isPrime(j) && !primeFactors.contains(j)) {
                        primeFactors.add(j);
                    }
                }

            }
        }
        return primeFactors;
    }

    private int product(List<Integer> list) {
        int total = 1;
        for (int i = 0; i < list.size(); i++) {
            total *= list.get(i);

        }
        return total;
    }


    public boolean isPrime(int input) {
        if (input == 1) {
            return false;
        }
        boolean isPrime = true;
        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}