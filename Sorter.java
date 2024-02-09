/**
 * Esta clase implementa diferentes metodos de sorting para arrays utilizando genericos
 * @author Jose Merida - 201105
 * @author Adrian Lopez - 21357
 * @version 1.0
 * @since 08-02-2024
 */
public class Sorter <T extends Comparable<T>>{
    /**
     * Algoritmo gnomeSort que ordena un array de tipo T en orden ascendente
     * @param arr un Array de Tipo T que se desea ordenar
     * @param n la longitud del array
     */
    public void gnomeSort(T[] arr, int n) {
        int index = 0;
        while (index < n) {
            if (index == 0 || arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
    /**
     * Algoritmo mergeSort que ordena un array de tipo T en orden ascendente
     * Divide recursivamente el array en mitades, ordena cada mtiad y luego combina las mitades ordenadas
     * @param arr un Array de Tipo T que se desea ordenar
     * @param n la longitud del array
     */
    public void mergeSort(T[] arr, int n) {
        if (n < 2) {
            return;
        }
        //Encuentra el punto medio del array y crea 2 subarrays
        int mid = n / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[n - mid];

        //Llena los arrays creados anteriormente
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        //Recursion para ordenar las mitades
        mergeSort(left, mid);
        mergeSort(right, n - mid);

        //Une las mitades
        merge(arr, left, right, mid, n - mid);
    }
    /**
     * Metodo utilizado en mergeSort que une dos subarrays en un solo array ordenado
     * @param arr el array original
     * @param left el array izquierdo
     * @param right el array derecho
     * @param leftSize la longitud del array izquierdo
     * @param rightSize la longitud del array derecho
     */
    private void merge(T[] arr, T[] left, T[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Combina los arrays (dependiendo de la longitud del mas corto)
        while (i < leftSize && j < rightSize) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copia los elementos restantes del izquierdo
        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        // Copia los elementos restantes del derecho
        while (j < rightSize) {
            arr[k++] = right[j++];
        }
    }
    /**
     * Algoritmo quickSort para ordenar un array de tipo T en orden ascendente, en este caso se utiliza como
     * pivote el ultimo elemento del array
     * @param arr el array de tipo T que se desea ordenar
     * @param n la longitud del array
     */
    public void quickSort(T[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }
    /**
     * Metodo utilizado para ordenar un subarray del array principal utilizando quicksort
     * @param arr el array de tipo T que se desea ordenar
     * @param low el indice mas bajo del subarray
     * @param high el indice mas alto del subarray
     */
    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    /**
     * Metodo que crea particiones del array en torno a un pivote
     * @param arr el array que se desea ordenar
     * @param low el indice mas bajo del subarray
     * @param high el indice mas alto del subarray
     * @return el indice del pivote luego de la particion
     */
    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    /**
     * Metodo para intercambiar dos elementos de un array
     * @param arr el array en el que se realiza el intercambio
     * @param i el indice del primer elemento
     * @param j el indice del segundo elemento
     */
    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Algoritmo Radix Sort para ordenar un array de tipo T de manera ascendente, este utiliza sorting por medio de
     * comparacion de valores digito por digito. Es decir, primero ordena por unidades, luego decenas, etc...
     * @param arr el array que se desea ordenar
     * @param n la longitud del array
     */
    public void radixSort(T[] arr, int n) {
        // Encuentra el valor maximo del array para determinar el numero de digitos
        T max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        // Convierte el valor maximo a un string
        int maxDigits = String.valueOf(max).length();

        // Realiza un counting sort de cada digito desde el menos significativo al mas significativo
        for (int digit = 0; digit < maxDigits; digit++) {
            countingSort(arr, n, digit);
        }
    }

    /**
     * Metodo que realiza countingSort en un array de tipo T
     * @param arr el array que se desea ordenar
     * @param n la longitud del array
     * @param digit el digito en el que se basa la ordenacion
     */
    private void countingSort(T[] arr, int n, int digit) {
        // Crea los arrays de entrada y salida
        int[] count = new int[10];
        T[] output = (T[]) new Comparable[n];

        // Cuenta las ocurrencias de cada digito
        for (int i = 0; i < n; i++) {
            int digitValue = getDigitValue(arr[i], digit);
            count[digitValue]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construye el array de salioda
        for (int i = n - 1; i >= 0; i--) {
            int digitValue = getDigitValue(arr[i], digit);
            output[count[digitValue] - 1] = arr[i];
            count[digitValue]--;
        }

        // Copia el array de salida al array original
        System.arraycopy(output, 0, arr, 0, n);
    }
    /**
     * Obtiene el valor de un digito especifico
     * @param element elemento del array del que se desea obtener el valor
     * @param digit el digito que se desea obtener
     * @return el valor del digito en la posicion especificada
     */
    private int getDigitValue(T element, int digit) {
        String str = String.valueOf(element);
        int length = str.length();
        if (digit >= length) {
            return 0;
        } else {
            return Character.getNumericValue(str.charAt(length - 1 - digit));
        }
    }
    /**
     * Algoritmo Bubble Sort para ordenar un array de tipo T en orden ascendente
     * @param arreglo el array de tipo T que se desea ordenar
     * @param n la longitud del array
     */
    public void bubbleSort(T[] arreglo, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j].compareTo((arreglo[j + 1])) > 0) {
                    // Intercambiar arreglo[j] y arreglo[j + 1]
                    T temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }
}