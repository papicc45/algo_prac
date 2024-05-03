package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Brick[] bricks = new Brick[n+1];
        int[] dp = new int[n+1];
        bricks[0] = new Brick(0, 0, 0, 0);
        for(int i=1 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            bricks[i] = new Brick(i, width, height, weight);
        }
        Arrays.sort(bricks, (o1, o2) -> o1.width - o2.width);
        int max = 0;
        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<i ; j++) {
                if(bricks[i].weight > bricks[j].weight) {
                    dp[i] = Math.max(dp[i], dp[j] + bricks[i].height);
                }
            }
            max = Math.max(dp[i], max);
        }
        ArrayList<Integer> answerList = new ArrayList<>();
        while (n > 0) {
            if(max == dp[n]) {
                answerList.add(bricks[n].num);
                max -= bricks[n].height;
            }
            n--;
        }

        System.out.println(answerList.size());
        for(int i=answerList.size()-1 ; i>=0 ; i--) {
            System.out.println(answerList.get(i));
        }

    }
    static class Brick  {
        int num;
        int width;
        int height;
        int weight;

        public Brick(int num, int width, int height, int weight) {
            this.num = num;
            this.width = width;
            this.height = height;
            this.weight = weight;
        }


    }
}
