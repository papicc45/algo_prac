package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_25187 {
    static int[] parent;
    static int[] water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        water = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            parent[i] = i;
            int w = Integer.parseInt(st.nextToken());
            if(w == 0)
                water[i] = -1;
            else
                water[i] = 1;
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)) {
                union(a, b);
            }
        }

        for(int i=0 ; i<q ; i++) {
            int num = Integer.parseInt(br.readLine());
            num = find(num);

            System.out.println(water[num] > 0 ? 1 : 0);
        }


    }
    private static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }
    private static void union(int a, int b) {
        int na = find(a);
        int nb = find(b);

        if(na < nb) {
            parent[nb] = na;
            water[na] += water[nb];
        } else if(na > nb) {
            parent[na] = nb;
            water[nb] += water[na];
        }
    }
}
