import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void emptyStringReturnsZero() throws NegativeNotAllowedException {
           assertEquals(0, new StringCalculator().add(""));
    }


    @Test
    public void singleDigitReturnsThatDigit() throws NegativeNotAllowedException {
           assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    public void twoDigitsReturnsTheSum() throws NegativeNotAllowedException {
           assertEquals(3, new StringCalculator().add("1,2"));
    }


    @Test
    public void worksForNewLines() throws NegativeNotAllowedException {
           assertEquals(6, new StringCalculator().add("1\n2,3"));
    }

    @Test
    public void changeDelimiter() throws NegativeNotAllowedException {
           assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }


    @Test(expected = NegativeNotAllowedException.class)
    public void negativeNumberThrowsException() throws NegativeNotAllowedException {
           new StringCalculator().add("-4");
    }


    @Test
    public void ignoreBiggerThan1000() throws NegativeNotAllowedException {
           assertEquals(3, new StringCalculator().add("1,2,1001"));
    }




}
