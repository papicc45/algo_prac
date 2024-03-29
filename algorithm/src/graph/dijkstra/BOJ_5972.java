package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Cow>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long value = Integer.parseInt(st.nextToken());
            list[start].add(new Cow(end, value));
            list[end].add(new Cow(start, value));
        }

        long[] dist = new long[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Cow> queue = new PriorityQueue<>();
        queue.add(new Cow(1, 0));
        while (!queue.isEmpty()) {
            Cow temp = queue.poll();

            if(visited[temp.vertex]) continue;

            visited[temp.vertex] = true;

            for(Cow next : list[temp.vertex]) {
                if(!visited[next.vertex]) {
                    if(dist[next.vertex] > dist[temp.vertex] + next.value) {
                        dist[next.vertex] = dist[temp.vertex] + next.value;
                        queue.add(new Cow(next.vertex, dist[next.vertex]));
                    }
                }
            }
        }

        System.out.println(dist[n]);
    }
    static class Cow implements Comparable<Cow> {
        int vertex;
        long value;

        public Cow(int vertex, long value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Cow o) { return (int)(this.value - o.value); }
    }
}
