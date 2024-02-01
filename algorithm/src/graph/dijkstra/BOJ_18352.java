package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }
        Arrays.fill(result, Integer.MAX_VALUE);
        result[x] = 0;
        visited[x] = true;
        PriorityQueue<Dosi> queue = new PriorityQueue<>();
        queue.add(new Dosi(x, 0));
        while (!queue.isEmpty()) {
            Dosi temp = queue.poll();

            for(Integer next : list[temp.vertex]) {
                if(!visited[next]) {
                    result[next] = Math.min(result[next], result[temp.vertex] + 1);
                    visited[next] = true;
                    queue.add(new Dosi(next, result[next]));
                }
            }
        }
        boolean check = false;
        for(int i=1 ; i<=n ; i++) {
            if(result[i] == k) {
                check = true;
                System.out.println(i);
            }
        }

        if(!check)
            System.out.println(-1);
    }
    static class Dosi implements Comparable<Dosi> {
        int vertex;
        int value;

        public Dosi(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Dosi o) {
            return this.value - o.value;
        }
    }
}

