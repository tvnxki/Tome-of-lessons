package example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты для сравнения чисел")
class NumberComparatorTest {

    private final NumberComparator comparator = new NumberComparator();

    @Test
    @DisplayName("Сравнение: первое больше второго")
    void testFirstGreater() {
        assertEquals(1, comparator.compare(5, 3));
        assertTrue(comparator.isGreaterThan(5, 3));
        assertFalse(comparator.isLessThan(5, 3));
        assertFalse(comparator.isEqual(5, 3));
    }

    @Test
    @DisplayName("Сравнение: первое меньше второго")
    void testFirstLess() {
        assertEquals(-1, comparator.compare(3, 5));
        assertTrue(comparator.isLessThan(3, 5));
        assertFalse(comparator.isGreaterThan(3, 5));
        assertFalse(comparator.isEqual(3, 5));
    }

    @Test
    @DisplayName("Сравнение: числа равны")
    void testEqual() {
        assertEquals(0, comparator.compare(5, 5));
        assertTrue(comparator.isEqual(5, 5));
        assertFalse(comparator.isGreaterThan(5, 5));
        assertFalse(comparator.isLessThan(5, 5));
    }
}
