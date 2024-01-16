package dynamicprogramming;

import java.util.Scanner;

public class BOJ_1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];

        if(n  <= 3) {
            System.out.println(n);
            return;
        } else {
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 3;
            for(int i=4 ; i<=n ; i++) {
                dp[i] = dp[i-1] + 1;
                for(int j=1 ; j<=(int)(Math.sqrt(i)) ; j++) {
                    int pow = j * j;
                    dp[i] = Math.min(dp[i], dp[i-pow] + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
