Node reverse(Node head)
{
    Node temp=head;
    Node prev=null;
    Node next=null;
    while(temp!=null)
    {
        next=temp.next;// saving purpose
        temp.next=prev;
        prev=temp;
        temp=next;
    }
    return prev;
}

//Even I Want Second Even
public ListNode middleNode(ListNode head) {
    ListNode s=head;
    ListNode f=head;
    while(f!=null && f.next!=null)
    {
        f=f.next.next;
        s=s.next;
    }
    return s;
}

//Even I Want First Even
public ListNode middleNode_first(ListNode head) {
    ListNode s=head;
    ListNode f=head;
    while(f.next!=null && f.next.next!=null)
    {
        f=f.next.next;
        s=s.next;
    }
    return s;
}


public boolean isPalindrome(Node head)
{
    if(head==null)
        return true;
    Node mid=middleNode_first(head);  // find the middle Node
    Node newhead=mid.next;  // Making new LinkedLisdt
    mid.next=null;// breaking into 2 parts
    newhead=reverse(newhead);//reverse the second part
    while(head!=null && newhead!=null)
    {
        if(head.val == newhead.val)
        {
            head=head.next;
            newhead=newhead.next;
        }
        else
            return false;
    }
    return true;
}

void foldLinkedList(Node head)
{
    Node mid=middleNode_first(head); // find the mid node
    Node ll2=mid.next;//breaking into 2 ll
    ll2=reverse(ll2);//reversing the LL

    Node ll1=head;
    Node f1;
    Node f2;
    while(ll1!=null && ll2!=null)
    {
        f1=ll1.next;
        f2=ll2.next;

        ll1.next=ll2;
        ll2.next=f1;

        ll1=f1;
        ll2=f2;
    }
}

public boolean isCycle(Node head)
{
    Node fast=head;
    Node slow=head;
    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
            return true;
    }
    return false;
}

public Node startingNode(Node head)
{
    Node fast=head;
    Node slow=head;
    while(fast!=null && fast.next!=null)
    {
        slow=slow.next;
        fast=fast.next.next;
        if(slow==fast)
            break;
    }
    Node t1=head;
    Node t2=slow;
    while(t1!=t2)
    {
        t1=t1.next;
        t2=t2.next;
    }
    return t1;
}

int cyclelength(Node head)
{
    t1=t1.next;
    int clen=0;
    while(t1!=t2)
    {
        clen++;
        t1=t1.next;
    }
}