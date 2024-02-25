package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = (num % 2 == 0 ? true : false);
        }

        int max = 0;
        int start = 0, end = 0;
        int count = 0;
        while (end < n) {
            if(count < k) {
                if(!arr[end]) {
                    count++;
                }
                end++;
                max = Math.max(max, end - start - count);
            } else if(arr[end]) {
                end++;
                max = Math.max(max, end - start - count);
            } else {
                if(!arr[start]) {
                    count--;
                }
                start++;
            }
        }
        System.out.println(max);
    }
}
