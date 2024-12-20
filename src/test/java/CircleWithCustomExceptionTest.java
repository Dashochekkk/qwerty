import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleWithCustomExceptionTest {

    // Реализация
    public static class CircleWithCustomException {
        private double radius;

        public CircleWithCustomException(double radius) throws InvalidRadiusException {
            setRadius(radius);
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) throws InvalidRadiusException {
            if (radius >= 0) {
                this.radius = radius;
            } else {
                throw new InvalidRadiusException(radius);
            }
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class InvalidRadiusException extends Exception {
        private double radius;

        public InvalidRadiusException(double radius) {
            super("Недопустимый радиус: " + radius);
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }

    // Тесты
    @Test
    public void testValidRadius() throws InvalidRadiusException {
        CircleWithCustomException circle = new CircleWithCustomException(5);
        assertEquals(5, circle.getRadius());
        assertEquals(78.53981633974483, circle.getArea());
    }

    @Test
    public void testInvalidRadius() {
        assertThrows(InvalidRadiusException.class, () -> new CircleWithCustomException(-5));
    }
}