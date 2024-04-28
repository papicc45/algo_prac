package dynamicprogramming;

import java.util.Scanner;

public class BOJ_12852 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];

        dp[1] = 0;
        for(int i=2 ; i<=n ; i++) {
            dp[i] = dp[i-1] + 1;
            arr[i] = i - 1;

            if(i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
                dp[i] = dp[i/3] + 1;
                arr[i] = i/3;
            }
            if(i % 2 == 0 && dp[i/2] + 1 < dp[i]) {
                dp[i] = dp[i/2] + 1;
                arr[i] = i/2;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n + " ");
            n = arr[n];
        }
        System.out.println(sb.toString());
    }
}
