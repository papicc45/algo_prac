package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_13418 {
    static int[] parent;
    static int n;
    static int max, min;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        init();
        for(int i=0 ; i<=m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int updown = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end, updown));
        }

        //오르막길 먼저 정렬
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.updown - o2.updown;
            }
        });

        int cnt = 0;
        int k = 0;
        for(Node node : list) {
            if(cnt == n-1)
                break;

            if(find(node.start) != find(node.end)) {
                union(node.start, node.end);
                if(node.updown == 0) {
                    k++;
                }
            }
        }
        max = (int)Math.pow(k, 2);

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.updown - o1.updown;
            }
        });
        init();
        k = 0;
        cnt = 0;

        for(Node node : list) {
            if(cnt == n-1)
                break;

            if(find(node.start) != find(node.end)) {
                union(node.start, node.end);
                if(node.updown == 0) {
                    k++;
                }
            }
        }
        min = (int)Math.pow(k, 2);
        System.out.println(max - min);
    }

    private static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }
    private static void init() {
        parent = new int[n+1];
        for(int i=0 ; i<=n ; i++) {
            parent[i] = i;
        }
    }

    static class Node {
        int start;
        int end;
        int updown;

        public Node(int start, int end, int updown) {
            this.start = start;
            this.end = end;
            this.updown = updown;
        }
    }
}
