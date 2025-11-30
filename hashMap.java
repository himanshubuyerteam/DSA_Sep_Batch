import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class hashMap {
    public static void runbasic()
    {
        HashMap<Integer,String>hm=new HashMap<>();
        hm.put(1,"ABC");
        hm.put(2,"DEF");
        hm.put(3,"LION");
        hm.put(2,"MNP");

        System.out.println(hm.get(1));
        System.out.println(hm.get(2));
        System.out.println(hm.get(3));

        // System.out.println(hm.get(5));
        // if(hm.containsKey(5))
        // {
        //     System.out.println("Key is present");
        // }
        // else
        // {
        //     System.out.println("Key is not present");
        // }
        String val = hm.getOrDefault(5,"0");
        System.out.println(val);
        int s = hm.size();

    }
    public static void rb2()
    {   
        int []arr = {1,2,3,4};
        for(int si=0;si<4;si++)
        {
            for(int ei=0;ei<4;ei++)
            {
                for(int i=si;i<=ei;i++)
                {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
        }
    }
    public boolean isZeroSumSubArray(int []arr)
    {
        HashMap<Integer,Boolean>sumToFreqMap = new HashMap<>();
        int sum=0;
        sumToFreqMap.put(0,true);
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(sumToFreqMap.containsKey(sum))
                return true;
            else
                sumToFreqMap.put(sum,true);
        }
        return false;
    }
    public int countOfZeroSumSubArray(int []arr)
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int sum=0;
        int count= 0;
        hm.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(hm.containsKey(sum))
            {
                count = count + hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            }
            else
            {
                hm.put(sum,1);
            }
        }
        return count;
    }
    public int longestZeroSumSubArray(int []arr)
    {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int sum=0 ;
        int ans=0;
        hm.put(0,-1);
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(hm.containsKey(sum))
            {
                int prevIdx = hm.get(sum);
                ans = Math.max(ans, i-prevIdx);
            }
            else
            {
                hm.put(sum,i);
            }
        }
        return ans;
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)
            pq.add(i);
        while(k>0)
        {
            pq.remove();
            k--;
        }
        return pq.peek();
    }
    class dataObj
    {
        int key;
        int freq;
        dataObj(int key,int freq)
        {
            this.key=key;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i:nums)
        {
            if(hm.containsKey(i))
                hm.put(i,hm.get(i)+1);
            else
                hm.put(i,1);
        }
        PriorityQueue<dataObj>pq=new PriorityQueue<>(
            (a,b)-> b.freq-a.freq
        );
        for(int i:hm.keySet())
        {
            dataObj d = new dataObj(i, hm.get(i));
            pq.add(d);
        }
        int []ans =new int [k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.remove().key;
        }
        return ans;        
    }
    public static void pqbasic()
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1);
        pq.add(1);
        pq.add(1);
        System.out.println(pq.peek()); //30
        System.out.println(pq.size()); //3
        System.out.println(pq.remove());//30
        System.out.println(pq.peek());//20


    }
    public static void main(String[] args) {
        // runbasic();
        // rb2();
        pqbasic();
    }
}
