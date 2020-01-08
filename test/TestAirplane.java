import com.company.Airplane;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestAirplane {
    @Test
    public void hasLanded_ReturnsFalse_Immediately() {
        Airplane x = new Airplane();
        x.landing();
        assertFalse(x.hasLanded());
    }

    //MethodName_StateUnderTest_ExpectedBehavior//
    //hasTakenOff_returnsFalse_Immediately
    //hasLanded_returnsTrue_15ticks
    //hasTakenoff_returnsTrue_15ticks
    //
}
