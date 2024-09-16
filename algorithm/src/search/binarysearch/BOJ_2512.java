package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int left = 0;
        int right = 0;
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            for(int i=0 ; i<n ; i++) {
                if(arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if(sum > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        System.out.println(right);
    }
}
