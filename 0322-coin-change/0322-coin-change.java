
import java.util.*;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //초기 상태 추가: (남은 금액, 사용한 동전 수)
        queue.offer(new int[]{amount, 0});
        //현재 남은 금액을 visited에 추가 -> 중복 방문 방지
        visited.add(amount);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int remaining = cur[0];
            int numCoins = cur[1];

            //금액을 정확히 맞췄을 경우
            if (remaining == 0) {
                return numCoins;
            }

            //가능한 동전으로 다음 상태 탐색
            for (int coin : coins) {
                int next = remaining - coin;
                if (next >= 0 && !visited.contains(next)) {
                    queue.offer(new int[]{next, numCoins + 1});
                    visited.add(next);
                }
            }
        }
        //만들 수 없는 경우
        return -1;
    }
}
