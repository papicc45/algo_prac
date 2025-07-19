package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2263 {
    static int n;
    static int[] inOrder;
    static int[] postOrder;
    static HashMap<Integer, Integer> inOrderHashMap = new HashMap<>();
    static HashMap<Integer, Integer> postOrderHashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inOrder = new int[n];
        postOrder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            inOrder[i] = num;
            inOrderHashMap.put(num, i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            postOrder[i] = num;
            postOrderHashMap.put(num, i);
        }

        recur(0, n-1, 0, n-1);
    }
    private static void recur(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return;

        int root = postOrder[postEnd];
        int inorderRootIndex = inOrderHashMap.get(root);
        int leftSize = inorderRootIndex - inStart;
        int rightSize = inEnd - inorderRootIndex;

        System.out.print(root + " ");

        recur(inStart, inorderRootIndex-1, postStart, postStart + leftSize-1);
        recur(inorderRootIndex+1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
