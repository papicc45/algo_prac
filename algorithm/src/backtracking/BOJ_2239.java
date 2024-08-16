package backtracking;

import java.util.Scanner;

public class BOJ_2239 {
    static int[][] arr;
    static boolean b = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[9][9];
        for (int i =0; i < 9; i++) {
            String str = sc.nextLine();
            for(int j =0; j < 9; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        recur(0);

        for(int i =0; i < 9; i++) {
            for(int j =0; j < 9; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    private static boolean check(int x, int y, int num) {
        for(int i=0 ; i<9 ; i++) {
            if(arr[x][i] == num)
                return false;
            if(arr[i][y] == num)
                return false;
        }

        int nx = x / 3 * 3;
        int ny = y - y % 3;
        for(int i=nx ; i<nx+3 ; i++) {
            for(int j=ny ; j<ny+3 ; j++) {
                if(arr[i][j] == num)
                    return false;
            }
        }
        return true;
    }
    private static void recur(int idx) {
        if(idx == 81) {
            b = true;
            return;
        }

        int x = idx / 9;
        int y = idx % 9;
        if(arr[x][y] != 0)
            recur(idx + 1);
        else {
            for(int i=1 ; i<=9 ; i++) {
                if(!check(x, y, i)) continue;

                arr[x][y] = i;
                recur(idx + 1);
                if(b) return;
                arr[x][y] = 0;
            }
        }
    }
}
