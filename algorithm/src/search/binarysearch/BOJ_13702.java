package search.binarysearch;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_13702 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        long left = 1;
        long right = 0;
        for(int i=0 ; i<n ; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(right, arr[i]);
        }

        long result = 0;
        while (left < right) {
            long mid = (left + right) / 2;

            int count = 0;
            for(int i=0 ; i<n ; i++) {
                count += arr[i] / mid;
            }

            if(count >= k) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
        /*

         */
    }
}
