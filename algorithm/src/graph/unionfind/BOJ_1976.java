package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = i;
        }

        for(int i=1 ; i<=n ; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0 ; j<str.length ; j++) {
                int temp = Integer.parseInt(str[j]);

                if(temp == 1) {
                    union(i, j+1);
                }
            }
        }
        boolean check = true;
        String[] str = br.readLine().split(" ");
        int a = find(Integer.parseInt(str[0]));
        for(int i=1 ; i<str.length ; i++) {
            int temp = find(Integer.parseInt(str[i]));
            if(a != temp) {
                check = false;
            }
        }
        if(!check) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
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

        if(a != b)
            arr[b] = a;
    }
}
