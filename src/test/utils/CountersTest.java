package utils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CountersTest {
    @Test(expected = IllegalStateException.class)
    public void testIllegalStateException() {
        new Counters();
    }
    @Test
    public void testGetCowsBulls() {
        assertNotNull
                (Counters.getCowsAndBullsFromNumber(2345, 9541));
        for(int i = 0;i<8;i++){
            Counters.getCowsAndBullsFromNumber(12345, 95412+i);
        }

    }
}
