package dynamicprogramming;

import java.util.Scanner;

public class BOJ_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        for(int i=1 ; i<=n ; i++) {
            arr[i] = sc.nextInt();
        }
        if(n == 1) {
            System.out.println(arr[1]);
            return;
        } else if(n == 2) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(dp[2], Math.max(dp[1] + arr[3], dp[0] + arr[2] + arr[3]));

        for(int i=4 ; i<=n ; i++) {
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
        }
        System.out.println(dp[n]);
    }
}
