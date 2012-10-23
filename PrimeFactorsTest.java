/*
 * -----------------------------------------------------------------------
 *
 * QATARLYST LIMITED
 *
 * -----------------------------------------------------------------------
 *
 * (C) Copyright 2012 Qatarlyst Limited. All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant hereto is,
 *          and remains, the property of Qatarlyst Limited.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to Qatarlyst Limited. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from Qatarlyst Limited.
 *
 * -----------------------------------------------------------------------
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeFactorsTest {



    @Test
    public void testOne() {
        assertEquals(list( new Integer[]{}), new PrimeFactor().gen(1));
    }

    @Test
       public void testTwo() {
           assertEquals(list( new Integer[]{2}), new PrimeFactor().gen(2));
       }

    @Test
         public void testThree() {
             assertEquals(list( new Integer[]{3}), new PrimeFactor().gen(3));
         }


    @Test
    public void testFour() {
           assertEquals(list( new Integer[]{2,2}), new PrimeFactor().gen(4));
    }

    @Test
     public void testSix() {
            assertEquals(list( new Integer[]{2,3}), new PrimeFactor().gen(6));
     }

    @Test
        public void testEight() {
                assertEquals(list( new Integer[]{2,2,2}), new PrimeFactor().gen(8));
        }

    @Test
           public void testNine() {
                   assertEquals(list( new Integer[]{3,3}), new PrimeFactor().gen(9));
           }

    @Test
    public void oneIsNotPrime() {
        assertFalse(new PrimeFactor().isPrime(1));
    }

    @Test
       public void twoIsPrime() {
           assertTrue(new PrimeFactor().isPrime(2));

       }

    @Test
          public void threeIsPrime() {
              assertTrue(new PrimeFactor().isPrime(3));

          }

    @Test
             public void fourIsNotPrime() {
                 assertFalse(new PrimeFactor().isPrime(4));

             }

    @Test
                 public void fiveIsPrime() {
                     assertTrue(new PrimeFactor().isPrime(5));

                 }



    private static List<Integer> list(Integer[] integers) {
       return  Arrays.asList(integers);

    }
}



































