package graph.dijkstra;

import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17396 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Point>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        boolean[] possible = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(st.nextToken()) == 0)
                possible[i] = true;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, length));
            list[end].add(new Point(start, length));
        }
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        boolean[] visited = new boolean[n];

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point temp = queue.poll();

            if(visited[temp.end])
                continue;

            visited[temp.end] = true;

            for (Point next : list[temp.end]) {
                if(next.end != n-1 && !possible[next.end]) continue;
                if(dist[next.end] > dist[temp.end] + next.length) {
                    dist[next.end] = dist[temp.end] + next.length;
                    queue.add(new Point(next.end, dist[next.end]));
                }
            }
        }
        if(dist[n-1] == Long.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(dist[n-1]);
        }
    }
        static class Point implements Comparable<Point> {
        int end;
        long length;

        public Point(int end, long length) {
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Point o) {
            return (int)(this.length - o.length);
        }
    }
}
