import java.util.Arrays;

public class Quicksort {
    public static void main(String[] args) {
        int[] arr={56,55,8,45,62,11,44,2,44,788,57,1000000};
        divide(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));        
    }
    public static void divide(int[] arr,int low,int high){
        if (low<high) {
            int pivotIndex=partition(arr,low,high);
            divide(arr, low, pivotIndex-1);
            divide(arr, pivotIndex+1,high);
        }
    }
    public static int partition(int[] arr,int low,int high){
        int i=low;
        int j=high;

        while (i<j) {
            int pivot=arr[low];
            while (i<=high && arr[i]<=pivot) {
                i++;
            }
            while(j>=low && arr[j]>pivot){
                j--;
            }
            if (i<j) {
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
