package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n+1];
        int[] degree = new int[n+1];
        int[] result = new int[n+1];
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1 ; i<=n ; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0 ; j<str.length ; j++) {
                if(j == 0) {
                    times[i] = Integer.parseInt(str[j]);
                } else {
                    int next = Integer.parseInt(str[j]);
                    if(next != -1) {
                        degree[next]++;
                    }
                }
            }
        }

    }
}
