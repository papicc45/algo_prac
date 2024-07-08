package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17140 {
    static int r, c, k;
    static int[][] map;
    static int rSize = 3, cSize = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new int[101][101];

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=1 ; i<=3 ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=3 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (cnt <= 100) {
            if(map[r][c] == k)
                break;
            if(rSize >= cSize)
                rCalc();
            else
                cCalc();

            cnt++;
        }
        if(cnt == 101)
            System.out.println("-1");
        else
            System.out.println(cnt);
    }
    private static void cCalc() {
        for(int j=1;  j<=100 ; j++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int i=1 ; i<=100 ; i++) {
                if(map[i][j] == 0)
                    continue;

                hm.put(map[i][j], hm.getOrDefault(map[i][j],0) + 1);
                map[i][j] = 0;
            }

            List<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:hm.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }
            Collections.sort(list);

            int idx = 0;
            for(int i=1 ; i<=99 ; i+=2) {
                if(idx >= list.size())
                    break;

                    map[i][j] = list.get(idx).num;
                    map[i+1][j] = list.get(idx).value;
                    idx++;
            }
            rSize = Math.max(rSize,  idx == 99 ? 100 : idx * 2);
        }
    }
    private static void rCalc() {
        for(int i=1 ; i<=100 ; i++) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            for(int j=1 ; j<=100 ; j++) {
                if(map[i][j] == 0)
                    continue;

                hm.put(map[i][j], hm.getOrDefault(map[i][j],0) + 1);
            }

            List<Node> list = new ArrayList<>();
            for(Map.Entry<Integer, Integer> entry:hm.entrySet()) {
                list.add(new Node(entry.getKey(), entry.getValue()));
            }

            Collections.sort(list);
            int idx = 0;
            Arrays.fill(map[i], 0);
            for(int j=1 ; j<=99 ; j+=2) {
                if(idx >= list.size())
                    break;
                map[i][j] = list.get(idx).num;
                map[i][j+1] = list.get(idx).value;
                idx++;
            }
            cSize = Math.max(cSize,  idx == 99 ? 100 : idx * 2);
        }
    }
    static class Node implements Comparable<Node> {
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value == o.value)
                return this.num - o.num;
            else
                return this.value - o.value;
        }
    }
}
