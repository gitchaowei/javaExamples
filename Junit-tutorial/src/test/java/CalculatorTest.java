import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    @DisplayName("Test: Add two numbers")
//    @Disabled
    void test_add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    @DisplayName("Test: Multiply two numbers")
    void test_multiply() {
        Assertions.assertAll(
                ()-> assertEquals(4, Calculator.multiply(2, 2)),
                () -> assertEquals(-4, Calculator.multiply(2, -2)),
                () -> assertEquals(4, Calculator.multiply(-2, -2)),
                () -> assertEquals(0, Calculator.multiply(1, 0))
        );
    }
}


