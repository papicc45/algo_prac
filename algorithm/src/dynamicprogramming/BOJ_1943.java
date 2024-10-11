package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (!(str = br.readLine()).equals("")) {
            int n = Integer.parseInt(str);

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
            dp[0] = true;
            for(int i=0 ; i<=100000 ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(i - costs[j] >= 0 && dp[i - costs[j]]) {
                        if(cnts[j] > 0) {
                            dp[i] = true;
                            cnts[j]--;
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
