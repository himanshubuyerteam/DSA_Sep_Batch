import java.util.ArrayList;
import java.util.Queue;

import org.w3c.dom.Node;

public class BinaryTree {
    public int size(Node root)
    {
        if(root==null)
            return 0;
        int ls=size(root.left);
        int rs=size(root.right);
        return ls+rs+1;
    }
    public int sum(Node root)
    {
        if(root==null)
            return 0;
        int ls=sum(root.left);
        int rs=sum(root.right);
        return ls+rs+root.val;
    }
    public int max(Node root)
    {
        if(root==null)
            return Integer.MIN_VALUE;
        int lm=max(root.left);
        int rm=max(root.right);
        return Math.max(lm,Math.max(rm,root.val));
    }
    public boolean isPresent(Node root,int key)
    {
        if(root==null)
            return false;
        if(key==root.val)
            return true;
        boolean lans= isPresent(root.left,key);
        boolean rans= isPresent(root.right,key);
        return lans || rans;
    }

    public boolean RootToNodePath(Node root,int key,ArrayList<Node>path)
    {
        if(root==null)
            return false;
        if(key==root.val)
        {
            path.add(root);
            return true;
        }
        boolean lans= isPresent(root.left,key);
        boolean rans= isPresent(root.right,key);
        if(lans || rans)
        {
            path.add(root);
        }
        return lans || rans;
    }

    Node LCA(Node root,Node n1,Node n2)
    {
        ArrayList<Node> p1=new ArrayList<>();
        ArrayList<Node> p2=new ArrayList<>();
        RootToNodePath(root,n1.val,p1);
        RootToNodePath(root, n2.val, p2);

        Node LCA=null;
        int i=p1.size();
        int j=p2.size();
        while(i>=0 && j>=0)
        {
            if(p1.get(i).val == p2.get(j).val)
            {
                i--;
                j--;
            }
            else
            {
                lca=p1.get(i+1);
                break;
            }
        }
        return LCA;
    }

    public void inorder(Node root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public void preorder(Node root)
    {
        if(root==null)
            return;
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void postOrder(Node root)
    {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    public ArrayList<Node>levelOrder(Node root)
    {
        ArrayList<Node>ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node>q=new Queue<>();
        q.add(root);
        while(q.isEmpty()==false)
        {
            Node curr=q.remove();
            ans.add(curr);
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
        return ans;
    }

    public ArrayList<ArrayList<Node>>levelOrder(Node root)
    {
        // ArrayList<Node>ans=new ArrayList<>();
        ArrayList<ArrayList<Node>>ans=new ArrayList<>();
        if(root==null)
            return ans;
        Queue<Node>q=new Queue<>();
        q.add(root);
        while(q.isEmpty()==false)
        {
            int qs=q.size();
            ArrayList<Node>smallans=new ArrayList<>();
            while(qs>0)
            {
                Node curr=q.remove();
                smallans.add(curr);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
                qs--;
            }
            ans.add(new ArrayList<>(smallans));
        }
        return ans;
    }

    public TreeNode helper(int []iarr,int isi,int iei,int []parr,int psi,int pei)
    {
        int rootVal=parr[psi];
        Node root=new Node(rootval);
        int idxOfRootValueinInOrder=-1;
        for(int i=isi;i<=iei;i++)
        {
            if(iarr[i]==rootVal)
            {
                idxOfRootValueinInOrder=i;
            }
        }
        int leftTreeSize= idxOfRootValueinInOrder-isi;
        root.left=helper(iarr,isi ,idxOfRootValueinInOrder-1, parr, psi+1, psi+leftTreeSize);

        root.right=helper(iarr,idxOfRootValueinInOrder+1, iei, parr, psi+leftTreeSize+1, pei);
        return root;

    }
    public Node buildTreeFromInorderPreOrder(int []preorder,int []inorder)
    {
        return helper(inorder,0,inorder.length-1,preorder,0,preorder.length-1);
    }
}
