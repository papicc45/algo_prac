package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_23040 {
    static int[] parent;
    static int[] cnt;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        cnt = new int[n+1];
        list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
            list[i] =  new ArrayList<>();
        }


        for(int i=0 ; i<n-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        ArrayList<Integer> red = new ArrayList<>();
        ArrayList<Integer> black = new ArrayList<>();
        char[] arr = br.readLine().toCharArray();
        for(int i=0 ; i<arr.length ; i++) {
            if(arr[i] == 'R') {
                red.add(i + 1);
                cnt[i+1] = 1;
            } else {
                black.add(i + 1);
            }
        }

        for(int r : red) {
            for(int next : list[r]) {
                if(arr[next-1] == 'R') {
                    union(r, next);
                }
            }
        }

        long result = 0;
        for(int b : black) {
            for(int next : list[b]) {
                result += cnt[find(next)];
            }
        }

        System.out.println(result);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
            cnt[a] += cnt[b];
        }
    }
    private static int find(int a) {
        if(parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}
