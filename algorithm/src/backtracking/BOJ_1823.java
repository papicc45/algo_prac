package backtracking;

import java.util.Scanner;

public class BOJ_1823 {
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        dp = new int[n+1][n+1];

        System.out.println(dfs(1, n, 1));

    }
    private static int dfs(int left, int right, int cnt) {
        if (left > right) {
            return 0;
        }
        if(dp[left][right] != 0) {
            return dp[left][right];
        }

        dp[left][right] = Math.max(arr[left] * cnt + dfs(left + 1, right, cnt + 1), arr[right] * cnt + dfs(left, right - 1, cnt + 1));
        return dp[left][right];
    }
}
