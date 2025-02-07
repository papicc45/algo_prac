package twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();


        int left = 0, right = 0;
        int result = 0;
        int wc = 0, bc = 0;
        int len = 0;

        while (right < n) {
            if(bc <= b) {
                if(arr[right] == 'W') wc++;
                else bc++;

                len++;
                right++;
            } else {
                if(arr[left] == 'W') wc--;
                else bc--;

                len--;
                left++;
            }
            if(wc >= w && bc <= b)
                result = Math.max(result, len);
        }
        System.out.println(result);
    }
}
