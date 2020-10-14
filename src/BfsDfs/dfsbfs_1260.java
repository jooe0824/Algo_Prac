package BfsDfs;

import java.util.*;

public class dfsbfs_1260 {
    static ArrayList<Integer>[] a;
    /* 정점 a[i]가 연결되어 있는 정점을 배열에 나타낸 것
    ex. 1과2가 연결되어 있다면 a[1]=2,a[2]=1이 저장된다*/
    static boolean[] c; //방문한 적이 있는건지 체크하는 배열

    public static void dfs(int x){
        if(c[x]){
            return; //이미 방문했던 곳이라면 return
        }
        c[x] = true; //방문한 곳은 true로
        System.out.print(x+" ");
        for(int y : a[x]){ //a[x]의 모든 원소에 대해서 불러오기 y로
            if(!c[y]){
                dfs(y);
            }
        }
    }
    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(x); //start부터 큐에 넣기
        c[x] = true; //방문한 곳은 true로
        while (!q.isEmpty()){ //q가 비어있지 않는 동안
            int y = q.remove(); //q에서 하나 빼기
            System.out.print(y+" ");
            for(int z : a[y]){ //q에서 뺀 애에서 부터 !!!!!
                if(!c[z]){ //c[z] 처음 가본 곳이라면
                    c[z] = true; //true로 바꾸고
                    q.add(z); //큐에 넣기
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[n+1];

        for(int i =0; i<=n; i++){
            a[i] = new ArrayList<Integer>();
        }//정점의 갯수만큼 arraylist 생성

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }//연결된 간선 갯수만큼 돌며 a[]배열에 값 추가, 방향성이 없으니 양방향 추가

        for (int i=0; i<=n; i++){
            Collections.sort(a[i]);
        }//배열 내부 정렬은 Collections.sort,, Arrays.sort는 배열 자체 정렬
        c = new boolean[n+1];
        dfs(start); //시작점으로 깊이 우선 탐색 시작
        System.out.println();
        c = new boolean[n+1];
        bfs(start); //시작점으로 너비 우선 탐색 시작
        System.out.println();
    }
}
