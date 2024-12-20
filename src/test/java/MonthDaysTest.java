import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonthDaysTest {

    // Реализация
    public static class MonthDays {
        private String[] months = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        private int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        public String getMonthAndDays(int monthNumber) {
            return "Месяц: " + months[monthNumber - 1] + ", Количество дней: " + days[monthNumber - 1];
        }
    }

    // Тесты
    @Test
    public void testValidMonth() {
        MonthDays monthDays = new MonthDays();
        assertEquals("Месяц: Январь, Количество дней: 31", monthDays.getMonthAndDays(1));
        assertEquals("Месяц: Февраль, Количество дней: 28", monthDays.getMonthAndDays(2));
        assertEquals("Месяц: Декабрь, Количество дней: 31", monthDays.getMonthAndDays(12));
    }

    @Test
    public void testInvalidMonth() {
        MonthDays monthDays = new MonthDays();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> monthDays.getMonthAndDays(13));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> monthDays.getMonthAndDays(0));
    }
}