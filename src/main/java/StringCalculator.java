

public class StringCalculator {

    public int add(String input) throws NegativeNotAllowedException {




        if ( input.length() == 0) {
        return 0;
        }
        else {
            String regex = ",|\n";

            if ( input.startsWith("//")) {
                regex = input.substring(2, input.indexOf('\n'));
                input = input.substring(input.indexOf('\n') + 1);
            }



            final String[] split = input.split(regex);
            int total = 0;
            for (String s : split) {
                final int i = Integer.parseInt(s);
                if ( i < 0) {
                    throw new NegativeNotAllowedException();
                }
                if ( i > 1000) {
                    continue;
                }
                total += i;

            }
            return total;
        }

    }

}