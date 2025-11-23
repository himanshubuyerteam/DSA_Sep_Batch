import org.w3c.dom.Node;

public class BST_HEAP {
    public int size(Node root)
    {
        if(root==null)
            return 0;
        int left_size=size(root.left);
        int right_size=size(root.right);
        return left_size+right_size+1;
    }
    public int sum(Node root)
    {
        if(root==null)
            return 0;
        int left_sum=sum(root.left);
        int right_sum=sum(root.right);
        return left_sum+right_sum+root.val;
    }
    // O(N)- works in BST and BT
    public int maximum(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        int left_max=maximum(root.left);
        int right_max=maximum(root.right);
        return Math.max(root.val,Math.max(left_max,right_max));
    }
    //O(H)- BST
    public int maximum(Node root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root.val;
    }
    //Height In Terms Of Nodes
    public int height_node(Node root)
    {
        if(root==null)
            return 0;
        int left_height=height(root.left);
        int right_height=height(root.right);
        return 1+Math.max(left_height,right_height);
    }
    public int height_edge(Node root)
    {
        if(root==null)
            return -1;
        int left_height=height(root.left);
        int right_height=height(root.right);
        return 1+Math.max(left_height,right_height);
    }
    public boolean isPresent(Node root,int key)
    {
        if(root==null)
            return false;
        if(root.val==key)
            return true;
        if(root.val>key)
            return isPresent(root.left, key);
        else
            return isPresent(root.right, key);
    }
    public Node LCA_bst(Node root,Node n1,Node n2)
    {
        Node curr=root;
        while(curr!=null)
        {
            if(curr>n1.val && curr>n2.val)
                curr=curr.left;
            if(curr<n1.val && curr<n2.val)
                curr=curr.right;
            else
                return curr;
        }
        return null;
    }

    class dataObj
    {
        long min;
        long max;
        boolean isBst;
        dataObj(long min,long max,boolean isBst)
        {
            this.min=min;
            this.max=max;
            this.isBst=isBst;
        }
    }
    public dataObj isBsthelper(Node root)
    {
        if(root==null)
        {
            
            return dataObj(Long.Max_VALUE,Long.MIN_VALUE,true);
        }
        dataObj dataObj_left= isBsthelper(root.left);
        dataObj dataObj_right= isBsthelper(root.right);
        long min=Math.min(root.val,Math.min(dataObj_left.min,dataObj_right.min));
        long max=Math.max(root.val,Math.max(dataObj_right.max,dataObj_left.max));
        boolean c1=dataObj_left.max<root.val;
        boolean c2=dataObj_right.min>root.val;
        boolean c3= dataObj_right.isBST && dataObj_left.isBST
        boolean myiBST= c1 && c2 && c3;
        dataObj myans= dataObj(min,max,myiBST);
        return myans;
    }
    public boolean isBST(Node root)
    {
        dataObj ans= isBsthelper(root);
        return ans.isBST;
    }
    
    
    public Node deleteFromBST(Node root,int key)
    {
        if(root==null)
            return null;
        if(root.val>key)
        {
            Node lans=deleteFromBST(root.left,key);
            root.left=lans;
            
        }
        if(root.val<key)
        {
            Node rans=deleteFromBST(root.right,key);
            root.right=rans;
        }
        if(root.val==key)
        {
            //c1- right,left both null
            //c2 - anyone is null
            //c3- both are notNull
            if(root.left==null || root.right==null)
            {
                return root.left==null?root.right:root.left;
            }
            Node replaceNode = maximumInLeft(root.left);
            root.val=replaceNode.val;
            root.left=deleteFromBST(root.left,replaceNode.val);
        }
        return root;
    }

}
