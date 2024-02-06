package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

public class BOJ_18116 {
    static int[] counts = new int[1000001];
    static int[] arr = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1 ; i<=1000000 ; i++) {
            arr[i] = i;
            counts[i] = 1;
        }


        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String alpha = st.nextToken();

            if(alpha.equals("I")) {
                int parts1 = Integer.parseInt(st.nextToken());
                int parts2 = Integer.parseInt(st.nextToken());
                union(parts1, parts2);
            } else {
                int num = Integer.parseInt(st.nextToken());

                System.out.println(counts[find(num)]);
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
            counts[a] += counts[b];
        }
    }
}
