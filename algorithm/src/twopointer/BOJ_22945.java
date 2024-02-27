package twopointer;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = n-1;
        int result = Integer.MIN_VALUE;
        while (start < end) {
            int min = Math.min(arr[start], arr[end]);
            int stats = min * (end - start - 1);

            result = Math.max(result, stats);
            if(min == arr[start]) {
                start++;
            } else {
                end--;
            }
        }
        System.out.println(result);
    }
}
