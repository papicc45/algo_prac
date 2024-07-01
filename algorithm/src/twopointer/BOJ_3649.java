package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {

            int x = Integer.parseInt(str) * 10000000;
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            for(int i=0 ; i<n ; i++)
                arr[i] = Integer.parseInt(br.readLine());

            Arrays.sort(arr);

            int max = Integer.MIN_VALUE;
            int s = 0, e = n-1;
            int result1 = 0, result2 = 0;

            while (s < e) {
                int sum = arr[s] + arr[e];
                int abs = Math.abs(arr[s] - arr[e]);

                if(sum == x) {
                    if(max < abs) {
                        result1 = arr[s];
                        result2 = arr[e];

                        max = abs;
                    }
                    s++;
                } else if(sum < x) {
                    s++;
                } else {
                    e--;
                }
            }
            if(max != Integer.MIN_VALUE) {
                System.out.println("yes " + result1 + " " + result2);
            } else {
                System.out.println("danger");
            }
        }
    }
}
