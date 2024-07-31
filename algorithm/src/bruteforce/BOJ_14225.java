package bruteforce;

import java.util.Scanner;

public class BOJ_14225 {
    static boolean[] check = new boolean[2000001];
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
        }

        recur(0, 0);
        for(int i=1 ; i<check.length ; i++) {
            if(!check[i]) {
                System.out.println(i);
                break;
            }
        }

    }
    private static void recur(int idx, int sum) {
        if(idx == n) {
            check[sum] = true;
            return;
        }

        recur(idx+1, sum + arr[idx]);
        recur(idx+1, sum);
    }
}
