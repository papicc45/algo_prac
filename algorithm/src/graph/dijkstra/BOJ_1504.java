package graph.dijkstra;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {

    static ArrayList<Node2>[] list;
    static boolean[] visited;
    static int INF = 200000 * 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[start].add(new Node2(end, len));
            list[end].add(new Node2(start, len));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0;
        int result2 = 0;
        result1 += dijkstra(1, v1, n);
        result1 += dijkstra(v1, v2, n);
        result1 += dijkstra(v2, n, n);

        result2 += dijkstra(1, v2, n);
        result2 += dijkstra(v2, v1, n);
        result2 += dijkstra(v1, n, n);

        System.out.println((result1 >= INF && result1 >= INF) ? -1 : Math.min(result1, result2));

    }

    private static int dijkstra(int startIndex, int endIndex, int n) {
        int[] answer = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(answer, INF);
        answer[startIndex] = 0;
        PriorityQueue<Node2> queue = new PriorityQueue<>();
        queue.add(new Node2(startIndex, 0));
        while (!queue.isEmpty()) {
            Node2 temp = queue.poll();
            int tempVertex = temp.vertex;
            if(visited[tempVertex])
                continue;

            visited[tempVertex] = true;

            for(Node2 next : list[temp.vertex]) {
                int nextVertex = next.vertex;
                int value = next.value;
                if(!visited[nextVertex]) {
                    answer[nextVertex] = Math.min(answer[nextVertex], answer[tempVertex] + next.value);
                    queue.add(new Node2(nextVertex, answer[nextVertex]));
                }
            }
        }

        return answer[endIndex];
    }
}

class Node2 implements Comparable<Node2> {
    int vertex;
    int value;

    public Node2(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.value - o.value;
    }
}





