package graph;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1325 {
    static ArrayList<Integer>[] list;
    static int[] count;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        count = new int[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
        }

        for(int i=1 ; i<=n ; i++) {
            visited = new boolean[n+1];
            BFS(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1 ; i<=n ; i++) {
            max = Math.max(max, count[i]);
        }

        for(int i=1 ; i<=n ; i++) {
            if(count[i] == max) {
                System.out.print(i + " ");
            }
        }

    }
    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(Integer i : list[temp]) {
                if(!visited[i]) {
                    visited[i] = true;
                    count[i]++;
                    queue.add(i);
                }
            }
        }

    }
}
