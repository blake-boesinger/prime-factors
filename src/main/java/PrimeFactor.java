import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public List<Integer> gen(int input) {

        List<Integer> output = new ArrayList<Integer>();

        final List<Integer> primeFactors = primeFactors(input);

        output.addAll(primeFactors);

        while (product(output) != input) {
                output.add(primeFactors.get(0));
        }

        return output;
    }

    private List<Integer> primeFactors(int input) {
        List<Integer> primeFactors = new ArrayList<Integer>();

        for (int i = 1; i <= input; i++) {
            for (int j = input; j > 0; j--) {
                if (i * j == input) {
                    if (primeAndNotDuplicate(primeFactors, i)) {
                        primeFactors.add(i);
                    }
                    if (primeAndNotDuplicate(primeFactors, j)) {
                        primeFactors.add(j);
                    }
                }
            }
        }
        return primeFactors;
    }

    private boolean primeAndNotDuplicate(List<Integer> primeFactors, int i) {
        return isPrime(i) && !primeFactors.contains(i);
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