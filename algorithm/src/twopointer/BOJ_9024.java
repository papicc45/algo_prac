package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i=0 ; i<n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int left = 0;
            int right = n-1;
            int near = Integer.MAX_VALUE;
            int count = 0;
            while (left < right) {
                int sum = arr[left] + arr[right];
                int diff = Math.abs(sum - k);

                if(diff < near) {
                    near = diff;
                    count = 1;
                } else if(diff == near) {
                    count++;
                }

                if(sum < k) {
                    left++;
                } else if(sum > k) {
                    right--;
                } else {
                    left++;
                    right--;
                }
            }

            System.out.println(count);
        }
    }
}
