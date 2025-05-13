import java.util.ArrayList;
import java.util.Arrays;

public class Mergesort {

    public static void main(String[] args) {
        int[] arr={56,55,8,45,62,11,44,2,44,788,57};
        divide(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));        
    }
    public static void divide(int[] arr,int low,int high){
        if (low<high) {
            
            int mid=(low+high)/2;
            divide(arr, low, mid);
            divide(arr, mid+1, high);
            conqure(arr,low,mid,high);
        }
    }
    public static void conqure(int[] arr,int low,int mid,int high){
        ArrayList<Integer> list=new ArrayList<>();
        int p1=low;
        int p2=mid+1;
        
        while (p1<=mid && p2<=high) {
            int leftEle=arr[p1];
            int rightEle=arr[p2];

            if (leftEle<rightEle) {
                list.add(leftEle);
                p1++;
            }else{
                list.add(rightEle);
                p2++;
            }
        }

        while (p1<=mid) {
            list.add(arr[p1]);
            p1++;
        }

        while (p2<=high) {
            list.add(arr[p2]);
            p2++;
        }

        //copy all elements to main
        int tempPointer=0;
        for(int i=low; i<=high ; i++){
            arr[i]=list.get(tempPointer);
            tempPointer++;
        }
    }
}