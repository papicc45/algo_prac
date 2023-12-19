package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long result = 0;
        int temp = 1;
        while(true) {
            if(n <= k)
                break;
            int mod = n % 2;
            n = n / 2;
            if(mod == 1) {
                result += temp;
                n = n + 1;
            }
            temp = temp * 2;
        }

        System.out.println(result);
    }
}
