class Solution {
    class Edge implements Comparable<Edge>{
        int node;
        double prob;
        Edge(int node, double prob){
            this.node = node;
            this.prob = prob;
        }
        @Override
        public int compareTo(Edge o){
            return Double.compare(o.prob,this.prob);
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 그래프 변환 (인접리스트)
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));
        }
        // 다익스트라 알고리즘
        // 초기값 세팅
        double[] dists = new double[n];
        Arrays.fill(dists, 0);
        
        // start_node 예약하기
        Queue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start_node, 1));
        dists[start_node] = 1;

        while(!pq.isEmpty()){
            // 방문
            Edge cur = pq.poll();
            // 예약
            for(Edge next: graph.get(cur.node)){
                // 지금 노드에서 다음 노드로 갔을 때의 확률
                //   = 현재 노드까지 오는 최대 확률 X 다음 노드로 가는 확률
                double nextDist = dists[cur.node] * next.prob;
                
                if(nextDist > dists[next.node]){
                    // pq.offer(new Edge(next.node, 다음 노드까지의 확률));
                    // dists[next.node] = 다음 노드까지의 확률
                    pq.offer(new Edge(next.node, nextDist));
                    dists[next.node] = nextDist;
                } 
            }
        }
        return dists[end_node];
    }
}