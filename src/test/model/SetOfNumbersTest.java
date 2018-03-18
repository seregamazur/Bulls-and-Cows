package model;

import org.junit.*;
import static org.junit.Assert.*;


public class  SetOfNumbersTest {
    model.ComputerGenerator generator = new ComputerGenerator();
    @Before
    public void addToSet(){ generator.getNumbers().add(5);
    }
    @Test
    public void setNotEmpty(){
        assertFalse(generator.getNumbers().isEmpty());
    }
    @Test
    public void setSize(){
        assertEquals(1,generator.getNumbers().size());
    }
    @Test
    public void addNumtoSet(){
        generator.getNumbers().add(6);
    }
    @Test
    public void getSize(){
        assertEquals(1,generator.getNumbers().size());
    }
}
