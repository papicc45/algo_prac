package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11437 {
    static ArrayList<Integer>[] list;
    static int[] depth;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        depth = new int[n+1];
        parent = new int[n+1];

        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1, 1, 0);
        int m = Integer.parseInt(br.readLine());
        for(int i=0 ; i<m ; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ah = depth[a];
            int bh = depth[b];

            while (ah > bh) {
                a = parent[a];
                ah--;
            }
            while (bh > ah) {
                b = parent[b];
                bh--;
            }

            while (a != b) {
                a = parent[a];
                b = parent[b];
            }
            System.out.println(a);
        }
    }
    private static void dfs(int temp, int d, int par) {
        parent[temp] = par;
        depth[temp] = d;
        for(int next : list[temp]) {
            if(next != par) {
                dfs(next, d+1, temp);
            }
        }
    }
}
