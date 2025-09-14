import java.util.*;
public class sortingAlgo {
    public static void bubbleSort()
    {
        int arr[]={5,9,8,2,1};
        System.out.println("BEFORE"+Arrays.toString(arr));

        int noOfElement= arr.length;
        boolean swapped;
        for(int itr=1;itr<=noOfElement-1;itr++)
        {
            swapped=false;
            for(int j=0;j<noOfElement-itr;j++)
            {
                if(arr[j]>arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped=true;
                }
            }
            if(swapped==false)
                break;

        }
        System.out.println("AFTER"+Arrays.toString(arr));
    }

    public static void selectionSort()
    {
        int arr[]={5,9,8,2,1};
        System.out.println("BEFORE"+Arrays.toString(arr));
        int noOfElement=arr.length;
        for(int i=0;i<noOfElement-1;i++)
        {
            int midx=i;
            for(int j=i+1;j<noOfElement;j++)
            {
                if(arr[j]<arr[midx])
                    midx=j;
            }
            int temp=arr[i];
            arr[i]=arr[midx];
            arr[midx]=temp;
        }
        System.out.println("AFTER"+Arrays.toString(arr));

    }

    public static void insertionSort()
    {
        int arr[]={2,9,5,1,3};
        System.out.println("BEFORE"+Arrays.toString(arr));
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            int ele=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>ele)
            {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=ele;
        }
    }
    public static void main(String[] args) {
        // bubbleSort();
        // selectionSort();
        insertionSort();
        
    }
}
