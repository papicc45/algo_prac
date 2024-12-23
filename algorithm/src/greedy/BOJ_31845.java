package greedy;

import java.awt.geom.RectangularShape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_31845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list, Collections.reverseOrder());

        int result = 0;
        for(int i=0 ; i<m ; i++) {
            if(list.size() == 0)
                break;

            if(list.get(0) > 0) {
                result += list.get(0);
                list.remove(0);

                if(list.size() != 0) {
                    list.remove(list.size() - 1);
                }
            } else {
                break;
            }
        }
        System.out.println(result);
    }
}
