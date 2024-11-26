package greedy;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BOJ_2872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int t = n;
        int result = 0;
        for(int i=n-1 ; i>=0 ; i--) {
            if(t == arr[i]) {
                t--;
            } else {
                result++;
            }
        }
        System.out.println(result);
    }
}
