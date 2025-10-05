public class BinarySeach {
    public boolean linearSearch(int []arr,int key)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==key)
                return true;
        }
        return false;
    }

    public boolean binarySearch(int []arr,int key)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
                return true;
            else if(arr[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        return false;
    }

    public int binarySearch_idx(int []arr,int key)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
                return mid;
            else if(arr[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
    public int firstOccurance(int []arr,int key)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
            {
                if(mid==0 || arr[mid-1]!=key)
                    return mid;
                else
                    end=mid-1;
            }
            else if(arr[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
    public int lastOccurance(int []arr,int key)
    {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==key)
            {
                if(mid==arr.length-1 || arr[mid+1]!=key)
                    return mid;
                else
                    start=mid+1;
            }
            else if(arr[mid]>key)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }

    public int countOccurance(int []arr,int key)
    {
        int fi=firstOccurance(arr,key);
        if(fi==-1)
            return 0;
        int li=lastOccurance(arr,key);
        return li-fi+1;
    }

    public int minimumRSA(int []arr)
    {
        int s=0;
        int e=arr.length-1;
        while(s<e)
        {
            int m=(s+e)/2;
            int me=arr[m];
            if(me>arr[e])
                s=m+1;
            else
                e=m;
        }
        return arr[e];
    }
    public int noOfRotation(int []arr)
    {
        int s=0;
        int e=arr.length-1;
        while(s<e)
        {
            int m=(s+e)/2;
            int me=arr[m];
            if(me>arr[e])
                s=m+1;
            else
                e=m;
        }
        return e;
    }

    public int searchInRSA(int []arr,int key)
    {
        int minIdx= noOfRotation(arr);
        int bsAns= binarySearch(arr,0,minIdx-1, key);
        if(bsAns==-1)
            return binarySearch(arr,minIdx,arr.length-1,key);
        return bsAns;
    }

    public boolean isPossibleToEat(int []arr,int time,int speed)
    {
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            sum+= Math.ceil(arr[i]/(speed*1.0));
            if(sum>time)
                return false;
        }
        if(sum<=time)
            return true;
        return false;
    }
    public int koko(int []arr,int hr)
    {
        int s=1;
        int e=arr[0];
        for(int i:arr)
            e=Math.max(i,e);
        while(s<e)
        {
            int m=(s+e)/2;
            if(isPossibleToEat(arr,hr,m)==true)
                e=m;
            else
                s=m+1;
        }
        return s;
        
    }
}
