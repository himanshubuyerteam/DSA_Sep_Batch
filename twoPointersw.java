import java.util.Arrays;

public class twoPointersw {
    public static void sort01(int []arr)
    {
        int i=0;
        int j=0;
        while(i<arr.length)
        {
            if(arr[i]==0)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
    }
    public static void sort012(int []arr)
    {
        int i=0;
        int j=0;
        int k=arr.length-1;
        while(i<k)
        {
            if(arr[i]==0)
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
            else if(arr[i]==1)
            {
                i++;
            }
            else
            {
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
                k--;
            }
        }
    }
    public int maxArea(int[] arr) {
        int maxwater=0;
        int l=0;
        int r=arr.length-1;
        while(l<r)
        {
            int cwater=Math.min(arr[l],arr[r])*(r-l);
            maxwater=Math.max(cwater,maxwater);
            if(arr[l]>arr[r])
                r--;
            else
                l++;
        }
        return maxwater;

    }

    public int[] twoSum(int[] arr, int tar) {
        int l=0;
        int r=arr.length-1;
        int []res=new int[2];
        while(l<r)
        {
            int csum=arr[l]+arr[r];
            if(csum==tar)
            {
                res[0]=l+1;
                res[1]=r+1;
                break;
            }
            else if(csum>tar)
                r--;
            else
                l++;
        }
        return res;
    }

    public static void main(String[] args) {
        int []arr={0,0,1,1,0,1,0,1,0,1,0,0,1,0,1,0};
        System.out.println("BEFORE"+Arrays.toString(arr));
        sort01(arr);
        System.out.println("AFTER"+Arrays.toString(arr));

    }
}
