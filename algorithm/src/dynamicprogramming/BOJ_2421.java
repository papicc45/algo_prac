package dynamicprogramming;

import java.io.BufferedReader;
import java.sql.SQLOutput;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_2421 {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prime = new boolean[1000000];

        prime[0] = false;
        prime[1] = false;
        for (int i = 2; i < 1000000; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i < 1000000; i++) {
            if (prime[i]) {
                for (int j = i * i; j < 1000000; j += i) {
                    prime[j] = false;
                }
            }
        }

        prime[11] = false;
        int n = sc.nextInt();
        int[][] dp = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++){
            for(int j=1 ; j<=n ; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + isPrime(i, j);
            }
        }

        System.out.println(dp[n][n]);
    }
    private static int isPrime(int x, int y) {
        int num = Integer.parseInt(x + "" + y);
        return prime[num] ? 1 : 0;
    }
}
