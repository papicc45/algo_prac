package graph.dijkstra;

import javax.sql.rowset.FilteredRowSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Storage>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Storage(e, v));
            list[e].add(new Storage(s, v));
        }

        for(Storage storage : list[3]) {
            System.out.println(storage.vertex);
        }
        System.out.println("--------------------");

        int[][] minRoute = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            int[] dist = new int[n+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            for(Storage storage : list[i]) {
                int first = storage.vertex;

                boolean[] visited = new boolean[n+1];
                visited[i] = true;
                if(dist[first] > storage.value) {
                    dist[first] = storage.value;
                    minRoute[i][first] = first;
                }

                PriorityQueue<Storage> queue = new PriorityQueue<>();
                queue.add(new Storage(first, 0));

                while (!queue.isEmpty()) {
                    Storage temp = queue.poll();

                    if(visited[temp.vertex])
                        continue;

                    visited[temp.vertex] = true;
                    for(Storage next : list[temp.vertex]) {

                        if(dist[next.vertex] > dist[temp.vertex] + next.value) {
                            dist[next.vertex] = dist[temp.vertex] + next.value;
                            minRoute[i][next.vertex] = first;
                            queue.add(new Storage(next.vertex, dist[next.vertex]));
                        }
                    }
                }
            }
        }
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                if(i == j)
                    System.out.print("- ");
                else
                    System.out.print(minRoute[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Storage implements Comparable<Storage> {
    int vertex;
    int value;

    public Storage(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Storage o) {
        return  this.value - o.value;
    }
}
