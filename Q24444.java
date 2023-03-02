import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q24444 {
    static int N;
    static int M;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i <= N ; i++){
            v.add(new ArrayList<>());
        }

        for(int i = 0 ; i < M ;i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            v.get(from).add(to);
            v.get(to).add(from);
        }
        for(int i = 0 ; i <= N ;i++){
            Collections.sort(v.get(i));
        }
        bfs(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = cnt++;
        while (!q.isEmpty()){
            int temp = q.poll();
            for(Integer i : v.get(temp)){
                if(visited[i] == 0){
                    q.add(i);
                    visited[i] = cnt++;
                }
            }
        }
    }
}
