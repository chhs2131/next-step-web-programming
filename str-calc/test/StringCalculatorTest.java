import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    StringCalculator calc;

    @BeforeEach
    void setup() {
        calc = new StringCalculator();
    }

    @Test
    void add() {
        calc.add("1,2,3");

        calc.add("//;\n1;2;3");
    }
}