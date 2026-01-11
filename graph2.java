import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class graph2 {
    
    boolean dfs_cycle_undirected(int src,int par,boolean []vis,ArrayList<Integer>[]graph)
    {
        vis[src]=true;
        for(int nbr:graph[src])
        {
            if(nbr==par)
                continue;
            if(vis[nbr]==true)
                return true;
            dfs(nbr,src,vis,graph);
        }
    }
    class pair
    {
        int node;
        int par;
    }
    boolean bfs_cycle_undirected(int src,ArrayList<Integer>[]graph)
    {
        ArrayList<pair>q=new ArrayList<>();
        pair p =new pair(src,-1);
        q.add(p);
        while(q.size()>0)
        {
            pair fnt=q.remove();
            vis[fnt.node]=true;
            for(int nbr:graph[fnt.node])
            {
                if(nbr==fnt.par)
                    continue;
                if(vis[nbr]==true)
                    return true;
                pair p1=new pair(nbr,fnt.node);
                q.add(p1);
            }
        }
        return false;
    }


static class Pair {
        int node, dist;
        Pair(int n, int d) {
            node = n;
            dist = d;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;

            // Skip if already finalized
            if (visited[node]) continue;

            visited[node] = true;

            for (Pair nei : adj.get(node)) {
                int next = nei.node;
                int wt = nei.dist;

                if (!visited[next] && dist[node] + wt < dist[next]) {
                    dist[next] = dist[node] + wt;
                    pq.add(new Pair(next, dist[next]));
                }
            }
        }
        return dist;
    }


}
