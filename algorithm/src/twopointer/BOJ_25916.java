package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0;
        long sum = 0;
        long result = 0;
        while (right < n) {
            if(sum + arr[right] <= m) {
                sum += arr[right];
                result = Math.max(sum, result);
                right++;
            } else {
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(result);
    }
}
