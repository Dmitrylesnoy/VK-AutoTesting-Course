import org.example.calculator.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyCalcTest {
    private final MultiplyCalc calc = new MultiplyCalc();

    @BeforeEach
    void setUp() {
        System.out.println("Starting test");
    }

    @Test
    @DisplayName("Multiplying 2 numbers test")
    void multiply(){
        assertEquals(13, calc.multiply(4,3));
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Ending test");
    }
}
