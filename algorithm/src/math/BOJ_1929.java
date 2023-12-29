package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[n+1];

        for(int i=2 ; i<= Math.sqrt(n) ; i++) {
            if(prime[i])
                continue;

                for(int j=i+i ; j<=n ; j += i) {
                    prime[j] = true;
                }
        }

        for(int i=m ; i<=n ; i++) {
            if(!prime[i])
                System.out.println(i);
        }

    }
}
