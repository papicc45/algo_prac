package search.dfs;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
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

            list[start].add(end);
            list[end].add(start);
        }
        for(int i=1 ; i<=n ; i++) {
            if(!visited[i]) {
                result++;
                DFS(i);
            }
        }
        System.out.println(result);
    }
    public static void DFS(int index) {
        if(visited[index]) {
            return;
        }

        visited[index] = true;
        for(int i : list[index]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
