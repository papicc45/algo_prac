package graph.minimumspanningtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitOption;
import java.rmi.NoSuchObjectException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16562 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        int[] values = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
            values[i] = Integer.parseInt(st.nextToken());
            arr[i] = i;
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());

            union(f1, f2);
        }

        boolean[] check = new boolean[n+1];
        int sum = 0;
        for(int i=1 ; i<=n ; i++) {
            int root = find(i);

            if(check[root]) {
                check[i] = true;
                continue;
            }

            sum += values[root];
            check[root] = true;
            check[i] = true;
        }
        if(sum > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }

    }
    static int find(int a) {
        if(arr[a] == a)
            return a;

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            arr[b] = a;
        }
    }
}
