package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Belt> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n*2 ; i++) {
            list.add(new Belt(Integer.parseInt(st.nextToken()), false));
        }

        int level = 0;
        Queue<Integer> robotIdx = new LinkedList<>();
        while (true) {
            level++;

            //로봇과 벨트 회전
            Belt bb = list.get(n*2-1);
            list.remove(n*2-1);
            list.add(0, bb);

            int size = robotIdx.size();
            for(int i=0 ; i<size ; i++) {
                int idx = robotIdx.poll();
                robotIdx.add(idx+1);
            }

            //벨트 움직인 후 내리는 위치 체크
            size = robotIdx.size();
            for(int i=0 ; i<size ; i++) {
                int idx = robotIdx.poll();
                if(idx < n-1) {
                    robotIdx.add(idx);
                } else if(idx == n-1) {
                    Belt belt = list.get(idx);
                    list.remove(idx);
                    belt.setRobot(false);
                    list.add(idx, belt);
                }
            }
            //로봇 이동
            size = robotIdx.size();
            for(int i=0 ; i<size ; i++) {
                int idx = robotIdx.poll();
                if(list.get(idx+1).dur < 1 || list.get(idx+1).robot) {
                    robotIdx.add(idx);
                    continue;
                }

                Belt b1 = list.get(idx);
                list.remove(idx);
                b1.setRobot(false);
                list.add(idx, b1);

                Belt b2 = list.get(idx+1);
                list.remove(idx+1);
                b2.setRobot(true);
                b2.setDur(b2.dur - 1);
                list.add(idx+1, b2);

                robotIdx.add(idx+1);
            }
            //로봇이동 후 내리는 위치 체크
            size = robotIdx.size();
            for(int i=0 ; i<size ; i++) {
                int idx = robotIdx.poll();
                if(idx != n-1) {
                    robotIdx.add(idx);
                } else {
                    Belt belt = list.get(idx);
                    list.remove(idx);
                    belt.setRobot(false);
                    list.add(idx, belt);
                }
            }

            //로봇 올리기
            if(list.get(0).dur > 0) {
                Belt belt = list.get(0);
                list.remove(0);
                belt.setRobot(true);
                belt.setDur(belt.dur - 1);
                list.add(0, belt);
                robotIdx.add(0);
            }

            //내구도 체크
            int cnt = 0;
            for(Belt b : list) {
                if(b.dur == 0)
                    cnt++;
            }

            if(cnt >= k)
                break;

        }

        System.out.println(level);
    }
    static class Belt {;
        int dur;
        boolean robot;

        public Belt(int dur, boolean robot) {
            this.dur = dur;
            this.robot = robot;
        }

        public void setDur(int dur) {
            this.dur = dur;
        }

        public void setRobot(boolean robot) {
            this.robot = robot;
        }
    }
}
