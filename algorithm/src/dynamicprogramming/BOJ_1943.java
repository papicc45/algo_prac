package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 0;
        while (++t <= 3) {
            int n = Integer.parseInt(br.readLine());
            boolean[] dp = new boolean[100001];
            int sum = 0;
            int[] costs = new int[n];
            int[] cnts = new int[n];
            for(int i=0 ; i<n ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cost = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                sum += (cost * cnt);
                costs[i] = cost;
                cnts[i] = cnt;
            }

            if(sum % 2 != 0) {
                System.out.println("0");
                continue;
            }
            dp[0] = true;
            for(int i=0 ; i<n ; i++) {
                for(int j=sum/2 ; j>=costs[i] ; j--) {
                    if(dp[j - costs[i]]) {
                        for(int k=1 ; k<=cnts[i] ; k++) {
                            dp[j-costs[i] + costs[i] * k] = true;
                        }
                    }
                }
            }


            if(dp[sum/2])
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
