package greedy;

import jdk.jfr.ContentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines[i] = new Line(x,y);
        }

        Arrays.sort(lines);
        int before = -1_000_000_000;
        long result = 0;
        for(int i=0 ; i<n ; i++) {
            Line line = lines[i];
            if(before == line.y)
                continue;

            if(before > line.x) {
                if(before < line.y) {
                    result += (line.y - before);
                }
            } else if(before <= line.x) {
                result += (line.y - line.x);
            }
            before = Math.max(before, line.y);
        }

        System.out.println(result);
    }
    static class Line implements Comparable<Line> {
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            if(this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}
