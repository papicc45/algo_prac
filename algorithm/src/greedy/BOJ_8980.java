package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class BOJ_8980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        PostInfo[] posts = new PostInfo[m];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            posts[i] = new PostInfo(start, end, weight);
        }
        Arrays.sort(posts);

        int[] maxWeights = new int[n+1];
        Arrays.fill(maxWeights, c);

        int result = 0;
        for(int i=0 ; i<m ; i++) {
            PostInfo post = posts[i];
            int min = Integer.MAX_VALUE;

            for(int j=post.start ; j<post.end ; j++) {
                min = Math.min(min, maxWeights[j]);
            }

            if(min >= post.weight) {
                for(int j=post.start ; j<post.end ; j++) {
                    maxWeights[j] -= post.weight;
                }
                result += post.weight;
            } else {
                for(int j=post.start ; j<post.end ; j++) {
                    maxWeights[j] -= min;
                }
                result += min;
            }
        }
        System.out.println(result);
    }
}

class PostInfo implements Comparable<PostInfo>{
    int start;
    int end;
    int weight;

    public PostInfo(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(PostInfo o) {
        if(this.end == o.end) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}
