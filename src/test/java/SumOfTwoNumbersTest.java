import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumOfTwoNumbersTest {

    // Реализация
    public static class SumOfTwoNumbers {
        public int sum(String input1, String input2) {
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);
            return number1 + number2;
        }
    }

    // Тесты
    @Test
    public void testValidSum() {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        assertEquals(5, sumOfTwoNumbers.sum("2", "3"));
        assertEquals(0, sumOfTwoNumbers.sum("0", "0"));
        assertEquals(-5, sumOfTwoNumbers.sum("-2", "-3"));
    }

    @Test
    public void testInvalidInput() {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        assertThrows(NumberFormatException.class, () -> sumOfTwoNumbers.sum("abc", "3"));
        assertThrows(NumberFormatException.class, () -> sumOfTwoNumbers.sum("2", "def"));
    }
}