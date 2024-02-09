import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @org.junit.jupiter.api.Test
    void gnomeSort() {
        Integer[] testArr = {100,105,99,72,45,300,234,564,1,222};
        Integer[] sortedArr = {1, 45, 72, 99, 100, 105, 222, 234, 300, 564};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.gnomeSort(testArr, testArr.length);
        assertArrayEquals(testArr, sortedArr);
    }

    @org.junit.jupiter.api.Test
    void mergeSort() {
        Integer[] testArr = {100,105,99,72,45,300,234,564,1,222};
        Integer[] sortedArr = {1, 45, 72, 99, 100, 105, 222, 234, 300, 564};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.mergeSort(testArr, testArr.length);
        assertArrayEquals(testArr, sortedArr);
    }

    @org.junit.jupiter.api.Test
    void quickSort() {
        Integer[] testArr = {100,105,99,72,45,300,234,564,1,222};
        Integer[] sortedArr = {1, 45, 72, 99, 100, 105, 222, 234, 300, 564};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.quickSort(testArr, testArr.length);
        assertArrayEquals(testArr, sortedArr);
    }

    @org.junit.jupiter.api.Test
    void radixSort() {
        Integer[] testArr = {100,105,99,72,45,300,234,564,1,222};
        Integer[] sortedArr = {1, 45, 72, 99, 100, 105, 222, 234, 300, 564};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.radixSort(testArr, testArr.length);
        assertArrayEquals(testArr, sortedArr);
    }

    @org.junit.jupiter.api.Test
    void bubbleSort() {
        Integer[] testArr = {100,105,99,72,45,300,234,564,1,222};
        Integer[] sortedArr = {1, 45, 72, 99, 100, 105, 222, 234, 300, 564};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.bubbleSort(testArr, testArr.length);
        assertArrayEquals(testArr, sortedArr);
    }
}