package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_16678 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        long result = 0;
        for(int i=1 ; i<=n ; i++) {
            if(arr[i-1] + 1 < arr[i]) {
                int diff = arr[i] - arr[i-1] - 1;
                result += diff;
                arr[i] = arr[i-1] + 1;
            }
        }

        System.out.println(result);
    }
}
