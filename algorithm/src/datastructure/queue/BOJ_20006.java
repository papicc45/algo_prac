package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;

public class BOJ_20006 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();

        Queue<Room> queue = new LinkedList<>();
        ArrayList<Room> result = new ArrayList<>();
        for(int i=0 ; i<p ; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            map.put(name, l);

            if(m == 1) {
                makeRoom(i, queue, name, l);
                continue;
            }
            int size = queue.size();
            if(size == 0) {
                makeRoom(i, queue, name, l);
            } else {
                boolean enter = false;
                for(int j=0 ; j<size ; j++) {
                    Room room = queue.poll();
                    if(enter) {
                        queue.add(room);
                        continue;
                    }
                    if(room.level - 10 <= l && room.level + 10 >= l) {
                        room.players.add(name);
                        enter = true;

                        if(room.players.size() == m) {
                            result.add(room);
                        } else {
                            queue.add(room);
                        }
                    } else {
                        queue.add(room);
                    }
                }
                if(!enter) {
                    makeRoom(i, queue, name, l);
                }
            }
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(Room room : result) {
            if(room.players.size() == m)
                sb.append("Started!");
            else
                sb.append("Waiting!");

            sb.append("\n");
            Collections.sort(room.players);
            for(String name : room.players) {
                sb.append(map.get(name)).append(" ").append(name).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    private static void makeRoom(int num, Queue<Room> queue, String name, int level) {
        ArrayList<String> players = new ArrayList<>();
        players.add(name);
        queue.add(new Room(num, players, level));
    }
    static class Room implements Comparable<Room> {
        int num;
        ArrayList<String> players;
        int level;

        public Room(int num, ArrayList<String> players, int level) {
            this.num = num;
            this.players = players;
            this.level = level;
        }

        @Override
        public int compareTo(Room o) {
            return this.num - o.num;
        }
    }
}
