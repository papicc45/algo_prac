package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().toCharArray();

        int result = 1;
        if (arr[0] == 'B') {
            for(int i=1 ; i<n ; i++) {
                if(arr[i] == 'R') {
                    if(arr[i-1] == 'B') {
                        result++;
                    }
                }
            }
        } else {
            for(int i=1 ; i<n ; i++) {
                if(arr[i] == 'B') {
                    if(arr[i-1] == 'R') {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
