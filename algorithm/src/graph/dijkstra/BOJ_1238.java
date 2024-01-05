package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

public class BOJ_1238 {

    static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] list = new ArrayList[n+1];
        ArrayList<Edge>[] reverseList = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
            reverseList[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[start].add(new Edge(end, value));
            reverseList[end].add(new Edge(start, value));
        }

        int[] result = dijkstra(list);
        int[] reverseResult = dijkstra(reverseList);

        int answer = 0;
        for(int i=1 ; i<result.length ; i++) {
            answer = Math.max(answer, result[i] + reverseResult[i]);
        }
        System.out.println(answer);
    }
    private static int[] dijkstra(ArrayList<Edge>[] list) {
        int[] result = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[x] = 0;
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(x, 0));
        while (!queue.isEmpty()) {
            Edge temp = queue.poll();
            int tempVertext = temp.vertex;

            if(visited[tempVertext])
                continue;

            visited[tempVertext] = true;

            for(Edge next : list[tempVertext]) {
                int nextVertext = next.vertex;
                int value = next.value;

                result[nextVertext] = Math.min(result[nextVertext], result[tempVertext] + value);
                queue.add(new Edge(nextVertext, result[nextVertext]));
            }
        }
        return result;
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int value;

    public Edge(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
