package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Dosi>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] answer = new int[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
            answer[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st;
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[start].add(new Dosi(end, value));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        answer[start] = 0;
        PriorityQueue<Dosi> queue = new PriorityQueue<>();
        queue.add(new Dosi(start, 0));
        while (!queue.isEmpty()) {
            Dosi temp = queue.poll();
            int tempEdge = temp.edge;

            if(visited[tempEdge])
                continue;

            visited[tempEdge] = true;

            for(Dosi next : list[tempEdge]) {
                int nextEdge = next.edge;
                int value = next.value;

                answer[nextEdge] = Math.min(answer[nextEdge], answer[tempEdge] + value);
                queue.add(new Dosi(nextEdge, answer[nextEdge]));
            }
        }

        System.out.println(answer[end]);
    }
}

class Dosi implements Comparable<Dosi> {
    int edge;
    int value;

    public Dosi(int edge, int value) {
        this.edge = edge;
        this.value = value;
    }

    @Override
    public int compareTo(Dosi o) {
        return this.value - o.value;
    }
}
