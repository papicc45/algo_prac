package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0 ; i<n ; i++) {
            arr[i] = i;
        }

        int result = 0;
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int dot1 = Integer.parseInt(st.nextToken());
            int dot2 = Integer.parseInt(st.nextToken());

            dot1 = find(dot1);
            dot2 = find(dot2);

            if(dot2 == dot1) {
                result = i+1;
                break;
            } else {
                union(dot1, dot2);
            }
        }

        System.out.println(result);

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
