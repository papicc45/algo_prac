package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        boolean check = false;
        int result = Integer.MAX_VALUE;

        int cnt = 0;
        for(int i=0 ; i<n ; i++) {
            if(check && arr[i] == 'B') {
                cnt++;
            } else if(arr[i] == 'R') {
                check = true;
            }
        }
        result = Math.min(result, cnt);

        cnt = 0;
        check = false;
        for(int i=0 ; i<n ; i++) {
            if(check && arr[i] == 'R') {
                cnt++;
            } else if(arr[i] == 'B') {
                check = true;
            }
        }
        result = Math.min(result, cnt);

        cnt = 0;
        check = false;
        for(int i=n-1 ; i>=0 ; i--) {
            if(check && arr[i] == 'R') {
                cnt++;
            } else if(arr[i] == 'B') {
                check = true;
            }
        }
        result = Math.min(result, cnt);

        cnt = 0;
        check = false;
        for(int i=n-1 ; i>=0 ; i--) {
            if(check && arr[i] == 'B') {
                cnt++;
            } else if(arr[i] == 'R') {
                check = true;
            }
        }
        result = Math.min(result, cnt);
        System.out.println(result);
    }
}
