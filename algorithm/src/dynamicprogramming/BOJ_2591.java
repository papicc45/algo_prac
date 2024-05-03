package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BOJ_2591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");

        int len = str.length;
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i=1 ; i<len ; i++) {
            dp[i] += dp[i-1];
            if(Integer.parseInt(str[i-1] + str[i]) <= 34) {
                dp[i]++;
            }
        }
        System.out.println(dp[len-1]);

    }
}
