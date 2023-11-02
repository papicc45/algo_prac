package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
    static ArrayList<Integer>[] list;
    static int n, m;
    static boolean visited[];
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0 ; i<n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                DFS(i, 1);
            }
        }
        if(check) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static void DFS(int index, int depth) {
        if(depth == 5) {
            check = true;
            return;
        }

        visited[index] = true;
        for(int i : list[index]) {
            if(check) {
                return;
            }
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[index] = false;
    }
}
