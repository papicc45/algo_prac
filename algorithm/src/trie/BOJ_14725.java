package trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TrieNode root = new TrieNode();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] feeds = new String[k];
            for(int j=0 ; j<k ; j++) {
                feeds[j] = st.nextToken();
            }

            insert(root, feeds);
        }

        dfs(root, 0);

    }
    static void dfs(TrieNode node, int depth) {
        for(Map.Entry<String, TrieNode> e : node.children.entrySet()) {
            System.out.println("--".repeat(depth) + e.getKey());
            dfs(e.getValue(), depth + 1);
        }
    }
    static class TrieNode {
        Map<String, TrieNode> children = new TreeMap<>();
    }

    static void insert(TrieNode root, String[] feeds) {
        TrieNode current = root;
        for(String feed : feeds) {
            current = current.children.computeIfAbsent(feed, k -> new TrieNode());
        }
    }
}
