package dynamicprogramming;

import java.util.Scanner;

public class BOJ_5582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int result = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int i=1 ; i<=str1.length() ; i++) {
            for(int j=1 ; j<=str2.length() ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

        System.out.println(result);
    }
}
