package example;


import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberComparatorTest {

    private final NumberComparator comparator = new NumberComparator();

    @Test(description = "Сравнение: первое больше второго")
    public void testFirstGreater() {
        assertEquals(comparator.compare(5, 3), 1);
        assertTrue(comparator.isGreaterThan(5, 3));
        assertFalse(comparator.isLessThan(5, 3));
        assertFalse(comparator.isEqual(5, 3));
    }

    @Test(description = "Сравнение: первое меньше второго")
    public void testFirstLess() {
        assertEquals(comparator.compare(3, 5), -1);
        assertTrue(comparator.isLessThan(3, 5));
        assertFalse(comparator.isGreaterThan(3, 5));
        assertFalse(comparator.isEqual(3, 5));
    }

    @Test(description = "Сравнение: числа равны")
    public void testEqual() {
        assertEquals(comparator.compare(5, 5), 0);
        assertTrue(comparator.isEqual(5, 5));
        assertFalse(comparator.isGreaterThan(5, 5));
        assertFalse(comparator.isLessThan(5, 5));
    }
}
