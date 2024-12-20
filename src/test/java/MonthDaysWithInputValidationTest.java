import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonthDaysWithInputValidationTest {

    // Реализация
    public static class MonthDaysWithInputValidation {
        private String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public String getMonthAndDays(String input) {
            int monthNumber = Integer.parseInt(input);
            if (monthNumber < 1 || monthNumber > 12) {
                throw new NumberFormatException("Недопустимое число");
            }
            return "Месяц: " + months[monthNumber - 1] + ", Количество дней: " + days[monthNumber - 1];
        }
    }

    // Тесты
    @Test
    public void testValidInput() {
        MonthDaysWithInputValidation monthDays = new MonthDaysWithInputValidation();
        assertEquals("Месяц: Январь, Количество дней: 31", monthDays.getMonthAndDays("1"));
        assertEquals("Месяц: Февраль, Количество дней: 28", monthDays.getMonthAndDays("2"));
    }

    @Test
    public void testInvalidInput() {
        MonthDaysWithInputValidation monthDays = new MonthDaysWithInputValidation();
        assertThrows(NumberFormatException.class, () -> monthDays.getMonthAndDays("abc"));
        assertThrows(NumberFormatException.class, () -> monthDays.getMonthAndDays("13"));
    }
}