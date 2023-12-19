package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Homework> list = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            list.add(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int result = 0;
        for(int i=n ; i>=1 ; i--) {
            int index = 0;
            int max = Integer.MIN_VALUE;
            for(int j=0 ; j<list.size() ; j++) {
                Homework temp = list.get(j);
                if(i <= temp.deadline) {
                    if(max < temp.score) {
                        max = temp.score;
                        index = j;
                    }
                }
            }
            if(max != Integer.MIN_VALUE) {
                result += max;
                list.remove(index);
            }
        }
        System.out.println(result);
    }
}

class Homework {
    int deadline;
    int score;


    public Homework(int deadline, int score) {
        this.deadline = deadline;
        this.score = score;
    }

}
