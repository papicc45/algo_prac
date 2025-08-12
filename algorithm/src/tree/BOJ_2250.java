package tree;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2250 {
    static int n, root;
    static int maxLevel = 1;
    static int[] left, right, parent, size;
    static int[] minCol, maxCol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        left = new int[n+1];
        right = new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];
        minCol = new int[n+2];
        maxCol = new int[n+2];

        Arrays.fill(minCol, Integer.MAX_VALUE);

        for(int i=0; i <n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            left[v] = l;
            right[v] = r;
            if(l != -1) parent[l] = v;
            if(r != -1) parent[r] = v;
        }

        for(int i=1 ; i<=n ; i++) {
            if(parent[i] == 0) {
                root = i;
                break;
            }
        }

        dfsSize(root);
        dfs(root, 1, 1);
        int resultLevel = 0;
        int resultWidth = 0;
        for(int i=1 ; i<=maxLevel ; i++) {
            if(maxCol[i] - minCol[i] + 1 > resultWidth) {
                resultLevel = i;
                resultWidth = maxCol[i] - minCol[i] + 1;
            }
        }

        System.out.println(resultLevel + " " + resultWidth);
    }
    private static int dfsSize(int v) {
        if(v == -1)
            return 0;

        int ls = dfsSize(left[v]);  //왼쪽 자식노드 갯수
        int rs = dfsSize(right[v]);     //오른쪽 자식노드 갯수
        size[v] = ls + rs + 1;  //왼쪽, 오른쪽 자식노드 갯수 + 자신
        return size[v];
    }
    private static void dfs(int v, int base, int level) {
        if(v == -1) return;

        int leftSize = (left[v] == -1) ? 0 : size[left[v]];
        int col = base + leftSize;

        minCol[level] = Math.min(minCol[level], col);
        maxCol[level] = Math.max(maxCol[level], col);
        maxLevel = Math.max(maxLevel, level);

        dfs(left[v], base, level + 1);
        dfs(right[v], col + 1, level + 1);      //col + 1 -> 부모 노드 열 + 1
    }
}
