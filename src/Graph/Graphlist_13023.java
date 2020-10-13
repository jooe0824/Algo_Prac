package Graph;

import java.util.*;
class Edge {
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    } //간선 만들기
}
public class Graphlist_13023{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] a = new boolean[n][n]; //간선 존재 유무 파악
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n]; //동적 할당 가능

        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i=0; i<n; i++) { //정점 갯수만큼 arraylist 동적생성
            g[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from)); //방향성 없는 간선이므로 양방향 모두 추가
            a[from][to] = a[to][from] = true; //간선 있으면 true
            g[from].add(to); //ex.g[0]에 2추가하기
            g[to].add(from); //ex. g[2]에 0추가하기
        }

        m *= 2;

        for  (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;
                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    continue;
                }
                if (!a[B][C]) continue;
                for (int E : g[D]) {
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}