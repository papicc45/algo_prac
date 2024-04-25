package dynamicprogramming;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_3687 {
    public static void main(String[] args) {
        long[] minDP = new long[101];
        Arrays.fill(minDP, Long.MAX_VALUE);
        minDP[2] = 1;
        minDP[3] = 7;
        minDP[4] = 4;
        minDP[5] = 2;
        minDP[6] = 6;
        minDP[7] = 8;
        minDP[8] = 10;
        String[] arr = {"1", "7", "4", "2", "0", "8"};
        for(int i=9 ; i<=100 ; i++) {
            for(int j=2 ; j<=7 ; j++) {
                String str = minDP[i-j] + arr[j-2];
                minDP[i] = Math.min(minDP[i], Long.parseLong(str));
            }
        }

        arr = new String[]{"0", "0", "1", "7", "4", "2", "6", "8"};
        String[] maxDP = new String[101];
        maxDP[2] = "1";
        for(int i=3 ; i<=100 ; i++) {
            StringBuilder sb = new StringBuilder();
            if(i%2 == 1) {
                int index = i / 2 - 1;
                for(int j=0 ; j<index ; j++) {
                    sb.append("1");
                }
                sb.insert(0, arr[i-index*2]);
            } else {
                for(int j=0 ; j<i/2 ; j++) {
                    sb.append("1");
                }
            }
            maxDP[i] = sb.toString();
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(minDP[n] + " " + maxDP[n]);
        }
    }
}
