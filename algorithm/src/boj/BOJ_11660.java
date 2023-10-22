package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];
        long[] remain = new long[m];
        long result = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        for(int i=1 ; i<=n ; i++) {
            int rem = (int)(arr[i] % m);
            if(rem == 0)
                result++;

            remain[rem]++;
        }

        for(int i=0 ; i<m ; i++) {
            if(remain[i] > 1)
                result = result + (remain[i] * (remain[i]-1) / 2);
        }

        System.out.println(result);
    }
}
