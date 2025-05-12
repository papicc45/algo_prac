package implement;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21608 {
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer>[] list;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int sn = (int)Math.pow(n, 2) + 1;
        list = new ArrayList[sn];
        map = new int[n][n];
        for(int i=0 ; i<sn ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=1 ; i<sn ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            queue.add(c);
            for(int j=0 ; j<4 ; j++) {
                list[c].add(Integer.parseInt(st.nextToken()));
            }
        }

        while (!queue.isEmpty()) {
            ArrayList<int[]> emptyList = new ArrayList<>();
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(map[i][j] == 0)
                        emptyList.add(new int[] {i, j});
                }
            }


            int tempStudent = queue.poll();
            ArrayList<int[]> secondList = second(tempStudent, emptyList);
            if(secondList.size() == 1) {
                int x = secondList.get(0)[0];
                int y = secondList.get(0)[1];
                map[x][y] = tempStudent;
            } else {
                ArrayList<int[]> adjList = adjEmptyCheck(secondList);
                if(adjList.size() == 1) {
                    int x = adjList.get(0)[0];
                    int y = adjList.get(0)[1];
                    map[x][y] = tempStudent;
                } else {
                    Collections.sort(adjList, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            if(o1[0] == o2[0]) {
                                return o1[1] - o2[1];
                            } else {
                                return o1[0] - o2[0];
                            }
                        }
                    });

                    int x = adjList.get(0)[0];
                    int y = adjList.get(0)[1];
                    map[x][y] = tempStudent;
                }
            }
        }
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                int temp = map[i][j];

                int cnt = 0;
                for(int k=0 ; k<4 ; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(range(nx, ny) && list[temp].contains(map[nx][ny])) {
                        cnt++;
                    }
                }

                if(cnt == 1) result++;
                else if(cnt == 2) result += 10;
                else if(cnt == 3) result += 100;
                else if(cnt == 4) result += 1000;
            }
        }

        System.out.println(result);
    }
    private static ArrayList<int[]> adjEmptyCheck(ArrayList<int[]> list) {
        int[][] cnt = new int[n][n];
        int max = 0;
        for(int[] arr : list) {
            int tx = arr[0];
            int ty = arr[1];

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(range(nx, ny) && map[nx][ny] == 0) {
                    cnt[tx][ty]++;
                }
            }

            max = Math.max(max, cnt[tx][ty]);
        }

        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] arr : list) {
            if(cnt[arr[0]][arr[1]] == max) {
                ans.add(new int[] {arr[0], arr[1]});
            }
        }

        return ans;
    }
    private static ArrayList<int[]> second(int student, ArrayList<int[]> emptyList) {
        int[][] cnt = new int[n][n];
        int max = 0;
        for(int[] temp : emptyList) {
            int tx = temp[0];
            int ty = temp[1];

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(range(nx, ny) && list[student].contains(map[nx][ny])) {
                    cnt[tx][ty]++;
                }
            }
            max = Math.max(max, cnt[tx][ty]);
        }

        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] temp : emptyList) {
            if(cnt[temp[0]][temp[1]] == max) {
                ans.add(new int[] {temp[0], temp[1]});
            }
        }

        return ans;
    }
    private static boolean range(int x, int y) {
        if(x>=0 && x<n && y>=0 && y<n)
            return true;

        return false;
    }
}
