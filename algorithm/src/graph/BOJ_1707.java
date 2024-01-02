package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean isCycled;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int k=0 ; k<t ; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v+1];
            isCycled = false;
            check = new boolean[v+1];
            visited = new boolean[v+1];
            for(int i=0 ; i<=v ; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i=0 ; i<e ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list[start].add(end);
                list[end].add(start);
            }

            for(int i=1 ; i<=v ; i++) {
                if(isCycled) {
                    break;
                } else {
                    DFS(i);
                }
            }

            if(isCycled)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
    private static void DFS(int index) {
        visited[index] = true;
        for(Integer next : list[index]) {
            if(!visited[next]) {
                check[next] = !check[index];
                DFS(next);
            } else if(check[next] == check[index]) {
                isCycled = true;
            }
        }
    }
}
