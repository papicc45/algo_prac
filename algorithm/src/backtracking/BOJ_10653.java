package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Node[] points = new Node[N];
        int dp[][] = new int[K+1][N];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            points[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<=K; i++)
        {
            Arrays.fill(dp[i],-1);
            if(i==0)dp[i][0]=0;
        }

        int min, temp;
        for(int i=1; i<N; i++){
            for(int j=0; j<=K; j++)
            {
                if(i-j>0){
                    min = Integer.MAX_VALUE;
                    for(int k=0;k<=j;k++)
                    {
                        temp = dp[j-k][i-k-1];
                        if(temp==-1) continue;
                        int distance = Math.abs(points[i-k-1].x-points[i].x) + Math.abs(points[i-k-1].y-points[i].y);
                        min = Math.min(min, temp+distance);
                    }
                    dp[j][i] = min;
                }
            }
        }
        int result = dp[0][N-1];
        for(int i=1; i<=K; i++)
        {
            result = Math.min(result,dp[i][N-1]);
        }
        System.out.println(result);
    }
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
