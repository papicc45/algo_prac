package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17352 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = i;
        }

        for(int i=0 ; i<n-2 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        for(int i=1 ; i<=n ; i++) {
            if(find(i) == i) {
                System.out.print(i + " ");
            }
        }


    }
    private static int find(int a) {
        if(arr[a] == a)
            return a;

        return arr[a] = find(arr[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            arr[b] = a;
        }
    }
}
