package utils;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CountersTest {
    @Test
    public void testGetCowsBulls() {
        assertNotNull
                (Counters.getCowsAndBullsFromNumber(12345, 95412));
    }
}
