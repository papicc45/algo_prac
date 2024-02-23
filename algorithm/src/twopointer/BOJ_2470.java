package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;

        int min = Integer.MAX_VALUE;
        int result1 = 0, result2 = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];
            int diff = Math.abs(0 - sum);
            if(min > diff) {
                min = diff;
                result1 = arr[start];
                result2 = arr[end];
            }
            if(sum > 0)
                end--;
            else
                start++;
        }
        System.out.println(result1 + " " + result2);
    }
}
