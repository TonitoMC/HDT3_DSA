/**
 * Este programa ordena e imprime arrays ordenados utilizando diferentes metodos de sorting
 * @author Jose Merida - 201105
 * @author Adrian Lopez - 21357
 * @version 1.0
 * @since 08-02-2024
 */

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Sorter<Integer> sorter = new Sorter<Integer>();
        /**
         * Loops que generan arrays de numeros aleatorios para ser ordenados por cada algoritmo de sort, desde longitud
         * 10 hasta 3000
         */
        for (int i = 10; i <= 3000; i++) {
            Integer[] currentArray = generateRandomArray(i);
            sorter.gnomeSort(currentArray, i);
            System.out.println("Gnome " + i + " elementos");
        }
        for (int i = 10; i <= 3000; i++){
            Integer[] currentArray = generateRandomArray(i);
            sorter.mergeSort(currentArray, i);
            System.out.println("Merge " + i + " elementos");
        }
        for (int i = 10; i <= 3000; i++){
            Integer[] currentArray = generateRandomArray(i);
            sorter.quickSort(currentArray, i);
            System.out.println("Quick " + i + " elementos");
        }
        for (int i = 10; i <= 3000; i++){
            Integer[] currentArray = generateRandomArray(i);
            sorter.radixSort(currentArray, i);
            System.out.println("Radix: " + i + " elementos");
        }
        for (int i = 10; i <= 3000; i++){
            Integer[] currentArray = generateRandomArray(i);
            sorter.bubbleSort(currentArray, i);
            System.out.println("Bubble " + i + " elementos");
        }
    }
    /**
     * Metodo para generar arrays de numeros aleatorios
     * @param length la longitud del array
     * @return el array
     */
    public static Integer[] generateRandomArray(int length) {
        Integer[] randomArray = new Integer[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt(2991) + 10;
        }
        return randomArray;
    }
}
