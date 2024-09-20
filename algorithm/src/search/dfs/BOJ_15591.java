package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15591 {
    static ArrayList<Usado>[] list;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[start].add(new Usado(end, len));
            list[end].add(new Usado(start, len));
        }


        for(int i=0 ; i<q ; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            visited = new boolean[n+1];
            int result = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(num);
            visited[num] = true;

            while (!queue.isEmpty()) {
                int temp = queue.poll();

                for(Usado next : list[temp]) {
                    if(!visited[next.vertex]) {
                        if(next.len >= k) {
                            visited[next.vertex] = true;
                            queue.add(next.vertex);
                            result++;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
    static class Usado {
        int vertex;
        int len;

        public Usado(int vertex, int len) {
            this.vertex = vertex;
            this.len = len;
        }
    }
}
