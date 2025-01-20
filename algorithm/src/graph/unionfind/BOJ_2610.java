package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2610 {
    static int[] arr;
    static int n, m;
    static ArrayList<Integer>[] nodes;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr =new int[n+1];
        for(int i=1 ; i<=n ; i++)
            arr[i] = i;

        nodes = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            nodes[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
            if(find(a) != find(b)) {
                union(a, b);
            }
        }

        int[] dArr = new int[n+1];
        result = new int[n+1];
        Arrays.fill(dArr, Integer.MAX_VALUE);
        for(int i=1 ; i<=n ; i++) {
            int depth = bfs(i);
            int root = find(i);
            if(depth < dArr[root]) {
                result[root] = i;
                dArr[root] = depth;
            }
        }

        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            if(result[i] != 0) {
                cnt++;
                answer.add(result[i]);
            }
        }
        System.out.println(cnt);
        Collections.sort(answer);
        for(int i : answer)
            System.out.println(i);

    }
    private static int bfs( int idx) {
        boolean[] visited = new boolean[n+1];
        visited[idx] = true;
        Queue<int[]> queue = new LinkedList<>();
        int max = 0;
        queue.add(new int[] {idx, 0});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tdx = temp[0];
            int depth = temp[1];

            max = Math.max(max, depth);

            for(int next : nodes[tdx]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, depth + 1});
                }
            }
        }
        return max;
    }
    private static int find(int a) {
        if(a == arr[a]) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            arr[b] = a;
    }
}
