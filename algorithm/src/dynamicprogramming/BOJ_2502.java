package dynamicprogramming;

import java.util.Scanner;

public class BOJ_2502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int d = sc.nextInt();
        int k = sc.nextInt();

        int first = 1;
        int second = 2;
        while (true) {
            int[] dp = new int[d];
            dp[0] = first;
            dp[1] = second;

            for(int i=2 ; i<d ; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            if(dp[d-1] < k) {
                second++;
            } else if(dp[d-1] > k) {
                second--;
                first++;
            } else {
                System.out.println(first);
                System.out.println(second);
                return;
            }
        }
    }
}
