package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n+1];
        for(int i=0 ; i<=n ; i++) {
            if(i == 0)
                continue;
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }

        int left = 1, right = 1;
        int result = Integer.MAX_VALUE;
        while (right <= n) {
            long sum = arr[right] - arr[left-1];
            if(sum >= s) {
                result = Math.min(result, right - left + 1);
                left++;
            } else {
                right++;
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
