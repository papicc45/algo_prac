package graph.bellmanford;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1738 {
    static Pair[] edge;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        edge = new Pair[m];

        int[] len = new int[n+1];
        for(int i=1; i<=n; i++) {
            len[i] = Integer.MIN_VALUE;
        }

        for(int i=0; i<m; i++) {
            input = br.readLine().split(" ");
            edge[i] = new Pair(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }

        len[1] = 0;

        int[] path = new int[n+1];
        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m; j++) {
                if(len[edge[j].start]==Integer.MIN_VALUE) continue;

                if(len[edge[j].end] < len[edge[j].start]+edge[j].cost) {
                    len[edge[j].end] = len[edge[j].start] + edge[j].cost;
                    path[edge[j].end] = edge[j].start;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int j=0; j<m; j++) {
            if(len[edge[j].start]==Integer.MIN_VALUE) continue;

            if(len[edge[j].end] < len[edge[j].start]+edge[j].cost) {
                list.add(edge[j].end);
            }
        }

        if(len[n]==Integer.MIN_VALUE) {
            System.out.println(-1);
            return;
        }

        if(list.size()!=0) {
            boolean[] v = bfs(list, n);

            if(v[n])
                System.out.println(-1);

            else {
                StringBuilder sb = new StringBuilder();
                int j = n;
                sb.append(n);
                while(path[j]!=0) {
                    sb.insert(0, path[j]+" ");
                    j = path[j];
                }
                System.out.println(sb.toString());
            }
        }

        else {
            StringBuilder sb = new StringBuilder();
            int j = n;
            sb.append(n);
            while(path[j]!=0) {
                sb.insert(0, path[j]+" ");
                j = path[j];
            }
            System.out.println(sb.toString());
        }
    }

    public static boolean[] bfs(ArrayList<Integer> list, int N) {
        boolean[] visited = new boolean[N+1];

        for(int j=0; j<list.size(); j++) {
            int start = list.get(j);

            if(!visited[start]) {
                Queue<Integer> queue = new LinkedList<>();
                visited[start] = true;
                queue.add(start);

                while(!queue.isEmpty()) {
                    int temp = queue.poll();

                    for(int i=0; i<edge.length; i++) {
                        Pair next = edge[i];

                        if(temp==next.start && !visited[next.end]) {
                            visited[next.end] = true;
                            queue.add(next.end);
                        }
                    }
                }
            }
        }

        return visited;
    }

    public static class Pair {
        int start;
        int end;
        int cost;

        public Pair(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
