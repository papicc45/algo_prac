package graph.dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] friends = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<3 ; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        ArrayList<House>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[start].add(new House(end, value));
            list[end].add(new House(start, value));
        }

        ArrayList<Integer>[] results = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            results[i] = new ArrayList<>();
        }

        for(int i=0 ; i<3 ; i++) {
            int index = friends[i];
            int[] dist = new int[n+1];
            boolean[] visited = new boolean[n+1];

            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[index] = 0;
            PriorityQueue<House> queue = new PriorityQueue<>();
            queue.add(new House(index, 0));

            while (!queue.isEmpty()) {
                House temp = queue.poll();

                if(visited[temp.vertex])
                    continue;

                visited[temp.vertex] = true;

                for(House next : list[temp.vertex]) {
                    dist[next.vertex] = Math.min(dist[next.vertex], dist[temp.vertex] + next.value);
                    queue.add(new House(next.vertex, dist[next.vertex]));
                }
            }
            for(int j=1 ; j<=n ; j++) {
                if(index != j && dist[j] != Integer.MAX_VALUE) {
                    results[j].add(dist[j]);
                }
            }
        }
        for(int i=1 ; i<=n ; i++) {
            Collections.sort(results[i]);
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++) {
            if(friends[0] == i || friends[1] == i || friends[2] == i)
                continue;
            if(max < results[i].get(0)) {
                max = results[i].get(0);
                answer = i;
            }

        }
        System.out.println(answer);
    }
}
class House implements Comparable<House> {
    int vertex;
    int value;

    public House(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(House o) {
        return this.value - o.value;
    }
}
