import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Sorter<Integer> sorter = new Sorter<Integer>();
        Integer[] intArray = new Integer[]{2,6,7,9,3,4,1};
        sorter.gnomeSort(intArray, 7);
        System.out.println(Arrays.toString(intArray));
    }
}