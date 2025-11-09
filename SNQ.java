import java.util.*;
public class SNQ {

    public static boolean isDuplicate(String str)
    {
        Stack<Character>st=new Stack<>();
        boolean duplicate=false;
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);

            if(ch==')')
            {
                if(st.peek()=='(')
                {
                    duplicate=true;
                    break;
                }
                while(st.peek()!='(')
                {
                    st.pop();
                }
                st.pop();
            }
            else
            {
                st.push(ch);
            }
        }
        return duplicate;
    }
    public static boolean isValid(String str)
    {
        Stack<Character>st=new Stack<>();

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(ch=='('  || ch=='[' || ch=='{')
                st.push(ch);
            else
            {
                if(st.isEmpty())
                    return false;
                if(ch==']' && st.peek()!='[')
                    return false;
                if(ch=='}' && st.peek()!='{')
                    return false;
                if(ch==')' && st.peek()!='(')
                    return false;
                st.pop();
            }
        }
        if(st.size()==0)
            return true;
        else
            return false;
    }
    public static int [] NGOR_BruteForce(int []arr)
    {
        int []ans=new int[arr.length];

        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[j]>arr[i])
                {
                    ans[i]=arr[j];
                    break;
                }
            }
            if(ans[i]==0)
                ans[i]=-1;
        }
    }
    public static int [] NGOR_Stack(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans=new int[arr.length];
        ans[arr.length-1]=-1;
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--)
        {
            while(st.isEmpty() == false && st.peek()<=arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }
    public static int []swm_better(int []arr,int k)
    {
        int []ans=new int[arr.length-k+1];
        int []ngor=NGOR(arr);

        int j=0;
        for(int i=0;i<ans.length;i++)
        {
            if(j<i)
                j=i;
            while(ngor[j]<=i+k-1)
                j=ngor[j];
            ans[i]=arr[j];
        }
        return ans;
    }
    public static int [] NSOR_Stack(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans=new int[arr.length];
        ans[arr.length-1]=-1;
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--)
        {
            while(st.isEmpty() == false && st.peek()>=arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(arr[i]);
        }
        return ans;
    }

    public static int [] NSOL(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans=new int[arr.length];
        ans[arr.length-1]=-1;
        st.push(arr[arr.length-1]);
        for(int i=0;i<arr.length;i++)
        {
            while(st.isEmpty() == false && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=-1;
            else
                ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
    public static int [] NSOR(int []arr)
    {
        Stack<Integer>st=new Stack<>();
        int []ans=new int[arr.length];
        ans[arr.length-1]=-1;
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2;i<arr.length;i++)
        {
            while(st.isEmpty() == false && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.size()==0)
                ans[i]=arr.length+1;
            else
                ans[i]=st.peek();
            st.push(i);
        }
        return ans;
    }
    
    public static int maximumArea(int []arr)
    {
        int []nsol=NSOL(arr);
        int []nsor=NSOR(arr);
        int myans=0;
        for(int i=0;i<arr.length;i++)
        {
            int unit=nsor[i]-nsol[i]-1;

            int area=unit*arr[i];
            myans=Math.max(myans,area);
        }
        return myans;
    }
    public static int [] stockSpan(int []arr)
    {
        int []ans=new int[arr.length];
        int []NGOL=NGOL(arr);
        for(int i=0;i<arr.length;i++)
        {
            ans[i]=i-NGOL[i];
        }
        return ans;
    }
    public static int []swm(int []arr,int k)
    {
        int []ans=new int[arr.length-k+1];
        for(int i=0;i<arr.length-k+1;i++)
        {
            int max=arr[i];
            for(int j=i+1;j<i+k;j++)
            {
                max=Math.max(max,arr[j]);
            }
            ans[i]=max;
        }
    }
    public static void main(String[] args) {
        Stack<Integer>st=new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        // System.out.println(st);
        // System.out.println(st.size());
        // System.out.println(st.peek());
        // System.out.println(st.size());
        // System.out.println(st.pop());
        // System.out.println(st.size());
        // System.out.println(st.peek());

        // while(st.size()>0)
        while(st.isEmpty()==false)
        {
            System.out.println(st.pop());
        }





    }
}