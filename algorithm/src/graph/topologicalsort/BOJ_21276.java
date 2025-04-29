package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.*;

public class BOJ_21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        HashMap<String, ArrayList<String>> direct = new HashMap<>();
        HashMap<String, Integer> degree = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            String p = st.nextToken();
            hm.put(p, new ArrayList<>());
            direct.put(p, new ArrayList<>());
            degree.put(p, 0);
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            String p = st.nextToken();
            hm.get(p).add(c);
            degree.put(c, degree.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        Queue<String> queue  = new LinkedList<>();
        for(String p : degree.keySet()){
            if(degree.get(p) == 0) {
                pq.add(p);
                queue.add(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()){
            String p = pq.poll();
            sb.append(p).append(" ");
        }
        sb.append("\n");

        while (!queue.isEmpty()) {
            String p = queue.poll();

            for(String c : hm.get(p)){
                degree.put(c, degree.getOrDefault(c, 0) - 1);

                if(degree.get(c) == 0) {
                    queue.add(c);
                    direct.get(p).add(c);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(direct.keySet());
        Collections.sort(list);
        for(String p : list){
            sb.append(p).append(" ").append(direct.get(p).size()).append(" ");
            Collections.sort(direct.get(p));
            for(String c : direct.get(p)) {
                sb.append(c).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
