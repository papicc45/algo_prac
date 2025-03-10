package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_26218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        double[][] add = new double[b+1][n];
        double[] dp = new double[b+1];
        Work[] works = new Work[n];

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            double p = Integer.parseInt(st.nextToken()) * 0.01;
            double a = Integer.parseInt(st.nextToken()) * 0.01;
            int c = Integer.parseInt(st.nextToken());

            works[i] = new Work(p, a, c);
        }

        for(Work w : works) {
            System.out.println(w.p);
        }

        for(int i=0 ; i<n ; i++) {
            add[0][i] = works[i].p;
            if(dp[0] == 0.0) {
                dp[0] += add[0][i];
            } else {
                dp[0] *= add[0][i];
            }
        }

        for(int i=1 ; i<=b ; i++) {
            for(int j=0 ; j<n ; j++) {
                add[i][j] = add[i-1][j];
//                double d1 = i - works[j].c;
                if(i - works[j].c < 0) continue;
                double d2 = add[i-works[j].c][j] + works[j].a;
                double d3 = dp[i-works[j].c] / add[i-works[j].c][j];

                if(dp[i] < (add[i-works[j].c][j] + works[j].a) * (dp[i-works[j].c] / add[i-works[j].c][j])) {
                    dp[i] = (add[i-works[j].c][j] + works[j].a) * (dp[i-works[j].c] / add[i-works[j].c][j]);
                    add[i][j] += works[j].a;
                }
            }
        }

        System.out.println((int)Math.pow(dp[b], 2 * n));
    }
    static class Work {
        double p;
        double a;
        int c;

        public Work(double p, double a, int c) {
            this.p = p;
            this.a = a;
            this.c = c;
        }
    }
}
