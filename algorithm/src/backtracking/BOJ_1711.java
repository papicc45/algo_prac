package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1711 {
    static int n;
    static long[][] coordinates;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        coordinates = new long[n][2];

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=i+1 ; j<n ; j++) {
                for(int k=j+1 ; k<n ; k++) {
                    long x1 = coordinates[i][0];
                    long y1 = coordinates[i][1];
                    long x2 = coordinates[j][0];
                    long y2 = coordinates[j][1];
                    long x3 = coordinates[k][0];
                    long y3 = coordinates[k][1];
                    long dist1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    long dist2 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3);
                    long dist3 = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);

                    if(dist1 + dist2 == dist3 || dist2 + dist3 == dist1 || dist1 + dist3 == dist2)
                        result++;
                }
            }
        }
        System.out.println(result);

    }
}
