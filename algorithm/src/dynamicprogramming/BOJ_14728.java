package dynamicprogramming;

import java.awt.image.ImagingOpException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] dp = new int[t+1];

        Score[] scores = new Score[n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            scores[i] = new Score(time ,val);
        }

        for(Score score : scores) {
            for(int i=t ; i>0 ; i--) {
                if(i - score.time >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - score.time] + score.val);
                }
            }
        }
        System.out.println(dp[t]);
    }
    static class Score {
        int time;
        int val;

        public Score(int time, int val) {
            this.time = time;
            this.val = val;
        }
    }
}
