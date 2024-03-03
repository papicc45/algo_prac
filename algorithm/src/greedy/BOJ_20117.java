package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        if(n % 2 == 1) {
            for(int i=n-1 ; i>n/2 ; i--) {
                result += arr[i] * 2;
            }
            result += arr[n/2];
        } else {
            for(int i=n-1 ; i>=n/2 ; i--) {
                result += arr[i] * 2;
            }
        }
        System.out.println(result);
    }
}
