package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            arr[i]  = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }

        int answer = Integer.MIN_VALUE;

        for(int i=k ; i<=n ; i++) {
            answer = Math.max(answer, arr[i] - arr[i-k]);
        }

        System.out.println(answer);
    }
}
