
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
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
        int n = sc.nextInt();
        long[] arr = takeArrayInput(n);
        long sum = findSum(arr);

        Arrays.sort(arr);
        long m = sc.nextLong();
        while (m-- > 0) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            long coin = 0;
            long s = 0;
            long c = 0;

            long itr = lowerBound(arr, x);
            long ans;

            if (itr == arr.length) {
                ans = arr[n - 1];
                if (ans < x) {
                    coin = x - ans;
                }
                s = sum - ans;
                if (s < y) {
                    coin += y - s;
                }
            } else {
                ans = arr[(int)itr];
                if (ans < x) {
                    coin = x - ans;
                }
                s = sum - ans;
                if (s < y) {
                    coin += y - s;
                }
                if (itr != 0) {
                    ans = arr[(int)(itr - 1)];
                    if (ans < x) {
                        c = x - ans;
                    }
                    s = sum - ans;
                    if (s < y) {
                        c += y - s;
                    }
                    coin = Math.min(coin, c);
                }
            }
            System.out.println(coin);

        }
    }

    public static void solve() {
    }
        

}
/*
 * 1 6 1
 * 2 4 1 1 1 1
 */