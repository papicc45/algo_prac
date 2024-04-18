package graph.dijkstra;

import java.beans.beancontext.BeanContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.zip.Adler32;

public class BOJ_11779 {
    static ArrayList<Dosi>[] list;
    static int goal;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();
        StringTokenizer st;
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            list[start].add(new Dosi(end, length, new ArrayList<>()));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, 987654321);
        dijkstra(start);
    }
    private static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<Dosi> queue = new PriorityQueue<>();
        ArrayList<Integer> startList = new ArrayList<>();
        startList.add(start);
        queue.add(new Dosi(start, 0, startList));

        while (!queue.isEmpty()) {
            Dosi temp = queue.poll();

            if(temp.vertex == goal) {
                System.out.println(dist[temp.vertex]);
                System.out.println(temp.route.size());
                for(Integer i : temp.route) {
                    System.out.print(i + " ");
                }
                return;
            }

            if(visited[temp.vertex])
                continue;

            visited[temp.vertex] = true;

            for(Dosi next : list[temp.vertex]) {
                if(!visited[next.vertex]) {
                    if(dist[next.vertex] > dist[temp.vertex] + next.length) {
                        dist[next.vertex] = dist[temp.vertex] + next.length;
                        ArrayList<Integer> newList = new ArrayList<>(temp.route);
                        newList.add(next.vertex);
                        queue.add(new Dosi(next.vertex, dist[next.vertex], newList));
                    }
                }
            }
        }
    }

    static class Dosi implements Comparable<Dosi> {
        int vertex;
        int length;
        ArrayList<Integer> route;

        public Dosi(int vertex, int length, ArrayList<Integer> route) {
            this.vertex = vertex;
            this.length = length;
            this.route = route;
        }

        @Override
        public int compareTo(Dosi o) {
            return this.length - o.length;
        }
    }
}
