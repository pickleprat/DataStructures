package MyHotel; 
import java.util.Arrays; 

public class Sort {
    static void selectionSort(int[] arr){
        int minIndex; 
        for(int i =0; i<arr.length-1; i++){
            minIndex = i; 
            for(int j=i+1; j<arr.length; j++){

                if(arr[minIndex]>arr[j]){
                    minIndex = j; 
                }
            }
            if(i == minIndex) continue; 
            int temp = arr[i]; 
            arr[i] = arr[minIndex]; 
            arr[minIndex] = temp; 
        }
    }

    static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i>0; i--){
            for(int j =0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j]; 
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; 
                } 
            }
        } 
    }

    public static void main(String[] args){

        int[] myArray = {1, 34, 57, 2, 7, 2, 7}; 
        selectionSort(myArray); 
        System.out.println(Arrays.toString(myArray)); 

    }
    
}
