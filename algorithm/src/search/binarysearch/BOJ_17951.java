package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int left = Integer.MAX_VALUE;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.min(left, arr[i]);
            right += arr[i];
        }

        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = makeGroup(arr, mid);

            if(cnt >= k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
    private static int makeGroup(int[] arr, int mid) {
        int sum = 0;
        int cnt = 0;

        for(int i=0 ; i<arr.length ; i++) {
            sum += arr[i];
            if(sum >= mid) {
                cnt++;
                sum = 0;
            }
        }

        return cnt;
    }
}
