package dynamicprogramming;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[][] dp = new int[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1 ; i<=n ; i++) {
            dp[i][i] = 1;
        }

        for(int i=1 ; i<n ; i++) {
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
                dp[i+1][i] = 1;
            }
        }

        for(int i=2 ; i<n ; i++) {
            for(int j=1 ; j<=n-i ; j++) {
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1] == 1)
                    dp[j][j+i] = 1;
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        while (m != 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(dp[start][end] == 1)
                bw.write("1\n");
            else
                bw.write("0\n");
            m--;
        }
        bw.flush();
        bw.close();
    }
}
