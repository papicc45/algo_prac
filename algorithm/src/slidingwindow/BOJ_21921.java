package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;
        for(int i=0 ; i<x ; i++) {
            sum += arr[i];
        }
        result = Math.max(result ,sum);
        count++;
        for(int i=1 ; i<n ; i++) {
            sum -= arr[i-1];

            int next = i+x-1;
            if(next >= n)
                break;

            sum += arr[next];
            if(result < sum) {
                count = 1;
                result = sum;
            } else if(result == sum) {
                count++;
            }
        }

        if(result == 0)
            System.out.println("SAD");
        else {
            System.out.println(result);
            System.out.println(count);
        }
    }
}
