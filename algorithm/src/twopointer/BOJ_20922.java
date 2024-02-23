package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] counts = new int[100001];
        int start = 0;
        int end = 0;
        int len = Integer.MIN_VALUE;
        while (end < arr.length) {
            while (end < arr.length && counts[arr[end]] + 1 <= k) {
                counts[arr[end++]]++;
            }
            len = Math.max(len, end - start);
            counts[arr[start++]]--;
        }
        System.out.println(len);
    }
}
