package dynamicprogramming;

import javax.xml.stream.events.StartDocument;
import java.util.Scanner;

public class BOJ_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stairs = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            stairs[i] = sc.nextInt();
        }

        int[] dp = new int[n+1];

        if(n == 1) {
            System.out.println(stairs[1]);
            return;
        } else if(n == 2) {
            System.out.println(stairs[1] + stairs[2]);
            return;
        } else if(n == 3) {
            System.out.println(Math.max(stairs[1], stairs[2]) + stairs[3]);
            return;
        }
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
        for(int i=4 ; i<=n ; i++) {
            dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2]) + stairs[i];
        }

        System.out.println(dp[n]);
    }
}
