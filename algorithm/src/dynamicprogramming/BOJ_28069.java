package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_28069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if(i + 1 <= n)
                dp[i+1] = Math.min(dp[i+1], dp[i] + 1);

            int a = i + i / 2;
            if(a <= n)
                dp[a] = Math.min(dp[a], dp[i] + 1);
        }

        if(dp[n] <= k)
            System.out.println("minigimbob");
        else
            System.out.println("water");
    }
}
