import java.util.ArrayList;

public class backtracking {
    public void helper(int sr,int sc,int dr,int dc,String cans,
                            ArrayList<String>pans,int [][]arr)
    {
        if(sr>arr.length || sc>arr[0].length || sr<0 || sc<0 || arr[sr][sc]==0)
            return;
        // if(arr[sr][sc]==0 || sr>arr.length || sc>arr[0].length || sr<0 || sc<0)
        //     return;
        if(sr==dr && dc==sc)
        {
            pans.add(cans);
            return;
        }
        //MARK VISITED
        arr[sr][sc]=0;
        // RECCALL
        helper(sr-1,sc, dr, dc, cans+"U", pans, arr);
        helper(sr, sc+1, dr, dc, cans+"R", pans, arr);
        helper(sr+1, sc, dr, dc, cans+"D", pans, arr);
        helper(sr, sc-1, dr, dc, cans+"L", pans, arr);
        //UNMARCK
        arr[sr][sc]=1;
    }
    public ArrayList<String>RatInMaze(int [][]arr)
    {
        int n=arr.length;
        ArrayList<String>ans=new ArrayList<>();
        int sr=0;
        int sc=0;
        int dr=n-1;
        int dc=n-1;
        helper(sr,sc,dr,dc,"",ans,arr);
        return ans;
    }
    public boolean isPossible (int totalNofQueen,char[][]arr,int row,int col)
    {
        for(int i=0;i<row;i++)
        {
            if(arr[i][col]=='Q')
                return false;
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0 ;i--,j--)
        {
            if(arr[i][j]=='Q')
                return false;
        }
        for(int i=row-1,j=col+1;i>=0 && j<arr.length;i--,j++)
        {
            if(arr[i][j]=='Q')
                return false;
        }

        return true;
    }
    public void helperQueen(int totalNofQueen,char[][]arr,
                                List<List<String>>ans,int row)
    {
        if(totalNofQueen == row)
        {
            List<String>smallans=new ArrayList<>();
            for(char []a:arr)
            {
                smallans.add(new String(a));
            }
            ans.add(smallans);
            return;
        }
        for(int col = 0 ;col<totalNofQueen;col++)
        {
            if(isPossible(totalNofQueen,arr,row,col))
            {
                arr[row][col]='Q';
                helperQueen(totalNofQueen, arr, ans, row+1);
                arr[row][col]='.';
            }
        }
    }
    public List<List<String>>nQueen(int n)
    {
        List<List<String>>arr=new ArrayList<>();
        char [][]ans=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans[i][j]='.';
            }
        }
        helperQueen(n,ans,arr,0);
        return arr;

    }
    public void helperPermutation(StringBuilder str,int idx,List<String>ans)
    {
        if(idx==str.length())
        {
            ans.add(str.toString());
            return;
        }
        for(int i=idx;i<str.length();i++)
        {
            swap(str,i,idx);
            helperPermutation(str, idx+1, ans);
            swap(str,i,idx);
        }
    }
    public void swap(StringBuilder str,int i,int j)
    {
        char temp=str.charAt(i);
        str.setCharAt(i,str.charAt(j));
        str.setCharAt(j,temp);
    }
    public List<String>permutation(String str)
    {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder(str)
        helperPermutation(sb,0,ans);
        return ans;
    }
}
