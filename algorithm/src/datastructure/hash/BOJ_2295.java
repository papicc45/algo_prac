package datastructure.hash;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_2295 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=i ; j<n ; j++) {
                set.add(arr[i] + arr[j]);
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(set.contains(arr[i] - arr[j])) {
                    result = Math.max(result, arr[i]);
                }
            }
        }

        System.out.println(result);
    }
}
