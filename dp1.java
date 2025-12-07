class dp1{
    public static int fib_rec(int n)
    {
        if(n==0 || n==1)
            return n;
        System.out.println("CALCULATION FIB of n="+n);
        int ra1=fib_rec(n-1);
        int ra2=fib_rec(n-2);
        return ra1+ra2;
    }

    //Way1 - memoization
    // o(n) and o(n) for TC and SC
    public static int fib_memo(int n,int []arr)
    {
        if(n==0 || n==1)
            return n;
        if(arr[n]!=-1)// already calcualted
            return arr[n];
        System.out.println("CALCULATION FIB of n="+n);
        int ra1=fib_memo(n-1,arr);
        int ra2=fib_memo(n-2,arr);
        arr[n]=ra1+ra2;
        return ra1+ra2;
    }
    public static int fib_tab(int n)
    {
        int []arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=arr.length;i++)
            arr[i]=arr[i-1]+arr[i-2];
        return arr[n];
    }

    public static int maze_rec(int sr,int sc,int dr,int dc)
    {
        if(sr == dr && sc ==dc)
            return 1;
        if(sr>dr || sc>dc)
            return 0;
        int ra1= maze_rec(sr+1, sc, dr, dc);
        int ra2= maze_rec(sr, sc+1, dr, dc);
        int ans= ra1+ra2;
        return ans;
    }

    public static int maze_memo(int sr,int sc,int dr,int dc,int [][]arr)
    {
        if(sr == dr && sc ==dc)
            return 1;
        if(sr>dr || sc>dc)
            return 0;
        if(arr[sr][sc]!=-1)
            return arr[sr][sc];
        int ra1= maze_rec(sr+1, sc, dr, dc);
        int ra2= maze_rec(sr, sc+1, dr, dc);
        int ans= ra1+ra2;
        arr[sr][sc]=ans;
        return ans;
    }

    public static int mazepath_tab(int n,int m)
    {
        int [][]dp=new int[n][m];
        for(int i=0;i<n;i++)
            dp[i][m-1]=1;

        for(int i=0;i<m;i++)
            dp[n-1][i]=1;


        for(int i=n-2;i>=0;i--)
        {
            for(int j=m-2;j>=0;j--)
            {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }

        return dp[0][0];
    }

    public static int minCost_rec(int [][]arr,int sr,int sc,int dr,int dc)
    {
        if(sr==dr && sc ==dc)
            return arr[sr][sc];
        if(sr>dr || sc>dc)
            return Integer.MAX_VALUE;
        int ra1=minCost_rec(arr, sr+1, sc,dr,dc);
        int ra2=minCost_rec(arr, sr, sc+1,dr,dc);
        int mycost= Math.min(ra1, ra2)+arr[sr][sc];
        return mycost;
    }

    public static int minCost_rec_memo(int [][]arr,int sr,int sc,int dr,int dc,int [][]dp)
    {
        if(sr==dr && sc ==dc)
            return arr[sr][sc];
        if(sr>dr || sc>dc)
            return Integer.MAX_VALUE;
        if(dp[sr][sc]!=-1)
            return dp[sr][sc];
        int ra1=minCost_rec(arr, sr+1, sc,dr,dc);
        int ra2=minCost_rec(arr, sr, sc+1,dr,dc);
        int mycost= Math.min(ra1, ra2)+arr[sr][sc];
        dp[sr][sc]=mycost;
        return mycost;
    }

    public static int mincost_tab(int [][]arr,int sr,int sc)
    {
        int n=arr.length;
        int m=arr[0].length;
        int [][]dp=new int[n][m];

        for(int i=dp.length-1;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                if(i==dp.length-1 && j==dp[0].length-1)
                    dp[i][j]=arr[i][j];  ///corner case
                else if(i==dp.length-1)  //last row
                    dp[i][j]=arr[i][j]+dp[i][j+1];
                else if(j==dp[0].length-1)
                    dp[i][j]=arr[i][j]+dp[i+1][j];
                else
                {
                    int op1=dp[i+1][j];
                    int op2=dp[i][j+1];
                    dp[i][j]=Math.min(op1,op2)+arr[i][j];
                }
            }
        }
        return dp[0][0];


    }
    public static void main(String[] args) 
    {
        int n=7;
        // System.err.println(fib_rec(n));   
        int []arr=new int[8];
        for(int i=0;i<8;i++)
            arr[i]=-1;
        System.out.println(fib_memo(n,arr)); 
    }
}