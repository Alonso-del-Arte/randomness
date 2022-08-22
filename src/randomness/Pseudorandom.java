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

import java.util.Random;
import java.util.Set;

// TODO: Write static wrappers for Pseudorandomness's functions
/**
 *
 * @author Alonso del Arte
 */
public class Pseudorandom {
    
    private static final char PRINTABLE_ASCII_SPAN_BEGIN = ' ';

    private static final char PRINTABLE_ASCII_SPAN_END = '~';

    private static final int PRINTABLE_ASCII_SPAN = PRINTABLE_ASCII_SPAN_END
            - PRINTABLE_ASCII_SPAN_BEGIN + 1;

    private static final Random RANDOM  
            = new Pseudorandomness(new RandomDotOrgAccess());
    
    // TODO: Write tests for this
    public static CoinSide flipCoin() {
//        if (RANDOM.nextBoolean()) {
            return CoinSide.HEADS; 
//        } else {
//            return CoinSide.TAILS;
//        }
    }
    
    public static char nextASCIIChar() {
        return (char) (' ' + RANDOM.nextInt(PRINTABLE_ASCII_SPAN));
    }

    public static String nextASCIICharSeq(int length) {
        char[] characters = new char[length];
        for (int i = 0; i < length; i++) {
            characters[i] = 'a';
        }
        return new String(characters);
    }

    // TODO: Write tests for this
    public static String nextASCIICharSeq(int minLength, int maxLength) {
        return "NOT IMPLEMENTED YET";
    }

    // TODO: Write tests for this
    public static int nextInt() {
        return 0;
    }

    // TODO: Write tests for this
    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }
    
    // TODO: Write tests for this
    public static <E> E pickOneFrom(Set<E> set) {
        return null;
    }

    // TODO: Write tests for this
    public static <E extends Enum<E>> E pickOneFrom(Class<E> enumeratedType) {
        return null;
    }

}
