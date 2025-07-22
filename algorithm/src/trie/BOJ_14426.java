package trie;

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_14426 {
    static TrieNode root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        root = new TrieNode();

        for(int i=0 ; i<n ; i++) {
            String str = br.readLine();
            insert(str);
        }

        int cnt = 0;
        for(int i=0 ; i<m ; i++) {
            String prefix = br.readLine();
            if(searchPrefix(prefix)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    static class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean end;

        public TrieNode() {
            children = new HashMap<>();
            end = false;
        }
    }
        static void insert(String word) {
            TrieNode currentNode = root;
            for(char c : word.toCharArray()) {
                currentNode.children.putIfAbsent(c, new TrieNode());
                currentNode = currentNode.children.get(c);
            }
            currentNode.end = true;
        }

        static boolean searchPrefix(String prefix) {
            TrieNode currentNode = root;
            for(char c : prefix.toCharArray()) {
                if(!currentNode.children.containsKey(c)) {
                    return false;
                }
                currentNode = currentNode.children.get(c);
            }
            return true;
        }
}
