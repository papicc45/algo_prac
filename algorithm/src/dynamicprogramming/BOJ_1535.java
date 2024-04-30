package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] life = new int[n+1];
        int[] happy = new int[n+1];
        int[] dp = new int[101];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            life[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1 ; i<=n ; i++) {
            for(int j=99 ; j>=0 ; j--) {
                if(j + life[i] < 100) {
                    dp[j+ life[i]] = Math.max(dp[j + life[i]], dp[j] + happy[i]);
                }
            }
        }
        System.out.println(dp[99]);
    }
}
