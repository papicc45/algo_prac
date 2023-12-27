package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Flower> flowers = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay));
        }

        Collections.sort(flowers);

        int min = 301;
        int max = 1201;
        int index = 0;
        int cnt = 0;
        int feature = 0;
        while(min < max) {

            boolean check = false;
            for(int i =index ; i<n ; i++) {
                Flower temp = flowers.get(i);
                if(temp.startDay > min)
                    break;

                if(temp.endDay > feature) {
                    check = true;
                    feature = temp.endDay;
                    index = i + 1;
                }
            }

            if(check) {
                min = feature;
                cnt++;
            } else {
                break;
            }
        }

        if(feature < max) {
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }
    }
}

class Flower implements Comparable<Flower> {
    int startDay;
    int endDay;

    Flower(int startDay, int endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }

    @Override
    public int compareTo(Flower o) {
        if(this.startDay == o.startDay) {
            if(this.endDay == o.endDay) {
                return 0;
            } else {
                return o.endDay - this.endDay;
            }
        } else {
            return this.startDay - o.startDay;
        }
    }
}
