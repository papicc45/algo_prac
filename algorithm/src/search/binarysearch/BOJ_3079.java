package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int max = 0;
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        long start = 0;
        long end = m * max;
        long result = 0;
        while(start <= end) {
            long mid = (start + end) / 2;

            long cnt = 0;
            for(int val : arr) {
                if(cnt >= m) {
                    break;
                }
                cnt += mid / val;
            }

            if(cnt >= m) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
