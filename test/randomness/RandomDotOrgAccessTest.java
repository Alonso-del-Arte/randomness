/*
 * Copyright (C) 2022 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package randomness;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the RandomDotOrgAccess class. We take it on faith that 
 * RandomDotOrgAccess will connect to random.org for the numbers, but check that 
 * the numbers meet our requirements for distribution and range.
 * @author Alonso del Arte
 */
public class RandomDotOrgAccessTest {
    
    private static int[] retrievedNumbers = {};
    
    public static int expectedLength = 1000;
    
    public static int expectedMinimum = -2000;
    
    public static int expectedMaximum = 2000;
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        retrievedNumbers = provider.giveNumbers(expectedLength, expectedMinimum, 
               expectedMaximum);
    }
    
    @Test
    public void testGiveNumbersRejectsNegativeAmount() {
        int badAmount = -1;
        String msg = "giveNumbers() should reject " + badAmount 
                + ", too low for amount";
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        fail("This test needs to be rewritten for JUnit 4");
//        Throwable t = assertThrows(() -> {
//            provider.giveNumbers(badAmount, 0, 1);
//        }, IllegalArgumentException.class, msg);
//        String excMsg = t.getMessage();
//        assert excMsg != null : "Message should not be null";
//        System.out.println(excMsg);
    }
    
    @Test
    public void testGiveNumbersRejectsExcessiveAmount() {
        int badAmount = 10001;
        String msg = "giveNumbers() should reject " + badAmount 
                + ", too high for amount";
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        fail("This test needs to be rewritten for JUnit 4");
//        Throwable t = assertThrows(() -> {
//            provider.giveNumbers(badAmount, 0, 1);
//        }, IllegalArgumentException.class, msg);
//        String excMsg = t.getMessage();
//        assert excMsg != null : "Message should not be null";
//        System.out.println(excMsg);
    }
    
    @Test
    public void testGiveNumbersRejectsBadMinimum() {
        int badMinimum = -1000000001;
        String msg = "giveNumbers() should reject " + badMinimum 
                + ", too low for minimum";
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        fail("This test needs to be rewritten for JUnit 4");
//        Throwable t = assertThrows(() -> {
//            provider.giveNumbers(1, badMinimum, 0);
//        }, IllegalArgumentException.class, msg);
//        String excMsg = t.getMessage();
//        assert excMsg != null : "Message should not be null";
//        System.out.println(excMsg);
    }
    
    @Test
    public void testGiveNumbersRejectsBadMaximum() {
        int badMaximum = 1000000001;
        String msg = "giveNumbers() should reject " + badMaximum 
                + ", too high for maximum";
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        fail("This test needs to be rewritten for JUnit 4");
//        Throwable t = assertThrows(() -> {
//            provider.giveNumbers(1, 0, badMaximum);
//        }, IllegalArgumentException.class, msg);
//        String excMsg = t.getMessage();
//        assert excMsg != null : "Message should not be null";
//        System.out.println(excMsg);
    }
    
    @Test
    public void testGiveNumbersRejectsMinimumHigherThanMaximum() {
        int badMinimum = 10;
        int badMaximum = badMinimum - 1;
        String msg = "giveNumbers() should reject maximum " + badMaximum 
                + " that is higher than minimum " + badMinimum;
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        fail("This test needs to be rewritten for JUnit 4");
//        Throwable t = assertThrows(() -> {
//            provider.giveNumbers(1, badMinimum, badMaximum);
//        }, IllegalArgumentException.class, msg);
//        String excMsg = t.getMessage();
//        assert excMsg != null : "Message should not be null";
//        System.out.println(excMsg);
    }
    
    @Test
    public void testLength() {
        int actualLength = retrievedNumbers.length;
        assertEquals(expectedLength, actualLength);
    }
    
    @Test
    public void testDiffLength() throws IOException {
        ExternalRandomnessProvider provider = new RandomDotOrgAccess();
        int expected = 10;
        int actual = provider.giveNumbers(expected, 1, 10).length;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testDistinctness() {
        Set<Integer> set = new HashSet<>();
        for (int number : retrievedNumbers) {
            set.add(number);
        }
        int expected = 800;
        int actual = set.size();
        String msg = "Expected at least " + expected + " distinct numbers, got " 
                + actual;
        System.out.println(msg);
        assert expected <= actual : msg;
    }
    
    @Test
    public void testRange() {
        for (int number : retrievedNumbers) {
            String msg = number + " should be between " + expectedMinimum 
                    + " and " + expectedMaximum;
            assert number >= expectedMinimum 
                    && number <= expectedMaximum : msg;
        }
    }
    
    @Test
    public void testIntervals() {
        Set<Integer> intervals = new HashSet<>();
        for (int i = 1; i < retrievedNumbers.length; i++) {
            int difference = retrievedNumbers[i] 
                    - retrievedNumbers[i - 1];
            intervals.add(difference);
        }
        int expected = 700;
        int actual = intervals.size();
        String msg = "Expected at least " + expected 
                + " distinct intervals, got " + actual;
        System.out.println(msg);
        assert expected <= actual : msg;
    }

}
