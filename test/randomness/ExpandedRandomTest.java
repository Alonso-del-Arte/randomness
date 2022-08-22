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

import java.math.BigInteger;
import java.time.DayOfWeek;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the ExpandedRandom class.
 * @author Alonso del Arte
 */
public class ExpandedRandomTest {
    
    /**
     * Test of flipCoin method, of class ExpandedRandom.
     */
    @Test
    public void testFlipCoin() {
        System.out.println("flipCoin");
        ExpandedRandom instance = new ExpandedRandomImpl();
        CoinSide expResult = null;
        CoinSide result = instance.flipCoin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextASCIIChar method, of class ExpandedRandom.
     */
    @Test
    public void testNextASCIIChar() {
        System.out.println("nextASCIIChar");
        ExpandedRandom instance = new ExpandedRandomImpl();
        char expResult = ' ';
        char result = instance.nextASCIIChar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextASCIICharSeq method, of class ExpandedRandom.
     */
    @Test
    public void testNextASCIICharSeq() {
        System.out.println("nextASCIICharSeq");
        int length = 0;
        ExpandedRandom instance = new ExpandedRandomImpl();
        String expResult = "";
        String result = instance.nextASCIICharSeq(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextASCIICharSeq method, of class ExpandedRandom.
     */
    @Test
    public void testNextASCIICharSeqBoundedLength() {
        int minLength = 0;
        int maxLength = 0;
        ExpandedRandom instance = new ExpandedRandomImpl();
        String expResult = "";
        String result = instance.nextASCIICharSeq(minLength, maxLength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextString method, of class ExpandedRandom.
     */
    @Test
    public void testNextString() {
        System.out.println("nextString");
        ExpandedRandom instance = new ExpandedRandomImpl();
        String expResult = "";
        String result = instance.nextString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextDateTime method, of class ExpandedRandom.
     */
    @Test
    public void testNextDateTime() {
        System.out.println("nextDateTime");
        ExpandedRandom instance = new ExpandedRandomImpl();
        OffsetDateTime expResult = null;
        OffsetDateTime result = instance.nextDateTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of the pickOneFrom function that picks one element of a set, from  
     * the ExpandedRandom class.
     */
    @Test
    public void testPickOneFrom() {
        System.out.println("pickOneFrom");
        ExpandedRandom instance = new ExpandedRandomImpl();
        int capacity = instance.nextInt(128) + 32;
        Set<BigInteger> set = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            BigInteger number = new BigInteger(i + 16, instance);
            set.add(number);
        }
        BigInteger pick = instance.pickOneFrom(set);
        assert pick != null : "Picked element should not be null";
        String msg = "Picked number " + pick.toString() 
                + " should be in set it is said to have been picked from";
        assert set.contains(pick) : msg;
    }

    /**
     * Test of the pickOneFrom function that picks one element from an 
     * enumerated type, from the ExpandedRandom class. I chose 
     * java.time.DayOfWeek for this purpose.
     */
    @Test
    public void testPickOneFromEnum() {
        ExpandedRandom instance = new ExpandedRandomImpl();
        DayOfWeek[] days = DayOfWeek.values();
        Set<DayOfWeek> expected = new HashSet<>(Arrays.asList(days));
        int capacity = 2 * days.length * days.length;
        Set<DayOfWeek> actual = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            DayOfWeek day = instance.pickOneFrom(DayOfWeek.class);
            actual.add(day);
        }
        assertEquals(expected, actual);
    }

    public class ExpandedRandomImpl extends ExpandedRandom {

        @Override
        public CoinSide flipCoin() {
            return CoinSide.HEADS;
        }

        @Override
        public char nextASCIIChar() {
            return ' ';
        }

        @Override
        public String nextString() {
            return "THIS IS FOR TESTING PURPOSES ONLY";
        }

        @Override
        public OffsetDateTime nextDateTime() {
            return OffsetDateTime.now();
        }
        
    }
    
}
