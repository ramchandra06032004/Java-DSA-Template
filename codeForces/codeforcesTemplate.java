
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

    public static void main(String[] args) {
        int t = sc.nextInt();

        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        int n = sc.nextInt();
        String s = sc.next();

        long underScore = 0;
        long dash = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '-') {
                dash++;
            } else {
                underScore++;
            }
        }
        if (dash < 2 || underScore < 1) {
            System.out.println(0);
        } else {
            if (dash % 2 == 0) {
                System.out.println((underScore * (dash / 2) * (dash / 2)));
            }else{
                System.out.println((underScore * ((dash / 2)+1) * (dash / 2)));
            }
        }
    }

}
/*
 * 1 6 1
 * 2 4 1 1 1 1
 */