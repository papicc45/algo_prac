package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {
    static int[] arr;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
        }
        visited = new boolean[n+1];
        BFS(x);

        boolean check = false;
        for(int i=1 ; i<arr.length ; i++) {
            if(arr[i] == k) {
                check = true;
                System.out.println(i);
            }
        }

        if(!check)
            System.out.println(-1);

    }
    private static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            for(Integer next : list[temp]) {
                if(!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    arr[next] = arr[temp] + 1;
                }
            }
        }
    }
}
