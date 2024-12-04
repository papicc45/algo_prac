package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_25195 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
        }

        int s = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<s ; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(bfs() ? "Yes" : "yes");
    }
    private static boolean bfs() {
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            if(set.contains(temp)) {
                return false;
            }

            for(int next : list[temp]) {
                if(!visited[next] && !set.contains(next)) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
