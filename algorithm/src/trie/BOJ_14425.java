package trie;

import javax.swing.text.TabExpander;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.StringTokenizer;

public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for(int i=0 ; i<n ; i++) {
            String next = br.readLine();
            Node now = root;
            for(int j=0 ; j<next.length() ; j++) {
                char ch = next.charAt(j);
                if(now.next[ch - 'a'] == null) {
                    now.next[ch - 'a'] = new Node();
                }

                now = now.next[ch - 'a'];
                if(j == next.length() - 1)
                    now.isEnd = true;
            }
        }
        int result = 0;
        for(int i=0 ; i<m ; i++) {
            String next = br.readLine();
            Node now = root;

            for(int j=0 ; j<next.length() ; j++) {
                char ch = next.charAt(j);
                if(now.next[ch - 'a'] == null)
                    break;

                now = now.next[ch - 'a'];
                if(j == next.length() - 1 && now.isEnd)
                    result++;
            }
        }
        System.out.println(result);
    }
    static class Node {
        Node[] next = new Node[26];
        boolean isEnd;
    }
}
