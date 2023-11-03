package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int firstIndex = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<e ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }
        for(int i=0 ; i<=n ; i++) {
            Collections.sort(list[i]);
        }
        DFS(firstIndex);
        visited = new boolean[n+1];
        System.out.println();
        BFS(firstIndex);

    }
    static void DFS(int index) {

        visited[index] = true;
        System.out.print(index + " ");
        for(int i : list[index]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    static void BFS(int index) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + " ");

            for(int i : list[temp]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
