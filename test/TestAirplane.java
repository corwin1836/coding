import com.company.Airplane;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestAirplane {
    @Test
    public void hasLanded_ReturnsFalse_Immediately() {
        Airplane x = new Airplane();
        x.landing();
        assertFalse(x.hasLanded());
    }

    //MethodName_StateUnderTest_ExpectedBehavior//
    @Test
    public void hasTakenOff_immediately_returnsFalse() {
        Airplane x = new Airplane();
        x.takeOff();
        assertFalse(x.hasTakenOff());
    }
    @Test
    public void hasLanded_15ticks_returnsTrue() {
        Airplane x = new Airplane();
        x.landing();
        for (int i = 0; i < 15; i++) {
            x.tick();
        }
        assertTrue(x.hasLanded());
    }
    @Test
    public void hasTakenoff_15ticks_returnsTrue() {
        Airplane x = new Airplane();
        x.takeOff();
        for (int i = 0; i < 15; i++) {
           x.tick();
        }
        assertTrue(x.hasTakenOff());
    }

}
