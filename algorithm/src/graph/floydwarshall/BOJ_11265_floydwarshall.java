package graph.floydwarshall;

import java.awt.geom.RectangularShape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11265_floydwarshall {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] parties = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    parties[i][j] = Math.min(parties[i][j], parties[i][k] + parties[k][j]);
                }
            }
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if(parties[start][end] <= time)
                System.out.println("Enjoy other party");
            else
                System.out.println("Stay here");
        }
    }
}
