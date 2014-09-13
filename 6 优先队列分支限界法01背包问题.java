import java.util.Scanner;

/**
 * 
 * @author ������
 * date:2014/6/21
 */

class MaxHeap 
 {                      
   static HeapNode[] Heap;  
   static int size;     
   static int n;        
  public MaxHeap(HeapNode[] h,int num,int max)
   { Heap=h;n=num;size=max;buildheap();}
  public int heapsize()		//���ص�ǰ�ѵĳ���
   {  return n;}
  public static boolean isLeaf(int pos)
   { return(pos>=n/2)&&(pos<n);} 
  public static void Assert_notFalse(boolean p,String q)
   {if(!p)System.out.println((String)q);}
  public static double key( HeapNode [] q,int p)
   {  return q[p].upperProfit;}
//��������λ��
  public static int leftchild(int pos)
   { Assert_notFalse(pos<n/2,"position has no left child");
     return 2*pos+1;
   }
//�����Һ���λ��
  public static int rightchild(int pos)
   {Assert_notFalse(pos<(n-1)/2,"position has no right child");
   return 2*pos+2;
   }
  public static int parent(int pos)//���ظ��ڵ�λ��
   {Assert_notFalse(pos>0,"position has no parent");
   return (pos-1)/2;
   }
  public static  void buildheap() 
   {  for(int i=n/2-1;i>=0;i--)siftdown(i);}

  public static void swap(HeapNode[] q,int i,int j)
   {      
     HeapNode temp;
     temp=q[i];q[i]=q[j];q[j]=temp;}

  private static void siftdown(int pos) 
   {Assert_notFalse((pos>=0) && (pos<n),"illegal heap position ");
   while(! isLeaf(pos))
    {
     int j=leftchild(pos);
     if((j<(n-1))&&(key(Heap,j)<key(Heap,j+1)))
       j++;// j�ǵ�ǰ���ֵ������
     if(key(Heap,pos)>=key(Heap,j)) return;// ���
     swap(Heap,pos,j);
     pos=j;//����
    }
   }
  public static void insert(HeapNode val) //����в�������
   {
   Assert_notFalse(n<size,"Heap is full ");
   int curr=n++;
   Heap[curr]=val;      
   
   while((curr!=0)&&(key(Heap,curr)>key(Heap,parent(curr))))
     {
       swap(Heap,curr,parent(curr));
       curr=parent(curr);
     }
    }
  public static HeapNode removemax()  
    {
     Assert_notFalse(n>0,"Removing from empty heap ");
     swap(Heap,0,--n);
     if(n!=0)     
     siftdown(0); 
     return Heap[n];
   }

  public static HeapNode remove(int pos)
   {
    Assert_notFalse((pos>0)&&(pos<n),"illegal heap position ");
    swap(Heap,pos,--n);
    if(n!=0)     
    siftdown(pos);
    return Heap[n];
   }
 public static void outMaxHeap()
   {
   for(int i=0;i<=n-1;i++)
   System.out.print(Heap[i].upperProfit+"  ");
   System.out.println(); 
   }       

static void heapsort()  //������
  {
   System.out.println("������֮������");
   
   for(int i=1;i<size-1;i++) 
   System.out.print(removemax().upperProfit+"  ");
   System.out.println( );   
  } 
}// class MaxHeap
  
  class BBnode
 {
    BBnode parent;            // �����
    boolean leftChild;        // ����ӽ���־
    BBnode(BBnode par,boolean ch)
     {
      parent=par;
      leftChild=ch;
     }
 }

 class HeapNode implements Comparable
  {
     BBnode liveNode;         //  ����
     double upperProfit;      //  ���ļ�ֵ�Ͻ�
     double profit;           //  �������Ӧ�ļ�ֵ
     double weight;           //  �������Ӧ������
     int level;               //  �������Ӽ����������Ĳ���� 

   
    HeapNode(BBnode node ,double up,double pp,double ww,int lev)
     {
       liveNode=node;
       upperProfit=up;
       profit=pp;
       weight=ww;
       level=lev;
     }

    public int compareTo(Object x)
     {
      double xup=((HeapNode) x).upperProfit;
      if(upperProfit<xup) return -1;
      if(upperProfit==xup) return 0;
      return 1;
     }
  } 

   class Element implements Comparable
     {
       int id;           //    ���
       double d;         //    ��λ������ֵ
        Element(int idd,double dd)
         {
           id=idd;
            d=dd;
         }
         public int compareTo(Object x)
         {
          double xd=((Element) x).d;
          if(d<xd) return -1;
          if(d==xd) return 0;
          return 1;
         }
       public boolean equals(Object x)
         {return d==((Element) x).d;}
     }
  
  class BBKnapsack
    {
     static double c;       // �������� 
     static int  n;         // ��Ʒ����
     static double []w;     // ��Ʒ��������
     static double []p;     // ��Ʒ��ֵ����
     static double  cw;     // ��ǰ����
     static double  cp;     // ��ǰ��ֵ
     static int [] bestx;   // ���Ž�
     static MaxHeap heap;   // �������ȶ���
  
  private static double bound(int i)
   {                        //����������Ӧ��ֵ���Ͻ�
    double cleft=c-cw;      //ʣ������
    double b=cp;            //��ֵ�Ͻ�
    //����Ʒ��λ������ֵ�ݼ���װ��ʣ������
    while(i<=n && w[i]<=cleft)
      {
       cleft-=w[i];
       b+=p[i];
       i++;
      }
  
     //װ��ʣ������װ������
    if(i<=n)b+=p[i]/w[i]*cleft;
    return b;
   }
 private static void addLiveNode(double up,double pp,double ww,int lev,BBnode par,boolean ch)
   {  //��һ���µĻ�����뵽�Ӽ�����������
      BBnode b=new BBnode(par,ch);
      HeapNode node=new HeapNode(b,up,pp,ww,lev);
      heap.insert(node);
    //  System.out.println("�µ��ֵ�Ͻ�   "+node.upperProfit+"  ");
        
   }
private static double bbKnapsack()
   {   //���ȶ��з�֧���޷�����������ֵ��bestx ��������ֵ
       //��ʼ��
     BBnode enode=null;
     int i=1;
     double bestp=0.0;       //��ǰ����ֵ
     double up=bound(1);     //��ֵ�Ͻ�
      //�����Ӽ��ռ���
     while(i!=n+1)
       {    //��Ҷ���
            //��鵱ǰ��չ��������ӽ��
        double wt=cw+w[i];
        if(wt<=c)
         {  //����ӽ��Ϊ���н��
          if(cp+p[i]>bestp)
             bestp=cp+p[i];   
          addLiveNode(up,cp+p[i],cw+w[i],i+1,enode,true);
          //heap.outMaxHeap();
         }
        up=bound(i+1);
          //��鵱ǰ��չ�����Ҷ��ӽ��
       if(up>=bestp)
          //���������ܺ����Ž�
        addLiveNode(up,cp,cw,i+1,enode,false);
          //ȡ��һ��չ���
        
       HeapNode node=(HeapNode)heap.removemax();
       enode=node.liveNode;
       cw=node.weight;
       cp=node.profit;
       up=node.upperProfit;
        i=node.level;
      
      }
       //���쵱ǰ���Ž�
       for(int j=n;j>0;j--)
         {
          bestx[j]=(enode.leftChild)?1:0;
          enode=enode.parent;
         }
       return cp;
    }

  public static double knapsack(double[] pp,double []ww,double cc,int []xx)
    {    //��������ֵ��bestx�������Ž�
     c=cc;
     int n=pp.length-1;
         //��������λ������ֵ�������Ʒ����
     Element []q=new Element[n];
     double ws=0.0;      //װ����Ʒ����
     double ps=0.0;      //װ����Ʒ��ֵ
     for(int i=1;i<=n;i++)
      {
        q[i-1]=new Element(i,pp[i]/ww[i]);
        ps+=pp[i];
        ws+=ww[i];
      }
     if(ws<=c)//������Ʒװ��
      {
        for(int i=1;i<=n;i++)
         xx[i]=1;
        return ps;
      }
      //����λ������ֵ��������
     mergeSort(q,0,n-1);
     // ��ʼ�������ݳ�Ա 
   
     p=new double[n+1];
     w=new double[n+1];
     for(int i=1;i<=n;i++)  //ת��Ϊ����
      {
       p[i]=pp[q[n-i].id];
       w[i]=ww[q[n-i].id];
      }
    
     cw=0.0;
     cp=0.0;
     bestx=new int[n+1];
     HeapNode []h1=new HeapNode[n+1];
     heap=new MaxHeap(h1,0,n);
      //���� bbKnapsack ����������Ž�
     double maxp=bbKnapsack();
     for(int i=1;i<=n;i++)
      xx[q[n-i].id]=bestx[i];
     return maxp;
  }
   public static void mergeSort(Element [] a,int left,int right)
  {
   Element b[]=new Element[a.length];
   if(left<right){//������2��Ԫ��
   int i=(left+right)/2;//ȡ�е� 
   mergeSort(a,left,i);
   mergeSort(a,i+1,right);
   merge(a,b,left,i,right);//�ϲ������� b
   copy(a,b,left,right);//���ƻ����� a
    }
   }
 public static void copy(Element[] a,Element[] b,int i,int j)
  {
    int k;
    for(k=i;k<=j;k++)
    a[k]=b[k];
   } 
public static void merge(Element [] c,Element [] d,int l,int m,int r)
   {//�ϲ�c[l:m]��c[m+1:r]��d[l:m]
    int i=l,
        j=m+1,
        k=l;
    while((i<=m)&&(j<=r))
        if(c[i].d-c[j].d<=0)
           d[k++]=c[i++];
        else d[k++]=c[j++];
        if(i>m)
        for(int q=j;q<=r;q++)
            d[k++]=c[q];
        else 
         for(int q=i;q<=m;q++)
            d[k++]=c[q];
    }

}

public  class BranchBounding{   
    public static void main(String args[])
{
  BBKnapsack abc=new BBKnapsack();
//  double v1[]={0,6,3,5,4,6};
//  double w1[]={0,2,2,6,5,4};
  Scanner sc = new Scanner(System.in);
	double pk[]= new double[11];
   double wk[]=new double[11];
   pk[0] = 0;
   wk[0] = 0;
  //10����Ʒ����
  for (int i = 1; i < 11; i++) {
		wk[i] = sc.nextInt();
	}
  //10����Ʒ��ֵ
 for (int i = 1; i < 11; i++) {
		pk[i] = sc.nextInt();
	}
  sc.close();
  
  
  double c1=50;
  int n1=pk.length-1;
  int x1[]=new int[n1+1];
  double bestx1;
  abc.n=n1;
  bestx1=abc.knapsack(pk,wk,c1,x1);
  
  System.out.println((int)bestx1);  

 }    
}