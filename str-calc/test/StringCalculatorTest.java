import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    private StringCalculator calc;

    @BeforeEach
    void setup() {
        calc = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자() {
        assertEquals(0, calc.add(null));
        assertEquals(0, calc.add(""));
    }

    @Test
    public void add_숫자하나() throws Exception {
        assertEquals(1, calc.add("1"));
    }

    @Test
    public void add_쉼표구분자() {
        assertEquals(3, calc.add("1,2"));
    }

    @Test
    public void split() {
        assertArrayEquals(new String[] {"1"}, "1".split(","));
        assertArrayEquals(new String[] {"1", "2"}, "1,2".split(","));
    }

    @Test
    void add() {
        calc.add("1,2,3");

        calc.add("//;\n1;2;3");
    }
}