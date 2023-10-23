package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 1;
        int start = 1, end = 1;
        int sum = 1;
        while(end != n) {
            if(sum < n) {
                end++;
                sum += end;
            } else if(sum == n) {
                result++;
                sum -= start;
                start++;
            } else {
                sum -= start;
                start++;
            }
        }
        System.out.println(result);
    }
}
