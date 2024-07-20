package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UTFDataFormatException;
import java.util.*;

public class BOJ_14676 {
    static int[] degree;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer>[] checkBack;
    static int[] build;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        degree = new int[n+1];
        build = new int[n+1];
        list = new ArrayList[n+1];
        checkBack = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] =  new ArrayList<>();
            checkBack[i] = new ArrayList<>();
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            checkBack[b].add(a);

            degree[b]++;
        }

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(c == 1) {
                if(degree[num] > 0) {
                    System.out.println("Lier!");
                    return;
                } else {
                    build[num]++;
                    if(build[num] == 1) {
                        for(int next : list[num]) {
                            degree[next]--;
                        }
                    }
                }
            } else {
                if(build[num] == 0) {
                    System.out.println("Lier!");
                    return;
                } else {
                    build[num]--;
                    if(build[num] == 0) {
                        for(int next : list[num]) {
                            degree[next]++;
                        }
                    }
                }
            }
        }
        System.out.println("King-God-Emperor");
    }
}
