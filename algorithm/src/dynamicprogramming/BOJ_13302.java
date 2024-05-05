package dynamicprogramming;

import com.sun.source.doctree.SeeTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.DataFormatException;

public class BOJ_13302 {
    static int result = Integer.MAX_VALUE;
    static int n;
    static Set<Integer> set;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        if(m != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<m ; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        dp = new int[n+1][n+1];

        for(int i=0 ; i<=n ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        recur(1, 0, 0);
        System.out.println(result);
    }
    private static void recur(int day, int coupon, int money) {
        if(day > n) {
            result = Math.min(result, money);
            return;
        }
        if(dp[day][coupon] > money)
            dp[day][coupon] = money;
        else
            return;


        if(set.contains(day))
            recur(day + 1, coupon, money);

        if(coupon >= 3)
            recur(day + 1, coupon - 3, money);

        recur(day + 1, coupon, money + 10000);
        recur(day + 3, coupon + 1, money + 25000);
        recur(day + 5, coupon + 2, money + 37000);
    }
}
