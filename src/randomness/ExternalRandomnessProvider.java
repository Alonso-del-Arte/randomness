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

/**
 * Template for a class that connects to the Internet to get random integers.
 * @author Alonso del Arte
 */
public abstract class ExternalRandomnessProvider {
    
    /**
     * Provides random numbers in a specified range.
     * @param amount How many random numbers to provide. Ought to be positive.
     * @param minimum The minimum each number can be. Ought to be less than 
     * <code>maximum</code>. For example, 1.
     * @param maximum The maximum each number can be. Ought to be more than 
     * <code>minimum</code>. For example, 10.
     * @return An array with as many integers as specified by 
     * <code>amount</code>.
     * @throws IllegalArgumentException If any of the parameters are outside the 
     * specified ranges.
     * @throws IOException If there is any problem connecting to the Internet to 
     * get the random numbers.
     * @throws RuntimeException If there is a response from the external 
     * provider but there is a problem processing that response.
     */
    public abstract int[] giveNumbers(int amount, int minimum, int maximum) 
            throws IOException;
    
    /**
     * Tells whether or not the quota has been exceeded.Even the paid services 
     * have quotas, though the free services might be quite generous.
     * @return True if the quota has not been exceeded, false it has been.
     * @throws java.io.IOException
     */
    public abstract boolean haveNotExceededQuota() throws IOException; 

}
