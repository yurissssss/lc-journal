//DFS
import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //각 방의 방문 여부를 기록할 리스트 선언
        boolean[] visited = new boolean[rooms.size()];
        bfs(rooms, visited, 0);
        for (int i=0; i<visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public void bfs(List<List<Integer>> rooms, boolean[] visited, int start) {
        //다음에 방문할 방을 기록할 큐 선언
        Queue<Integer> queue = new LinkedList();
        //큐에 시작할 방 입력
        queue.offer(start);
        visited[start] = true;  //방문 처리

        while(!queue.isEmpty()) {
            //현재 방문한 방 확인
            int curVertex = queue.poll();
            //현재 방에 있는 열쇠 확인 - 현재 노드와 연결된 모든 인접 노드 반환
            for (Integer nextVertex : rooms.get(curVertex)) {
                //열쇠가 갈 수 있는 방의 방문 여부 확인
                if (!visited[nextVertex]) {
                    queue.offer(nextVertex);  //큐에 입력
                    visited[nextVertex] = true;  //방문 처리
                }
            }
        }
    }
}