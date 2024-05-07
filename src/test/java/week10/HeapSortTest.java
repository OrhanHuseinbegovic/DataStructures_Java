package week10;

import org.junit.jupiter.api.Test;
import week10.labTask.HeapSort;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {
    private static class Student implements Comparable<Student> {
        String name;
        double gpa;

        public Student(String name, double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        @Override
        public int compareTo(Student o) {
            return Double.compare(this.gpa, o.gpa);
        }
    }

    @Test
    public void testIntegerSorting() {
        Integer[] array = {5, -1, 7, 19, 3, 12, 4};

        HeapSort.sort(array);

        assertEquals(-1, array[0]);
        assertEquals(3, array[1]);
        assertEquals(4, array[2]);
        assertEquals(5, array[3]);
        assertEquals(7, array[4]);
        assertEquals(12, array[5]);
        assertEquals(19, array[6]);
    }

    @Test
    public void testDoubleSorting() {
        Double[] array = {3.4, -11.2, 43.6, 22.5, 7.12, 5.24, 66.2};

        HeapSort.sort(array);

        assertEquals(-11.2, array[0]);
        assertEquals(3.4, array[1]);
        assertEquals(5.24, array[2]);
        assertEquals(7.12, array[3]);
        assertEquals(22.5, array[4]);
        assertEquals(43.6, array[5]);
        assertEquals(66.2, array[6]);
    }

    @Test
    public void testCharacterSorting() {
        Character[] array = {'y', 'm', 'a', 'c', 's', 'h', 'b'};

        HeapSort.sort(array);

        assertEquals('a', array[0]);
        assertEquals('b', array[1]);
        assertEquals('c', array[2]);
        assertEquals('h', array[3]);
        assertEquals('m', array[4]);
        assertEquals('s', array[5]);
        assertEquals('y', array[6]);
    }

    @Test
    public void testStringSorting() {
        String[] array = {"qSiVYcEivp", "KHvpckFnVd", "RLbAwtkquH", "YmWxBwcHOZ", "NNAXXpPkpR", "hfRcldttwR", "lWtzsZCyPh"};

        HeapSort.sort(array);

        assertEquals("KHvpckFnVd", array[0]);
        assertEquals("NNAXXpPkpR", array[1]);
        assertEquals("RLbAwtkquH", array[2]);
        assertEquals("YmWxBwcHOZ", array[3]);
        assertEquals("hfRcldttwR", array[4]);
        assertEquals("lWtzsZCyPh", array[5]);
        assertEquals("qSiVYcEivp", array[6]);
    }

    @Test
    public void testCustomObjectSorting() {
        Student[] array = {
                new Student("Student A", 6.3),
                new Student("Student B", 9.93),
                new Student("Student C", 5.76),
                new Student("Student D", 8.21),
                new Student("Student E", 7.74),
                new Student("Student F", 10.0),
                new Student("Student G", 9.2)
        };

        HeapSort.sort(array);

        assertEquals(5.76, array[0].gpa);
        assertEquals(6.3, array[1].gpa);
        assertEquals(7.74, array[2].gpa);
        assertEquals(8.21, array[3].gpa);
        assertEquals(9.2, array[4].gpa);
        assertEquals(9.93, array[5].gpa);
        assertEquals(10.0, array[6].gpa);
    }

    @Test
    public void testLargeRandomSort() {
        int size = 10000000;
        Integer[] array = new Integer[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(size * 10);
        }

        Integer[] sorted = array.clone();
        Arrays.sort(sorted);

        HeapSort.sort(array);
        assertArrayEquals(sorted, array);
    }
}