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

import java.io.InputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Connects to Random.org to get random integers.
 * @author Alonso del Arte
 */
class RandomDotOrgAccess extends ExternalRandomnessProvider {
    
    private static final int MINIMUM_AMOUNT = 1;
    
    private static final int MAXIMUM_AMOUNT = 10000;
    
    private static final int MINIMUM_MINIMUM = -1000000000;
    
    private static final int MAXIMUM_MAXIMUM = 1000000000;
        
    private static void validateParams(int amount, int minimum, int maximum) {
        if (amount < MINIMUM_AMOUNT || amount > MAXIMUM_AMOUNT) {
            String excMsg = "amount should be in range " + MINIMUM_AMOUNT 
                    + " to " + MAXIMUM_AMOUNT;
            throw new IllegalArgumentException(excMsg);
        }
        if (minimum < MINIMUM_MINIMUM) {
            String excMsg = "minimum should be at least " + MINIMUM_MINIMUM;
            throw new IllegalArgumentException(excMsg);
        }
        if (maximum > MAXIMUM_MAXIMUM) {
            String excMsg = "maximum should be at no more than " 
                    + MAXIMUM_MAXIMUM;
            throw new IllegalArgumentException(excMsg);
        }
        if (minimum >= maximum) {
            String excMsg = "minimum should not be greater than maximum";
            throw new IllegalArgumentException(excMsg);
        }
    }
    
    private static URL composeURL(int amount, int minimum, int maximum) 
            throws MalformedURLException {
        String urlStr = "https://www.random.org/integers/?num=" + amount 
                + "&min=" + minimum + "&max=" + maximum 
                + "&col=1&base=10&format=plain&rnd=new";
        return new URL(urlStr);
    }
    
    /**
     * Provides random numbers in a specified range.
     * @param amount How many random numbers to provide. Ought to be positive, 
     * should not be more than 10000.
     * @param minimum The minimum each number can be. Ought to be less than 
     * <code>maximum</code>. Should not be less than &minus;1000000000. For 
     * example, 1.
     * @param maximum The maximum each number can be. Ought to be more than 
     * <code>minimum</code>. Should not be more than 1000000000. For example, 
     * 10.
     * @return An array with as many integers as specified by 
     * <code>amount</code>.
     * @throws IllegalArgumentException If any of the parameters are outside the 
     * specified ranges.
     * @throws IOException If there is any problem connecting to the Internet to 
     * get the random numbers.
     * @throws RuntimeException If there is a response from the external 
     * provider but there is a problem processing that response.
     */
    @Override
    public int[] giveNumbers(int amount, int minimum, int maximum) 
            throws IOException {
        validateParams(amount, minimum, maximum);
        int[] numbers = new int[amount];
        URL apiCall = composeURL(amount, minimum, maximum);
        URLConnection conn = apiCall.openConnection();
        InputStream content = (InputStream) conn.getContent();
        try (Scanner scanner = new Scanner(content)) {
            int curr = 0;
            while (scanner.hasNext()) {
                numbers[curr] = scanner.nextInt();
                curr++;
            }
        }
        return numbers;
    }
    
    @Override
    public boolean haveNotExceededQuota() throws IOException {
        URL url = new URL("https://www.random.org/quota/?format=plain");
        URLConnection conn = url.openConnection();
        InputStream content = (InputStream) conn.getContent();
        try (Scanner scanner = new Scanner(content)) {
            int quotaRemaining = scanner.nextInt();
            return quotaRemaining > 0;
        }
    }

}
