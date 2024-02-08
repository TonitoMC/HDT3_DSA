import java.util.Collections;

import static java.util.Collections.swap;

public class Sorter <T extends Comparable<T>>{
    public void gnomeSort(T arr[], int n){
        int index = 0;
        while (index < n){
            if (index == 0){
                index++;
            }
            if (arr[index].compareTo(arr[index - 1]) > 0){
                index++;
            } else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
    

}
