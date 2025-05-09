//DFS
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    //각 방의 방문 여부를 저장할 배열 (인덱스 = 방 번호)
    static boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
				//각 방의 방문 여부를 기록할 리스트를 선언한다.
				// 기본값: false - 아직 아무 방도 방문하지 않은 상태
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);  //0번 방부터 탐색 시작

        //모든 방을 순회하면서 방문하지 못한 방이 있는지 확인
        for (int i = 0; i < visited.length; i++) {
            //방문하지 못 한 방이 있다면
            if (!visited[i]) {
                return false; 
            }
        }
        //모든 방을 방문했다면 true 반환
        return true;
    }

		//dfs함수
    public void dfs(List<List<Integer>> rooms, int v) {
				//현재 방문한 방(v) 방문 처리
        visited[v] = true;
				//현재 방에 있는 열쇠 확인
        for (Integer nextVertex : rooms.get(v)) {
						//열쇠로 열 수 있는 방이 아직 방문되지 않았다면
            if (visited[nextVertex] == false) {
								//그 방으로 이동, 탐색 (재귀 함수)
                dfs(rooms, nextVertex);
            }
        }
    }
}