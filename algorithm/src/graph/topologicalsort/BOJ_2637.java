package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] degree = new int[n+1];
        int[] result = new int[n+1];

        ArrayList<Toy>[] list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mid = Integer.parseInt(st.nextToken());
            int standard = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            degree[standard]++;
            list[mid].add(new Toy(standard, count));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        result[n] = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for(Toy toy : list[temp]) {
                result[toy.target] += result[temp] * toy.count;
                degree[toy.target]--;

                if(degree[toy.target] == 0)
                    queue.add(toy.target);
            }
        }

        for(int i=1 ; i<=n ; i++) {
            if(list[i].size() == 0)
                System.out.println(i + " " + result[i]);
        }
    }
    static class Toy {
        int target;
        int count;

        public Toy(int target, int count) {
            this.target = target;
            this.count = count;
        }
    }
}
