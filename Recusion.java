public class Recusion {
    // public static void p3()
    // {
    //     System.out.println("P3 HERE");
    // }
    // public static void p2()
    // {
    //     System.out.println("HI");
    //     p3();
    //     System.out.println("HEY");
    // }
    // public static void p1()
    // {
    //     System.out.println("HELLO");
    //     p2();
    //     System.out.println("BYE");
    // }
    public static void pd(int n)
    {
        if(n==0)
            return;
        System.out.println(n);
        pd(n-1);
        System.out.println("Hi");
    }
    public static int sumOfNaturalNumber(int n)
    {
        if(n==1)
            return 1;
        int recans=sumOfNaturalNumber(n-1);
        int myans=recans+n;
        return myans;
    }
    public static int multiply(int n,int k)
    {
        if(k==1)
            return n;
        int recans=multiply(n, k-1);
        return recans+n;
    }
    public static int fib(int n)
    {
        if(n==0 || n==1)
            return n;
        int ra1=fib(n-1);
        int ra2=fib(n-2);
        int myans=ra1+ra2;
        return myans;
    }
    public static int stairCase(int n)
    {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;  //1111,   1+2, 2+1, 3
        int ra1=stairCase(n-1);
        int ra2=stairCase(n-2);
        int ra3=stairCase(n-3);
        return ra1+ra2+ra3;
    }
    public static int mazePath(int sr,int sc,int dr,int dc)
    {
        if(sr>dr || sc>dc)
            return 0;
        if(sr==dr && sc==dc)
            return 1;
        int ra1=mazePath(sr+1,sc,dr,dc);
        int ra2=mazePath(sr,sc+1,dr,dc);
        int myans=ra1+ra2;
        return myans;
    }
    public static int fact(int n)
    {
        if(n==1)
            return 1;
        int ra=fact(n-1);
        int myans=ra*n;
        return myans;
    }
    public static void pdi(int n)
    {
        System.out.println("EXCEUTION LINE NO 28 for "+n);
        if(n==0)
            return;
        System.out.println("EXCEUTION LINE NO 31 for "+n);
        System.out.println(n);
        System.out.println("EXCEUTION LINE NO 33 for "+n);
        pdi(n-1);
        System.out.println("EXCEUTION LINE NO 35 for "+n);
        System.out.println(n);
    }
    public static void main(String[] args) {
    //    pd(5);
        // pdi(4);
        int ans=sumOfNaturalNumber(5);
        System.out.println(ans);

    }
}
