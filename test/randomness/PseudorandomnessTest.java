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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alonso del Arte
 */
public class PseudorandomnessTest {
    
    private static class MockProvider extends ExternalRandomnessProvider {

        @Override
        public int[] giveNumbers(int amount, int minimum, int maximum) 
                throws IOException {
            int[] array = {};
            return array;
        }

        @Override
        public boolean haveNotExceededQuota() throws IOException {
            return false;
        }
        
    }
    
    private static class OfflinePseudorandomness extends Pseudorandomness {
        
        @Override
        int[] connectToExternalRandomnessProvider() throws IOException {
            String excMsg = "Simulating the Internet connection is unavailable";
            throw new IOException(excMsg);
        }
        
        OfflinePseudorandomness(ExternalRandomnessProvider provider) {
            super(provider);
        }

    }

}
