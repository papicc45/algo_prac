package datastructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3190 {
    static int n;
    //동남서북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] map;
    static ArrayList<int[]> snake = new ArrayList<>();
    static HashMap<Integer, String> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for(int i=0 ; i<k ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int appleX = Integer.parseInt(st.nextToken()) - 1;
            int appleY = Integer.parseInt(st.nextToken()) - 1;

            map[appleX][appleY] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        for(int i=0 ; i<l ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            hm.put(time, direction);
        }
        snake.add(new int[] {0, 0});
        int headX = 0, headY = 0;
        int time = 0;
        int d = 0;
        while(true) {
            time++;

            headX = headX + dx[d];
            headY = headY + dy[d];

            if(!check(headX, headY))
                break;
            if(map[headX][headY] == 1) {
                map[headX][headY] = 0;
                snake.add(new int[] {headX, headY});
            } else {
                snake.add(new int[] {headX, headY});
                snake.remove(0);
            }

            if(hm.containsKey(time)) {
                String val = hm.get(time);
                if(val.equals("D")) {
                    d += 1;
                    if(d == 4)
                        d = 0;
                } else {
                    d -= 1;
                    if(d == -1)
                        d = 3;
                }
            }
        }
        System.out.println(time);

    }
    static boolean check(int headX, int headY) {
        if(headX < 0 || headY < 0 || headX >= n || headY >= n)
            return false;

        for(int[] arr : snake) {
            if(arr[0] == headX && arr[1] == headY) {
                return false;
            }
        }
        return true;
    }
}