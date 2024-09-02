package search.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2668 {
    static int[] arr;
    static int n;
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = sc.nextInt();
        }

        visited = new boolean[n+1];
        for(int i=1 ; i<=n ; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int i : result)
            System.out.println(i);
    }
    private static void dfs(int temp, int next) {
        if(!visited[arr[temp]]) {
            visited[arr[temp]] = true;
            dfs(arr[temp], next);
            visited[arr[temp]] = false;
        }

        if(arr[temp] == next)
            result.add(next);
    }
}
