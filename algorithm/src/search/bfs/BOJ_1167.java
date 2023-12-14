package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1167 {
    static int n;
    static ArrayList<TreeNode>[] list;
    static boolean[] visited;
    static int[] nodes;
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n ; i++) {
            int node = sc.nextInt();
            while(true) {
                int vertex = sc.nextInt();
                if(vertex == -1)
                    break;
                else {
                    int value = sc.nextInt();
                    list[node].add(new TreeNode(vertex, value));
                }
            }
        }

        BFS(1);
        int max = 1;
        for(int i=2 ; i<=n ; i++) {
            if(nodes[i] > max) {
                max = i;
            }
        }

        BFS(max);
        Arrays.sort(nodes);
        System.out.println(nodes[n]);
    }
    public static void BFS(int index) {
        Queue<TreeNode> queue = new LinkedList<>();
        nodes = new int[n+1];
        visited = new boolean[n+1];
        visited[index] = true;
        queue.add(new TreeNode(index, 0));

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            for(TreeNode t : list[temp.vertex]) {
                if(!visited[t.vertex]) {
                    visited[t.vertex] = true;
                    queue.add(new TreeNode(t.vertex, temp.value + t.value));
                    nodes[t.vertex] = nodes[temp.vertex] +  t.value;
                }
            }
        }
    }
}

class TreeNode {
    int vertex;
    int value;

    public TreeNode(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
}