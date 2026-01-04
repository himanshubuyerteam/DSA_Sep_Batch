import java.util.ArrayList;
import java.util.Arrays;

public class greedy {
    //leetcode 455
    public int assignCookie(int []g,int []c)
    {
        Arrays.sort(g);
        Arrays.sort(c);
        int hs=0;
        int gidx=g.length-1;
        int cidx=c.length-1;
        while(gidx>=0 && cidx>=0)
        {
            if(g[gidx]<=c[cidx])
            {
                hs++;
                gidx--;
                cidx--;
            }
            else
            {
                gidx--;
            }
        }
        return hs;
    }

    public boolean meetingRoom1(int [][]meetings)
    {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);  

        for(int i = 1;i<meetings.length;i++)
        {
            if(meetings[i][0]<meetings[i-1][1])
                return false;
        }
        return true;
    }

    public int meetingRoom2(int []st,int []et)
    {
        Arrays.sort(st);
        Arrays.sort(et);   
        int rooms_count=0;
        int max_rooms=0;
        int i=0;
        int j=0;
        while(i<st.length)
        {
            if(st[i]<et[j])
            {
                rooms_count++;
                max_rooms=Math.max(rooms_count,max_rooms);
                i++;
            }
            else// st>et
            {
                rooms_count--;
                j++;
            }
        }
        return max_rooms;

    }
    public int platform(int []arrt,int []dept)
    {
        Arrays.sort(arrt);
        Arrays.sort(dept);   
        int platform_occuiped=0;
        int max_platform=0;
        int i=0;
        int j=0;
        while(i<arrt.length)
        {
            if(arrt[i]<dept[j])
            {
                platform_occuiped++;
                max_platform=Math.max(max_platform,platform_occuiped);
                i++;
            }
            else// st>et
            {
                platform_occuiped--;
                j++;
            }
        }
        return max_platform;
    }


    public int[][] merge(int [][]arr)
    {
        //Sort on Start Time
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);  

        // ArrayList<Integer>al=new ArrayList<>();
        ArrayList<int[]>al=new ArrayList<>();

        for(int []ci:arr)
        {
            if(al.size()==0)
                al.add(ci);
            else
            {
                int []li = al.get(al.size()-1);
                if(ci[0]>li[1])
                    al.add(ci);
                else
                {
                    li[1]=Math.max(li[1],ci[1]);
                }
            }
        }
        return al.toArray(new int[al.size()][]);
    }

    public boolean jumpGame(int []arr)
    {
        int maxReach = 0;

        for(int i=0;i<arr.length;i++)
        {
            if(i>maxReach)
                return false;
            maxReach = Math.max(maxReach , arr[i]+i);
            if(maxReach == arr.length-1)
                return true;
        }
        return true;
    }

    public int jumpgame2(int []arr)
    {
        int jump = 0;
        int maxReach =0;
        int currReach =0;

        for(int i=0;i<arr.length;i++)
        {
            maxReach = Math.max(maxReach , arr[i]+i);

            if(i == currReach)
            {
                jump++;
                currReach  = maxReach
            }
        }
    }
}
