class Solution {
    class Edge implements Comparable<Edge> {
        int node;
        int cost;
        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        // 그래프 변환 (인접리스트로)
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            System.out.println(Arrays.toString(time));
            // u: 시작노드, v: 도착노드, w: 가중치
            // u -> v, weight
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Edge(v, w));
        }

        // 다익스트라 알고리즘
            // k -> 각 노드 최소 비용
        int INF = Integer.MAX_VALUE;
        int[] dists = new int[n+1];
        Arrays.fill(dists, INF);

        // 초기값 넣기
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(k, 0));
        dists[k] = 0;
        while(!pq.isEmpty()) {
            // 방문
            Edge cur = pq.poll();

            // 예약
            for (Edge next : graph.get(cur.node)) {
                /** int nextDist = cur.node 통해서 가는 비용
                *   if (dists[next.node] > cur.node 통해서 가는 비용) 교체
                *   if (dists[next.node] > cur.node 통해서 가는 비용) {
                *       int nextDist = cur.node 통해서 가는 비용
                *      pq.offer(Edge())
                *         dists[next.node] = cur.node 통해서 가는 비용    
                *   }
                */

                int nextDist = dists[cur.node] + next.cost;
                if (dists[next.node] > nextDist) {
                    pq.offer(new Edge(next.node, nextDist));
                    dists[next.node] = nextDist;
                }
            }
        }

        // 최소 비용들 중에서 가장 큰 값 찾아서 return 하기
        // 만약 도달 못 한 노드가 하나라도 있으면 '-1' return

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            maxTime = Math.max(maxTime, dists[i]);
        }

        // 도달할 수 없는 노드 O
        return (maxTime == INF) ? -1 : maxTime;
    }
}