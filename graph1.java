import java.util.Queue;

import javax.management.Query;

public class graph1 {
    public void bfs(int src,ArrayList<Interger>[]adj)
    {
        Queue<Integer>q=new Queue();
        boolean []vis=new boolean[n];
        q.add(src);
        vis[src]=true;

        while(q.size()>0)
        {
            int curr=q.remove();
            System.out.println(curr);
            for(int nbr:adj.get(curr))
            {
                if(vis[nbr]==false)
                {
                    q.add(nbr);
                    vis[nbr]=true;
                }
            }
        }
    }
    public void dfs(int noOfNodes)
    {
        boolean []vis=new boolean[noOfNodes];
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==false)
                dfs(i,vis,adj);
        }
    }
    void dfs(int src,boolean []vis,ArrayList<Interger>[]adj)
    {
        vis[src]=true;
        System.out.println(src);

        for(int nbr:adj.get(src))
        {
            if(vis[nbr]==false)
                dfs(nbr,vis,adj);
        }
    }


    int gcc(ArrayList<Integer>[]graph,int noOfNodes)
    {
        boolean []vis=new boolean[noOfNodes];
        int component=0;
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==false)
            {
                component++;
                dfs(i,vis,graph);
            }
        }
    }
    class data
    {
        int i;
        int j;
        int t;
        data(int i,int j,int t)
        {
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public int rottenOrgane(int [][]arr)
    {
        int fc=0;
        Queue<data>q=new Queue<>();
        boolean [][]vis=new boolean[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==2){
                    q.add(new data(i,j,0));
                    vis[i][j]=true;
                }
                else if(arr[i][j]==1){
                    fc++;
                }
            }
        }

        if(fc==0)
            return 0;
        int time=0;
        int [][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        // RM*WA*

        while(q.size()>0)
        {
            data fnt=q.remove();
            time=Math.max(time,fnt.t);
            for(int []d:dir)
            {
                int nr=fnt.i+d[0];
                int nc=fnt.j+d[1];
                if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && arr[nr][nc]==1 && vis[nr][nc]==false){
                    q.add(new data(nr,nc,fnt.t+1));
                    fc--;
                    vis[nr][nc]=true;
                }
            }

        }
        if(fc!=0)
            return -1;
        else
            return time;
    }
}
