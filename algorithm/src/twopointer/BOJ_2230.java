package twopointer;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2230 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = sc.nextInt();

        int s = 0, e = 0;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(arr);
        while (e < n && s < n) {
            int d = arr[e] - arr[s];
            if(d >= m) {
                diff = Math.min(diff, d);
                s++;
            } else {
                e++;
            }
        }
        System.out.println(diff);
    }
}
