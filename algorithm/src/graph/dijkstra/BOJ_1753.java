package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int startIndex = Integer.parseInt(br.readLine());

        ArrayList<Node>[] list = new ArrayList[v+1];
        boolean[] visited = new boolean[v+1];
        int[] answer = new int[v+1];
        for(int i=0 ; i<=v ; i++) {
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
        }

        answer[startIndex] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startIndex, 0));
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            int tempVertext = temp.vertex;
            if(visited[tempVertext])
                continue;

                visited[tempVertext] = true;
                for(Node next : list[tempVertext]) {
                    int nextVertex = next.vertex;
                    int weight = next.weight;

                    if(answer[nextVertex] > answer[tempVertext] + weight) {
                        answer[nextVertex] = answer[tempVertext] + weight;
                        queue.add(new Node(nextVertex, answer[nextVertex]));
                    }
                }
        }

        for(int i=1 ; i<=v ; i++) {
            if(!visited[i])
                System.out.println("INF");
            else
                System.out.println(answer[i]);
        }
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
