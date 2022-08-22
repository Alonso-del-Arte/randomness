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
package arithmetic;

import java.math.BigDecimal;

/**
 * Represents a percentage, usually in the range from 0.0% to 100.0%.
 * @author Alonso del Arte
 */
public class Percentage {
    
    private final BigDecimal value;
    
    @Override
    public String toString() {
        return this.value.toPlainString() + "%";
    }
    
    // TODO: Write tests for this
    public Percentage(double x) {
        this.value = BigDecimal.ZERO;
    }
    
    public Percentage(int n) {
        this.value = BigDecimal.valueOf(n);
    }
    
    // TODO: Write tests for this
    public Percentage(Fraction fraction) {
        this.value = BigDecimal.ZERO;
    }
    
    // TODO: Write tests for this
    public Percentage(BigDecimal decimal) {
        this.value = BigDecimal.ZERO;
    }
    
}
