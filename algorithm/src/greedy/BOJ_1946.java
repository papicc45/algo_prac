package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentMap;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int k=0 ; k<t ; k++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Score> list = new ArrayList<>();
            for(int i=0 ; i<n ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);

            int result = 1;
            int compare = list.get(0).interview;
            for(int i=1 ; i<list.size() ; i++) {
                if(list.get(i).interview < compare) {
                    result++;
                    compare = list.get(i).interview;
                }
            }
            System.out.println(result);
        }


    }
}
class Score implements Comparable<Score> {
    int document;
    int interview;

    public Score(int document, int interview) {
        this.document = document;
        this.interview = interview;
    }

    @Override
    public int compareTo(Score o) {
        if(this.document == o.document)
            return this.interview - o.interview;
        else
            return this.document - o.document;
    }
}
