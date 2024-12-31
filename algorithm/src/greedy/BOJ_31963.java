package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_31963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=1 ; i<n-1 ; i++) {
            if(arr[i] < arr[i-1]) {
                while (arr[i] < arr[i-1]) {
                    arr[i] *= 2;
                    result++;
                }
            }
        }
        if(arr[n-1] < arr[n-2]) {
            while (arr[n-1] < arr[n-2]) {
                arr[n-1] *= 2;
                result++;
            }
        }
        System.out.println(result);
    }
}
