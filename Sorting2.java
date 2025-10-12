// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static int [] merge2SortedArrays(int []arr1,int []arr2)
    {
        int size1=arr1.length;
        int size2=arr2.length;
        int []ans=new int[size1+size2];
        int i=0;int j=0;int k=0;
        while(i<size1 && j<size2)
        {
            if(arr1[i]>arr2[j])
            {    
                ans[k]=arr2[j];
                k++;
                j++;
            }
            else
                ans[k++]=arr1[i++];
        }
        while(i<size1)
        {
            ans[k++]=arr1[i++];
        }
        while(j<size2)
        {
            ans[k++]=arr2[j++];
        }
        return ans;
    }
    public static  int[] mergeSortHelper(int []arr,int start,int end)
    {
        if(start==end)
        {
            return new int []{arr[start]};
        }
        int midIdx= (start+end)/2;
        int []lsa=mergeSortHelper(arr,start,midIdx);
        int []rsa=mergeSortHelper(arr,midIdx+1, end);

        int []fsa = merge2SortedArrays(lsa, rsa);
        return fsa;
    }
    public static int [] mergeSort(int []arr)
    {
        return mergeSortHelper(arr,0,arr.length-1);
    }
    
    public static int partation(int []arr,int s,int e,int pivotElement)
    {
        
        int i=s;int j=s;
        while(i<=e)
        {
            if(arr[i]<=pivotElement)
            {
                swap(arr,i,j);
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j-1;
    }
    public static void swap(int []arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void quickSortHelper(int []arr,int s,int e)
    {
        if(s>e)
            return;
        int pe=arr[e];
        int pivotIdx=partation(arr,s,e,pe);
        quickSortHelper(arr,s,pivotIdx-1);
        quickSortHelper(arr,pivotIdx+1,e);
        
    }
    public static void quickSort(int []arr)
    {
        quickSortHelper(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int []arr={0,7,2,15,1,9,6,3};
        // quickSort(arr);
        int []sa=mergeSort(arr);
        for(int i:sa)
            System.out.print(i+" ");
    }
    
    
    
    public static int longestSubString(String str)
    {
        int []freq=new int[26];
        int j=0;
        int i=0;
        int counter=0;// no of duplicate in my window
        int ans=0;
        int n=str.length();
        
        while(i<n)
        {
            char ch=str.charAt(i);
            freq[ch-'a']++;
            if(freq[ch]>1)
                counter++;
            i++;
            while(counter>0)
            {
                char ch1=str.charAt(j);
                if(freq[ch1]==2)
                    counter--;-
                freq[ch1]--;
                j++;
            }
            ans=Math.max(ans,i-j);
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}