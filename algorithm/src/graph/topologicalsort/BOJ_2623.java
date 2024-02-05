package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] degree = new int[n+1];
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            String[] str = br.readLine().split(" ");
            int num = Integer.parseInt(str[0]);
            for(int j=1 ; j<num ; j++) {
                int pre = Integer.parseInt(str[j]);
                int next = Integer.parseInt(str[j+1]);

                list[pre].add(next);
                degree[next]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1 ; i<=n ; i++) {
            if(degree[i] == 0) {
                queue.add(i);
                result.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for(int next : list[temp]) {
                degree[next]--;

                if(degree[next] == 0) {
                    queue.add(next);
                    result.add(next);
                }
            }
        }
        if(result.size() != n) {
            System.out.println(0);
        } else {
            for(int i=0 ; i<result.size() ; i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
