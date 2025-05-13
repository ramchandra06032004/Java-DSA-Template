import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws java.lang.Exception {
        int t = sc.nextInt();
        while (t-- > 0)
            solve();
    }

    public static void solve() {
        int n=sc.nextInt();
        int[] arr=new int[2*n];
        for(int i=0;i<2*n;i++){
            arr[i]=sc.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans=0;

        for(int i=0 ; i<2*n ; i+=2){
            pq.add(arr[i]);
            pq.add(arr[i+1]);
            pq.poll();
            System.out.println(pq);
            
        }

        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        
        System.out.println(ans );
    }

}

/*
 1 5
1 100 90 80 5 4 3 6 70 7
 */