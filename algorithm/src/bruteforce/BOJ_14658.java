package bruteforce;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14658 {
    static int n, m, l, k;
    static int tram = 0;
    static ArrayList<Point> stars = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            stars.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for(int i=0 ; i<stars.size() ; i++) {
            Point p1 = stars.get(i);
            for(int j=0 ; j<stars.size() ; j++) {
                Point p2 = stars.get(j);

                int cnt = 0;
                for(Point point : stars) {
                    if(p1.x <= point.x && p1.x+l >= point.x
                    && p2.y <= point.y && p2.y+l >= point.y) {
                        cnt++;
                    }
                }
                tram = Math.max(tram, cnt);
            }
        }
        System.out.println(k - tram);
    }
}
