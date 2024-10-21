package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16235 {
    static int n, m, k;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static PriorityQueue<Tree> queue = new PriorityQueue<>();
    static Queue<Tree> deathTree = new LinkedList<>();
    static int[][] map;
    static int[][] food;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        food = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            Arrays.fill(map[i], 5);
        }

        for(int i=1 ; i<=n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1 ; j<=n ; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            queue.add(new Tree(x, y, age));
        }

        for(int i=0 ; i<k ; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        //1000 * 8 *
        System.out.println(queue.size());
    }
    private static boolean range(int x, int y) {
        if(x<=0 || y<=0 || x>n || y>n) return false;
        return true;
    }
    private static void addQueue(ArrayList<Tree> list) {
        for(Tree tree : list)
            queue.add(tree);
    }
    private static void spring() {
        int size = queue.size();
        ArrayList<Tree> list = new ArrayList<>();
        for(int i=0 ; i<size ; i++) {
            Tree temp = queue.poll();
            int tx = temp.x;
            int ty = temp.y;
            int tage = temp.age;

            if(map[tx][ty] >= tage) {
                map[tx][ty] -= tage;
                list.add(new Tree(tx, ty, tage + 1));
            } else {
                deathTree.add(temp);
            }
        }
        addQueue(list);
    }
    private static void summer() {
        while (!deathTree.isEmpty()) {
            Tree temp = deathTree.poll();
            int tx = temp.x;
            int ty = temp.y;
            int tage = temp.age;

            map[tx][ty] += (tage / 2);
        }
    }
    private static void autumn() {
        int size = queue.size();
        ArrayList<Tree> list = new ArrayList<>();
        for(int i=0 ; i<size ; i++) {
            Tree temp = queue.poll();
            int tx = temp.x;
            int ty = temp.y;
            int tage = temp.age;

            if(tage % 5 == 0) {
                for(int j=0 ; j<8 ; j++) {
                    int nx = tx + dx[j];
                    int ny = ty + dy[j];

                    if(!range(nx, ny)) continue;
                    list.add(new Tree(nx, ny, 1));
                }
            }
            list.add(temp);
        }
        addQueue(list);
    }
    private static void winter() {
        for(int i=1 ; i<=n ; i++) {
            for(int j=1 ; j<=n ; j++) {
                map[i][j] += food[i][j];
            }
        }
    }
    static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
