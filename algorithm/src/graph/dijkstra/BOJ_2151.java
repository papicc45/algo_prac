package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_2151 {

    static ArrayList<Integer>[] list;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int start = 0, end = 0;
        for(int i=0 ; i<n ; i++) {
            String[] arr = br.readLine().split("");
            for(int j=0 ; j<n ; j++) {
                char ch = arr[j].charAt(0);
                if(ch == '#') {
                    if(start == 0) {
                        start = ++count;
                    } else {
                        end = ++count;
                    }
                    map[i][j] = count;
                } else if(ch == '!') {
                    map[i][j] = ++count;
                } else if(ch == '*') {
                    map[i][j] = -1;
                }
            }
        }

        list = new ArrayList[count+1];
        for(int i=0 ; i<=count ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(map[i][j] > 0) {

                    for(int k=j-1 ; k>=0 ; k--) {
                        if(map[i][k] == -1) break;
                        if(map[i][k] > 0) list[map[i][j]].add(map[i][k]);
                    }
                    for(int k=j+1 ; k<n ; k++) {
                        if(map[i][k] == -1) break;
                        if(map[i][k] > 0) list[map[i][j]].add(map[i][k]);
                    }

                    for(int k=i-1 ; k>=0 ; k--) {
                        if(map[k][j] == -1) break;
                        if(map[k][j] > 0) list[map[i][j]].add(map[k][j]);
                    }

                    for(int k=i+1 ; k<n ; k++) {
                        if(map[k][j] == -1) break;
                        if(map[k][j] > 0) list[map[i][j]].add(map[k][j]);
                    }
                }
            }
        }
        if(list[start].contains(end) || list[end].contains(start))
            System.out.println(0);
        else {
            int a1 = dijkstra(start, end);
            int a2 = dijkstra(end, start);

            System.out.println(Math.min(a1, a2));
        }
    }
    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        boolean[] visited = new boolean[count+1];
        int answer = 0;
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if(temp.num == end) {
                answer = temp.cnt;
                break;
            }

            if(visited[temp.num]) continue;

            visited[temp.num] = true;
            for(Integer next : list[temp.num]) {
                if(!visited[next]) {
                    queue.add(new Node(next, temp.cnt + 1));
                }
            }
        }
        return answer - 1;
    }
    static class Node implements Comparable<Node> {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
}
