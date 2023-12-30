package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = Math.max(a, b);
            int min = Math.min(a,  b);
            int mul = a * b;
            while(true) {
                int mod = max % min;

                if(mod == 0)
                    break;

                max = min;
                min = mod;
            }

            System.out.println(mul / min);
        }
    }
}
