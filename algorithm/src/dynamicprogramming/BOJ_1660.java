package dynamicprogramming;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ_1660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 0) {
            System.out.println(0);
            return;
        }

        int[] dp = new int[n+1];
        List<Integer> diff = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        diff.add(0);
        diff.add(1);
        list.add(0);
        list.add(1);

        int idx = 2;
        while (list.get(idx-1) <= n) {
            diff.add(diff.get(idx-1) + idx);
            list.add(diff.get(idx) + list.get(idx-1));
            idx++;
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ; i<=n ; i++) {
            for(int j=1 ; j<list.size() ; j++) {
                if(list.get(j) > i)
                    break;

                dp[i] = Math.min(dp[i], dp[i-list.get(j)] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
