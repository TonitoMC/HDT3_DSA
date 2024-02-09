import java.util.Collections;

import static java.util.Collections.swap;

public class Sorter <T extends Comparable<T>>{
    ////////////////////////////////
    //Gnome sort:
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
    /////////////////////////////////
    //Algoritmo Merge Sort
    public void MergeSortRecursive(Comparable[] list, Comparable temp[],int low, int high)
    {
      int n = high-low+1;
      int middle=low+n/2;
      int i;
      if (n<2) return;
      for(i=low;i<middle;i++)
      {
          temp[i]=list[i];
      }
      MergeSortRecursive(temp,list,low,middle-1);
      MergeSortRecursive(list,temp,middle,high);
      merge(list, temp,low, middle, high);
   }

    public void merge(Comparable[] list, Comparable temp[], int low, int middle, int high)
   {
         int ri=low;
         int ti=low;
         int di=middle;
         while(ti < middle && di <= high){
             if (list[di].compareTo(temp[ti])>0)
                 list[ri++]=list[di++];
             else
                 list[ri++]=temp[ti++];
         }
         while (ti < middle)
             list[ri++]=temp[ti++];
     }
    
    //////////////////////////////////
    //Algoritmo Quick Sort:
   
    ///Metodo donde se ordenan los datos.
    public void swap(Comparable[] data, int i , int j)
    {
        Comparable temp;
        temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
   
   ///Metodo donde se hace la particion del QuickSort
    private int partition(Comparable numeros[],int izq, int der){
        while(true){
            while(izq<der&&(numeros[izq].compareTo(numeros[der]))>0)der--;
                if(izq<der)swap(numeros,izq++,der);
                else return izq;
                while(izq<der&&(numeros[izq].compareTo(numeros[der])>0))izq++;
                    if(izq<der)swap(numeros,izq,der--);
                    else return der;
        }
    }

    public void  quicksort(Comparable numeros[], int izq, int der){
        int pivot;
        /*Verificacion que los index sean correctos*/
        if (izq >= der) return;
        
        //mis index que funcionan como constantes que almacenan los index en condiciones iniciales
        //int i = izq;
        //int d = der;
        pivot=partition(numeros,izq,der);
        quicksort(numeros,izq,pivot-1);
        quicksort(numeros,pivot+1,der);
        
    }

    //////////////////////////////////////
    //Algoritmo RadixSort
    public void radixSort(Comparable[] arreglo) {
        if (arreglo == null || arreglo.length == 0) {
            return;
        }
        
        // Encontrar el valor máximo en el arreglo
        int max = Integer.MIN_VALUE;
        for (Comparable elemento : arreglo) {
            int valor = (int) elemento;
            if (valor > max) {
                max = valor;
            }
        }
        
        // Realizar el Radix Sort
        for (int exp = 1; max / exp > 0; exp *= 10) {
            // Inicializar el arreglo de contadores
            int[] count = new int[10];
            
            // Contar la frecuencia de cada dígito en el arreglo
            for (Comparable elemento : arreglo) {
                int valor = (int) elemento;
                count[(valor / exp) % 10]++;
            }
            
            // Calcular la posición de inicio de cada dígito en el arreglo ordenado
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            
            // Construir el arreglo ordenado
            Comparable[] output = new Comparable[arreglo.length];
            for (int i = arreglo.length - 1; i >= 0; i--) {
                int valor = (int) arreglo[i];
                output[count[(valor / exp) % 10] - 1] = arreglo[i];
                count[(valor / exp) % 10]--;
            }
            
            // Copiar el arreglo ordenado de vuelta al arreglo original
            System.arraycopy(output, 0, arreglo, 0, arreglo.length);
        }
    }
}
