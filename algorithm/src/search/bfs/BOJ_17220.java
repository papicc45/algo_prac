package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17220 {
    static ArrayList<Integer>[] list;
    static int n, m;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        boolean[] check = new boolean[n+1];
        for(int i=0 ; i<m ; i++) {

            st = new StringTokenizer(br.readLine());
            int s = st.nextToken().charAt(0) - 'A' + 1;
            int e = st.nextToken().charAt(0) - 'A' + 1;
            check[e] = true;
            list[s].add(e);
        }

        List<Integer> start = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            if(!check[i]) {
                start.add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for(int i=0 ; i<q ; i++) {
            set.add(st.nextToken().charAt(0) - 'A'  + 1);
        }

        System.out.println(bfs(start));
    }
    private static int bfs(List<Integer> start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        for(int i : start) {
            if(set.contains(i)) continue;
            queue.add(i);
            visited[i] = true;
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(int next : list[temp]) {
                if(visited[next]) continue;
                if(set.contains(next)) continue;

                cnt++;
                queue.add(next);
            }
        }

        return cnt;
    }
}
