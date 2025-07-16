package search.dfs;


import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ_9202 {
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy ={-1, 1, 0, 0, -1, 1, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static HashMap<String, Integer> hm;
    static HashSet<String> prefixSet = new HashSet<>();
    static String[] words;
    static int score;
    static String maxWords;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        words = new String[n];
        hm = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            words[i] = br.readLine();
            for(int j=1 ; j<=words[i].length() ; j++) {
                prefixSet.add(words[i].substring(0, j));
            }
            hm.put(words[i], 0);
        }

        br.readLine();
        int b = Integer.parseInt(br.readLine());
        while (b-- > 0) {
            map = new char[4][4];
            maxWords = "";
            cnt = 0;
            score = 0;

            for(int i=0 ; i<4 ; i++) {
                char[] arr = br.readLine().toCharArray();
                for(int j=0 ; j<4 ; j++) {
                    map[i][j] = arr[j];
                }
            }

            for(int i=0 ; i<4 ; i++) {
                for(int j=0 ; j<4 ; j++) {
                    visited = new boolean[4][4];
                    visited[i][j] = true;

                    dfs("" + map[i][j], i, j);
                }
            }

            bw.write(score + " " + maxWords + " " + cnt);
            bw.write("\n");
            for(int i=0 ; i<n ; i++) {
                hm.put(words[i], 0);
            }
            br.readLine();
        }
        bw.flush();
        bw.close();
    }
    private static void dfs(String word, int x, int y) {
        if(!prefixSet.contains(word)) return;
        if(hm.containsKey(word) && hm.get(word) == 0) {
            cnt++;

            if(word.length() == 3 || word.length() == 4) score += 1;
            else if(word.length() == 5) score += 2;
            else if(word.length() == 6) score += 3;
            else if(word.length() == 7) score += 5;
            else if(word.length() == 8) score += 11;

            if(maxWords.length() < word.length()) maxWords = word;
            else if(maxWords.length() == word.length())  {
                maxWords = maxWords.compareTo(word) < 0 ? maxWords : word;
            }
            hm.put(word, 1);
        }
        for(int i=0 ; i<8 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= 4 || ny >= 4) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(word + map[nx][ny], nx, ny);
            visited[nx][ny] = false;
        }

    }
}
