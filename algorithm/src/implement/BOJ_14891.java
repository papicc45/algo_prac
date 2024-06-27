package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.zip.CheckedInputStream;

public class BOJ_14891 {
    static int[][] chains;
    static boolean[] visited;
    static int[] d = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        chains = new int[5][8];
        for(int i=1 ; i<=4 ; i++) {
            String chain = br.readLine();
            for(int j=0 ; j<8 ; j++) {
                chains[i][j] = chain.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine());

        for(int i=0 ; i<k ; i++) {
            visited = new boolean[5];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int direct = Integer.parseInt(st.nextToken());
            visited[num] = true;
            recur(num, direct);
        }

        int result = 0;
        for(int i=1 ; i<=4 ; i++) {
            if(chains[i][0] == 0)
                continue;

            result += (int)(Math.pow(2, i-1));
        }
        System.out.println(result);
    }
    private static void recur(int num, int direct) {
        int left = num - 1;
        int right = num + 1;


        // 2 - 3시방향, 6 - 9시방향
        if(range(left) && !visited[left]) {
            visited[left] = true;
            if(chains[num][6] != chains[left][2]) {
                recur(left, direct == 1 ? -1 : 1);
            }
        }

        if(range(right) && !visited[right]) {
            visited[right] = true;
            if(chains[num][2] != chains[right][6]) {
                recur(right, direct == 1 ? -1 : 1);
            }
        }
        turn(num, direct);
    }
    private static void turn(int num, int direct) {
        if(direct == 1) {
            int d = chains[num][7];
            for(int i=6 ; i>=0; i--)
                chains[num][i+1] = chains[num][i];
            chains[num][0] = d;
        } else {
            int d = chains[num][0];
            for(int i=1 ; i<8 ; i++)
                chains[num][i-1] = chains[num][i];
            chains[num][7] = d;
        }
    }
    private static boolean range(int num) {
        if(num >=1 && num <5)
            return true;

        return false;
    }


}
