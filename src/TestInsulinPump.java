import org.junit.Test;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
public class TestInsulinPump {
    InsulinPump testPump = new InsulinPump(15, 50, 150, 300);
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
