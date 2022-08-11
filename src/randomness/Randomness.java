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
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
// TODO: new URL, cast URL.getContent() to InputStream for Scanner,

public class Randomness {
    
    // TODO: Decouple from random.org
    //https://www.random.org/integers/?num=1&min=-536870912&max=536870911&col=1&base=10&format=plain&rnd=new
    static int[] connectToRandomDotOrg() throws IOException {
        int[] array = {0};
        return array;
    }
    
    private static int[] integers;
    
    static {
        try {
            integers = connectToRandomDotOrg();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
    
    // TODO: Write tests for this
    static int nextInt() {
        return 0;
    }

}
