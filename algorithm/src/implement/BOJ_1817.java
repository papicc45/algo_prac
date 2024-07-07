package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            int temp = arr[i];

            if(sum + temp > m) {
                result++;
                sum = temp;
            } else if(sum + temp == m){
                result++;
                sum = 0;
            } else {
                sum += temp;
            }
        }
        if(sum != 0)
            result++;

        System.out.println(result);
    }
}
