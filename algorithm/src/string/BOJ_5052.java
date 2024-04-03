package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];

            for(int i=0 ; i<n ; i++) {
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);

            boolean check = true;
            for(int i=0 ; i<n-1 ; i++) {
                if(arr[i+1].startsWith(arr[i])) {
                    check = false;
                    break;
                }
            }

            System.out.println(check ? "YES" : "NO");
        }
    }
}
