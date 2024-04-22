package graph.dijkstra;

import java.awt.geom.GeneralPath;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9370 {
    static ArrayList<CrossRoad>[] list;
    static int[] dist;
    static int n, m, t;
    static int s, g, h;
    static boolean[] visited;
    static ArrayList<Integer> goals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            for(int i=0 ; i<=n ; i++)
                list[i] = new ArrayList<>();

            for(int i=0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                if((start == h && end == g) || (start == g && end == h)) {
                    list[start].add(new CrossRoad(end, len * 2 - 1));
                    list[end].add(new CrossRoad(start, len * 2 - 1));
                } else {
                    list[start].add(new CrossRoad(end, len * 2));
                    list[end].add(new CrossRoad(start, len * 2));
                }
            }
            goals = new ArrayList<>();
            for(int i=0 ; i<t ; i++) {
                goals.add(Integer.parseInt(br.readLine()));
            }
            dijkstra();
            Collections.sort(goals);
            for(Integer i : goals) {
                if(dist[i] % 2 == 1 && dist[i] != 987654321)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    private static void dijkstra() {
        dist = new int[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, 987654321);
        dist[s] = 0;

        PriorityQueue<CrossRoad> queue = new PriorityQueue<>();
        queue.add(new CrossRoad(s, 0));
        while (!queue.isEmpty()) {
            CrossRoad temp = queue.poll();

            if(visited[temp.vertex])
                continue;

            visited[temp.vertex] = true;
            for(CrossRoad next : list[temp.vertex]) {
                if(!visited[next.vertex] && dist[next.vertex] > dist[temp.vertex] + next.len) {
                    dist[next.vertex] = dist[temp.vertex] + next.len;
                    queue.add(new CrossRoad(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
    static class CrossRoad implements Comparable<CrossRoad> {
        int vertex;
        int len;
        public CrossRoad(int vertex, int len) {
            this.vertex = vertex;
            this.len = len;
        }

        @Override
        public int compareTo(CrossRoad o) {
            return this.len - o.len;
        }
    }
}
