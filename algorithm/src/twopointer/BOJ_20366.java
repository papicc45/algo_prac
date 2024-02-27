package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                int sm1 = arr[i] + arr[j];

                int start = 0, end = n-1;
                while (start < end) {
                    if(start == i || start == j) {
                        start++;
                        continue;
                    }
                    if(end == i || end == j) {
                        end--;
                        continue;
                    }

                    int sm2 = arr[start] + arr[end];
                    result = Math.min(result, Math.abs(sm1 - sm2));
                    if(sm1 < sm2) {
                        end--;
                    } else if(sm1 > sm2) {
                        start++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
