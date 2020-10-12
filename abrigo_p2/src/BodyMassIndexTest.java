import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {
    // Criteria 2: 2pts
    @Test
    public void testForUnderweightBMI() {
        BodyMassIndex skinnyGuy = new BodyMassIndex(68, 100);
        assertEquals("15.2 (Underweight < 18.5)", skinnyGuy.getBMIData());
    }

    @Test
    public void testForNormalWeightBMI() {
        BodyMassIndex avgGuy = new BodyMassIndex(68, 145);
        assertEquals("22.04 (Normal weight = 18.5 - 24.9)", avgGuy.getBMIData());
    }

    @Test
    public void testForOverweightBMI() {
        BodyMassIndex fatGuy = new BodyMassIndex(68, 180);
        assertEquals("27.37 (Overweight = 25 - 29.9)", fatGuy.getBMIData());
    }

    @Test
    public void testForObeseBMI() {
        BodyMassIndex bigBoy = new BodyMassIndex(68, 200);
        assertEquals("30.41 (Obesity >= 30.0)", bigBoy.getBMIData());
    }

    // Criteria 3: 2pts
    @Test
    public void testCalculateBMI() {
        BodyMassIndex test = new BodyMassIndex();
        assertEquals(140.6, test.calculateBMI(5.00, 5.00));
    }

    @Test
    public void testCalculateCategory() {
        BodyMassIndex test = new BodyMassIndex(75, 100);
        assertEquals("(Underweight < 18.5)", test.calculateCategory());
    }

    @Test
    public void testGetZeroBMI() {
        BodyMassIndex test = new BodyMassIndex();
        assertEquals(0.00, test.getBMI());
    }

    @Test
    public void testGetBMI() {
        BodyMassIndex test = new BodyMassIndex(24, 100);
        assertEquals(122.049, test.getBMI(), 0.001);
    }

}