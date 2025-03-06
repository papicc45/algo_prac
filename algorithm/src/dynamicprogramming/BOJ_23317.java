package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_23317 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 1;

        Set<int[]> set = new HashSet<>();
        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new int[] {x+1, y+1});
        }

        int x = 1, y = 1;
        while (x > n) {
            for( ; x<=n ; x++) {
                boolean check = false;
                for(; y<=n ; y++) {
                    int[] target = {x, y};
                    if(set.stream().anyMatch(arr -> Arrays.equals(arr, target))) {
                        check = true;
                    }

                    if(check) {
                        Arrays.fill(dp[x], 0);
                        dp[x][y] += dp[x-1][y-1] + dp[x-1][y];
                        break;
                    } else {
                        dp[x][y] += dp[x-1][y-1] + dp[x-1][y];
                    }
                }

                if(check)
                    break;
            }
        }

        System.out.println("123123");
        System.out.println("123123");

    }
}
