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

import java.time.OffsetDateTime;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author Alonso del Arte
 */
public abstract class ExpandedRandom extends Random {
    
    private static final long serialVersionUID = 4553887127401760416L;
    
    public abstract CoinSide flipCoin();
    
    public abstract char nextASCIIChar();
    
    public abstract String nextASCIICharSeq(int length);
    
    public abstract String nextASCIICharSeq(int minLength, int maxLength);
    
    public abstract String nextString();
    
    public abstract OffsetDateTime nextDateTime();
    
    // TODO: Write tests for this
    public <E> E pickOneFrom(Set<E> set) {
        return null;
    }

    // TODO: Write tests for this
    public <E extends Enum<E>> E pickOneFrom(Class<E> enumType) {
        return null;
    }

}
