package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_9663 {
    static int n;
    static int result = 0;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        recur(0);
        System.out.println(result);
    }

    private static void recur(int count) {
        if(count == n) {
            result++;
            return;
        }

        for(int i=0  ; i<n ; i++) {
            arr[count] = i;

            if(check(count)) {
                recur(count+1);
            }
        }
    }
    private static boolean check(int col) {
        for(int i=0 ; i<col ; i++) {
            if(arr[col] == arr[i])
                return false;

            if(Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
                return false;
        }
        return true;

    }
}
