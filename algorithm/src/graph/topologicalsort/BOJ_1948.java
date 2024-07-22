package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1948 {
    static int n;
    static ArrayList<Node>[] list;
    static ArrayList<Node>[] rList;
    static int[] max;
    static int[] degree;
    static int startDosi, endDosi;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        rList = new ArrayList[n+1];
        max = new int[n+1];
        Arrays.fill(max, Integer.MIN_VALUE);
        degree = new int[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
            rList[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, value));
            rList[end].add(new Node(start, value));
            degree[end]++;
        }
        st = new StringTokenizer(br.readLine());
        startDosi = Integer.parseInt(st.nextToken());
        endDosi = Integer.parseInt(st.nextToken());
        queue.add(new Node(startDosi, 0));

        max[startDosi] = 0;
        solve();
        System.out.println(max[endDosi]);
        System.out.println(reverse());
    }
    private static int reverse() {
        Queue<Integer> queue2 = new LinkedList<>();
        int cnt = 0;
        queue2.add(endDosi);
        boolean[] visited = new boolean[n+1];
        visited[endDosi] = true;
        while (!queue2.isEmpty()) {
            int temp = queue2.poll();

            for(Node next : rList[temp]) {
                if(max[next.vertex] + next.value == max[temp]) {
                    cnt++;

                    if(!visited[next.vertex]) {
                        visited[next.vertex] = true;
                        queue2.add(next.vertex);
                    }
                }
            }
        }
        return cnt;
    }
    private static void solve() {
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            for(Node next : list[temp.vertex]) {
                degree[next.vertex]--;

                max[next.vertex] = Math.max(max[next.vertex], max[temp.vertex] + next.value);
                if(degree[next.vertex] == 0) {
                    queue.add(new Node(next.vertex, max[next.vertex]));
                }
            }
        }
    }
    static class Node {
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }
    }
}