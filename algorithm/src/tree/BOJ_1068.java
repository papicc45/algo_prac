package tree;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1068 {
    static boolean[] visited;
    static int result = 0;
    static int[] parentNode;

    static ArrayList<Integer>[] list;
    static int deleteNode;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        visited = new boolean[n];
        parentNode = new int[n];
        list = new ArrayList[n];
        for(int i=0 ; i<n ; i++) {
            list[i] = new ArrayList<>();
        }

        int rootNode = 0;
        for(int i=0 ; i<n ; i++) {
            int parent = sc.nextInt();

            if(parent == -1) {
                rootNode = i;
                continue;
            }

            list[parent].add(i);
            list[i].add(parent);
        }
        deleteNode = sc.nextInt();

        if(deleteNode == rootNode)
            System.out.println(0);
        else {
            DFS(rootNode);
            System.out.println(result);
        }
    }
    private static void DFS(int num) {
        visited[num] = true;
        int count = 0;
        for(int next : list[num]) {
            if(!visited[next] && next != deleteNode) {
                count++;
                DFS(next);
            }
        }
        if(count == 0)
            result++;
    }
}
