package search.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        long[] arr = new long[s];

        long left = 1;
        long right = 1000000000;
        long result = 0;
        for(int i=0 ; i<s ; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i=0 ; i<s ; i++) {
                cnt += (arr[i] / mid);
            }

            if(cnt < c) {
                right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        long sum = 0;
        for(int i=0 ; i<s ; i++) {
            sum += arr[i];
        }

        System.out.println(sum - (result * c));
    }
}
