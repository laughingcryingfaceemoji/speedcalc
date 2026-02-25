import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testComputeSpeedNormal() {
        assertEquals(50.0, calculator.computeSpeed(100, 2), 1e-9);
        assertEquals(100.0, calculator.computeSpeed(100, 1), 1e-9);
        assertEquals(33.3333333333, calculator.computeSpeed(100, 3), 1e-9);
    }

    @Test
    void testComputeSpeedFractionalHours() {
        assertEquals(200.0, calculator.computeSpeed(100, 0.5), 1e-9);
    }

    @Test
    void testComputeSpeedZeroHoursThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.computeSpeed(100, 0));
    }

    @Test
    void testFormatNumberInteger() {
        assertEquals("50", calculator.formatNumber(50.0));
        assertEquals("0", calculator.formatNumber(0.0));
        assertEquals("-3", calculator.formatNumber(-3.0));
    }

    @Test
    void testFormatNumberDecimal() {
        assertEquals("33.33", calculator.formatNumber(33.3333));
        assertEquals("2.50", calculator.formatNumber(2.5));
    }
}

