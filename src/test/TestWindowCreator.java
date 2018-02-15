import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestWindowCreator {
    @Before
    public void createMainMenu(){
        assertNotNull(new view.WithComp());
    }
    @Test
    public void createAgainstCompWindow(){
        assertNotNull(new view.AgainstComp());
    }
    @Test
    public void createWithCompWindow(){
        assertNotNull(new view.WithComp());
    }
    @Test
    public void createSettingsWindow(){
        assertNotNull(new view.Settings());
    }

}
