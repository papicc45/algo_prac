package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] list = new Integer[n];
        for(int i=0 ; i<n ; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(list, Collections.reverseOrder());

        int result = -1;
        for(int i=0 ; i<=n-3 ; i++) {
            int side1 = list[i];
            int side2 = list[i+1];
            int side3 = list[i+2];

            if(check(side1, side2, side3) && check(side1, side3, side2) && check(side2, side3, side1)) {
                result = side1 + side2 + side3;
                break;
            }
        }
        System.out.println(result);
    }
    public static boolean check(int a, int b, int c) {
        int sum = a + b;
        if(sum <= c) {
            return false;
        }
        return true;
    }
}
