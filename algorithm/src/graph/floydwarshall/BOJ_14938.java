package graph.floydwarshall;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

public class BOJ_14938 {
    static int INF = 3001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //n = 지역 갯수, m = 수색 범위, r = 길의 개수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] items = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(i == j)
                    continue;

                map[i][j] = INF;
            }
        }

        for(int i=0 ; i<r ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            map[start][end] = len;
            map[end][start] = len;
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int result = 0;
        for(int i=1 ; i<=n ; i++) {
            int sum = items[i];
            for(int j=1 ; j<=n ; j++) {
                if(i == j || map[i][j] > m)
                    continue;

                sum += items[j];
            }
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}
