import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Sorter<Integer> sorter = new Sorter<Integer>();
        Integer[] intArray = new Integer[]{2,6,7,9,3,4,1};

        //Ejemplos de uso:
        //sorter.gnomeSort(intArray, 7);
        //sorter.MergeSortRecursive(intArray, new Comparable[intArray.length], 0, intArray.length - 1);
        //sorter.quicksort(intArray, 0,intArray.length-1);
        sorter.radixSort(intArray);
        System.out.println(Arrays.toString(intArray));


    }
}