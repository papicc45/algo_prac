package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static int[][] tree = new int[26][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0 ; i<n ; i++) {
            String[] temp = br.readLine().split(" ");
            int parent = temp[0].charAt(0) - 'A';
            char left = temp[1].charAt(0);
            char right = temp[2].charAt(0);

            if(left == '.') {
                tree[parent][0] = -1;
            } else {
                tree[parent][0] = left - 'A';
            }

            if(right == '.') {
                tree[parent][1] = -1;
            } else {
                tree[parent][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    private static void preOrder(int num) {
        if(num == -1)
            return;

        System.out.print((char)(num + 'A'));
        preOrder(tree[num][0]);
        preOrder(tree[num][1]);
    }

    private static void inOrder(int num) {
        if(num == -1)
            return;

        inOrder(tree[num][0]);
        System.out.print((char)(num + 'A'));
        inOrder(tree[num][1]);
    }

    private static void postOrder(int num) {
        if(num == -1)
            return;

        postOrder(tree[num][0]);
        postOrder(tree[num][1]);
        System.out.print((char)(num + 'A'));
    }
}
