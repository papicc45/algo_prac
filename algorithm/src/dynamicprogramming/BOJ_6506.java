package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if(N == 0 && K == 0) break;

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long[][] dp = new long[N][K+1];


            for(int i=0 ; i<N ; i++) {
                dp[i][1] = 1;
                for(int j=1 ; j<=Math.min(K, i+1) ; j++) {
                    for(int k=0 ; k<i ; k++) {
                        if(arr[i] > arr[k]) {
                            dp[i][j] += dp[k][j-1];
                        }
                    }
                }
            }
            long result = 0;
            for(int i=0 ; i<N ; i++)
                result += dp[i][K];

            System.out.println(result);
        }
    }
}
