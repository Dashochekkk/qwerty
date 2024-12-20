import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TripletTest {

    // Реализация
    public static class Triplet<A extends Comparable<A>> {
        private final A first;
        private final A second;
        private final A third;

        public Triplet(A first, A second, A third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public boolean contains(A element) {
            return first.equals(element) || second.equals(element) || third.equals(element);
        }

        public A getSmallest() {
            A smallest = first;
            if (second.compareTo(smallest) < 0) {
                smallest = second;
            }
            if (third.compareTo(smallest) < 0) {
                smallest = third;
            }
            return smallest;
        }

        public A sum() {
            if (first instanceof Number && second instanceof Number && third instanceof Number) {

                double sum = ((Number) first).doubleValue() + ((Number) second).doubleValue() + ((Number) third).doubleValue();

                if (first instanceof Integer && second instanceof Integer && third instanceof Integer) {
                    return (A) (Integer) (int) sum;
                } else {
                    return (A) (Double) sum;                 }
            } else if (first instanceof String && second instanceof String && third instanceof String) {

                return (A) (first.toString() + " " + second.toString() + " " + third.toString());
            } else {

                throw new IllegalArgumentException("Все элементы должны быть одного типа (число или строка).");
            }
        }
    }

    // Тесты
    @Test
    public void testContains() {
        Triplet<Integer> triplet = new Triplet<>(1, 2, 3);
        assertTrue(triplet.contains(2));
        assertFalse(triplet.contains(4));
    }

    @Test
    public void testGetSmallest() {
        Triplet<Integer> triplet = new Triplet<>(3, 1, 2);
        assertEquals(1, triplet.getSmallest());
    }

    @Test
    public void testSum() {
        Triplet<Integer> triplet = new Triplet<>(1, 2, 3);
        assertEquals(6, triplet.sum());

        Triplet<String> stringTriplet = new Triplet<>("A", "B", "C");
        assertEquals("A B C", stringTriplet.sum());
    }
}