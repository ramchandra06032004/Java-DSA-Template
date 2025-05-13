

import java.util.Arrays;

import java.util.Scanner;

public class codeforcesTemplate {

    static Scanner sc = new Scanner(System.in);

    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static long[] takeArrayInput(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    public static int[][] takeMatrixInput(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    public static long sumOfDigits(long n) {
        long sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static long lowerBound(long[] nums, long value) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(int[] nums, long value) {
        int low = 0;
        int high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static long findSum(long[] arr) {
        long sum = 0;
        for (long i : arr) {
            sum += i;
        }
        return sum;
    }

    //////////////////////////// MAIN FUNCTION ////////////////////////////

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        int n=sc.nextInt();
        int k=sc.nextInt();
        if (k%2==1) {
            for(int i=0;i<n-1;i++){
                System.out.print(n+" ");
            }
            System.out.print(n-1);
        }else{
            int[] arr=new int[n];
            Arrays.fill(arr, n);
            arr[n-1]--;
            for(int i=0 ; i<n ; i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
        

}
/*
1 4
0 0 1 1
 */