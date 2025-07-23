package datastructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_21944 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        TreeSet<Problem> all = new TreeSet<>();
        HashMap<Integer, TreeSet<Problem>> byGroup = new HashMap<>();
        HashMap<Integer, Problem> byNumber = new HashMap<>();

        StringTokenizer st;
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(p, l, g);
            all.add(problem);
            byGroup.computeIfAbsent(g, k -> new TreeSet<>()).add(problem);
            byNumber.put(p, problem);
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());

                Problem problem = new Problem(p, l, g);
                all.add(problem);
                byGroup.computeIfAbsent(g, k -> new TreeSet<>()).add(problem);
                byNumber.put(p, problem);
            } else if(command.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                TreeSet<Problem> set = byGroup.get(g);
                if(set == null || set.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }

                if(x == 1) sb.append(set.last().num).append("\n");
                else sb.append(set.first().num).append("\n");

            } else if(command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());

                if(all.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }

                if(x == 1) sb.append(all.last().num).append("\n");
                else sb.append(all.first().num).append("\n");

            } else if(command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                if(all.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }

                if (x == 1) {
                    // level >= L 중 가장 쉬운(레벨/아이디 가장 작은)
                    Problem dummy = new Problem(-1, l, -1);
                    Problem cand = all.ceiling(dummy);
                    sb.append(cand == null ? -1 : cand.num).append("\n");
                } else {
                    // level <= L 중 가장 어려운(레벨/아이디 가장 큰)
                    Problem dummy = new Problem(Integer.MAX_VALUE, l, -1);
                    Problem cand = all.floor(dummy);
                    sb.append(cand == null ? -1 : cand.num).append("\n");
                }
            } else if(command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                Problem problem = byNumber.remove(p);
                if(problem != null) {
                    all.remove(problem);
                    TreeSet<Problem> set = byGroup.get(problem.group);
                    if(set != null) {
                        set.remove(problem);
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
    static class Problem implements Comparable<Problem> {
        int num;
        int level;
        int group;

        public Problem(int num, int level, int group) {
            this.num = num;
            this.level = level;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.level == o.level) {
                return this.num - o.num;
            } else {
                return this.level - o.level;
            }
        }
    }
}
