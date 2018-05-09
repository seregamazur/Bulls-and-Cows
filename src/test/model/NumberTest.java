package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {
    Number number = new Number(12345, 54318);

    @Test
    public void testGetDigit() {
        assertEquals(12345,number.getDigit());
    }
    @Test
    public void testToString(){
        number.toString();
    }
    @Test
    public void testHash(){
        number.hashCode();
    }
    @Test
    public void testEquals(){
        assertTrue(number.equals(number));
    }
    @Test
    public void testEquals1(){
        assertFalse(number.equals(this.getClass()));
    }
    @Test
    public void testSimpleStringProperty(){
        number.setOurBulls(2);
        number.setOurCows(1);
        number.setOurDigit(12345);
        assertEquals(2,number.getOurBulls());
       assertEquals(1,number.getOurCows());
        assertEquals(12345,number.getOurDigit());
    }
}
