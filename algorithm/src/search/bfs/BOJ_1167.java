package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1167 {
    static int n;
    static ArrayList<TreeNode>[] list;
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;
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
                    list[vertex].add(new TreeNode(node, value));
                }
            }
        }


        visited = new boolean[n+1];
        BFS(1);

        System.out.println(result);

    }
    public static void BFS(int index) {
        Queue<TreeNode> queue = new LinkedList<>();
        visited[index] = true;
        queue.add(new TreeNode(index, 0));

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result = Math.max(result, temp.value);

            for(TreeNode t : list[temp.vertex]) {
                if(!visited[t.vertex]) {
                    visited[t.vertex] = true;
                    queue.add(new TreeNode(t.vertex, temp.value + t.value));
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