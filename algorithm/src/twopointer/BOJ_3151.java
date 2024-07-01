package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3151 {
    public static void main(String[] args) throws IOException {
        /*
            -6 -5 -4 -4
             0 1 2 2 3 7
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            int s = 0, e= n-1;
            while (s < e) {
                if(i == s) {
                    i++;
                    continue;
                }
                if(i == e) {
                    e--;
                    continue;
                }
                int sum = arr[i] + arr[s] + arr[e];
                if(sum == 0) {
                    if(i != s && i != e) {
                        result++;
                        System.out.println(arr[i] + " " + arr[s] + " " + arr[e]);
//                        System.out.println(i + " " + s + " " + e);
                    }
                    s++;
                } else if(sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(result / 3);
    }
}
