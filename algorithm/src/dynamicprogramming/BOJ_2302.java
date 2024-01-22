package dynamicprogramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_2302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dp = new int[n+1];

        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<m ; i++)
            set.add(sc.nextInt());

        if(n <= 2) {
            System.out.println(n);
            return;
        }

        dp[0] = 1;
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++) {
            if(set.contains(i) || set.contains(i-1))
                dp[i] = dp[i-1];
            else
                dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);

    }
}
