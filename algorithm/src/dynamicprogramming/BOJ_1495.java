package dynamicprogramming;

import javax.naming.AuthenticationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[m+1];
        Arrays.fill(dp, -1);
        dp[s] = 0;

        for(int i=1 ; i<=n ; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0 ; j<=m ; j++) {
                if(dp[j] == i-1) {
                    int plus = j + arr[i];
                    int minus = j - arr[i];

                    if(minus >= 0)
                        list.add(minus);
                    if(plus <= m)
                        list.add(plus);
                }
            }
            for(int num : list)
                dp[num] = i;
        }
        int answer = -1;
        for(int i=0 ; i<=m ; i++) {
            if(dp[i] == n)
                answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
