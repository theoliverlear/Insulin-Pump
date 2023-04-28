import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
public class InsulinPumpTest {
    InsulinPump testPump = new InsulinPump(15, 50, 150, 300, 2);
    @Test
    public void testConstructor() {
        assertThat(15, equalTo(testPump.getCarbRatio()));
        assertThat(50, equalTo(testPump.getSensitivity()));
        assertThat(150, equalTo(testPump.getRangeFloor()));
        assertThat(300, equalTo(testPump.getBloodSugar()));
        assertThat(2.0, equalTo(testPump.getBasalRatePerHour()));
    }
    @Test
    public void testCalculateCorrection() {
        assertThat(testPump.calculateCorrection(), equalTo(3.0));
    }
    @Test
    public void testCalculateBolus() {
        assertThat(testPump.calculateBolus(45), equalTo(3.0));
    }
    @Test
    public void testBolusWizard() {
        double testBolus = testPump.calculateBolus(45) + testPump.calculateCorrection();
        assertThat(testBolus, equalTo(6.0));
    }
}
