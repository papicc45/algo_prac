package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5535 {
    static int[][] dp;
    static int[] temp;
    static Clothes[] clothes;
    static int d, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        dp = new int[201][d];
        temp = new int[d];
        clothes = new Clothes[n];

        for(int i=0 ; i<d ; i++) {
            temp[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            clothes[i] = new Clothes(min ,max, score);
        }

        for(int i=0 ; i<201 ; i++) {
            Arrays.fill(dp[i] , -1);
        }

        int result = 0;
        for(int i=0 ; i<n ; i++) {
            if(temp[0] >= clothes[i].min && temp[0] <= clothes[i].max) {
                result = Math.max(result, recur(clothes[i].score, 1));
            }
        }

        System.out.println(result);
    }
    private static int recur(int s, int day) {
        if(day == d)
            return  0;

        if(dp[s][day] != -1)
            return dp[s][day];

        int ret = 0;
        for(int i=0 ; i<n ; i++) {
            if(temp[day] >= clothes[i].min && temp[day] <= clothes[i].max) {
                ret = Math.max(ret, recur(clothes[i].score, day + 1) + Math.abs(s - clothes[i].score));
            }
        }

        dp[s][day] = ret;
        return ret;
    }
    static class Clothes {
        int min;
        int max;
        int score;

        public Clothes(int min, int max, int score) {
            this.min = min;
            this.max = max;
            this.score = score;
        }
    }
}

