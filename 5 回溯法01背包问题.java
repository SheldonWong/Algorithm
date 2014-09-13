import java.util.Scanner;

class Knapsack2
{ 
   private  static class Element implements Comparable
     {
       int id;//物品编号
       double d;
       private Element(int idd,double dd)
        {
          id=idd;
          d=dd;
        }
     public int compareTo(Object x)
        {
          double xd=((Element) x).d;
          if(d<xd)return -1; 
          if(d==xd)return 0;
          return 1;
        }
    public boolean equals(Object x)
       {return d==((Element) x).d;}
   }
 
  static double  c;         // 背包容量
  static int n;             // 物品数 
  static double []w ;       // 物品数量数组 
  static double []p;        // 物品价值数组
  static double cw;         // 当前重量
  static double cp;         // 当前价值
  static double bestp;      // 当前最优价值
   public static void mergeSort(Element [] a,int left,int right)
 {
  Element b[]=new Element[a.length];
  if(left<right) {   //至少有2个元素
  int i=(left+right)/2;//取中点 
  mergeSort(a,left,i);
  mergeSort(a,i+1,right);
  merge(a,b,left,i,right);//合并到数组 b
  copy(a,b,left,right);//复制回数组 a
   }
  }
public static void copy(Element[] a,Element[] b,int i,int j)
  {
   int k;
   for(k=i;k<=j;k++)
   a[k]=b[k];
  } 
public static void merge(Element [] c,Element [] d,int l,int m,int r)
  {//合并c[l:m]和c[m+1:r]到d[l:m]
   int i=l,
       j=m+1,
       k=l;
   while((i<=m)&&(j<=r))
       if(c[i].d-c[j].d>=0)
          d[k++]=c[i++];
       else d[k++]=c[j++];
       if(i>m)
       for(int q=j;q<=r;q++)
           d[k++]=c[q];
       else 
        for(int q=i;q<=m;q++)
           d[k++]=c[q];
   }

 public static double knapsack(double []pp,double []ww,double cc)
  {
  c=cc;
  n=pp.length-1;
  cw=0.0;
  cp=0.0;
  bestp=0.0;
  //q为单位重量价值数组
  Element []q=new Element[n];
  //初始化   q[0,n-1]

  for(int i=1;i<=n;i++)
   q[i-1]= new Element(i,pp[i]/ww[i]);
// 将各物品依单位重量价值从大到小排序 
    mergeSort(q,0,n-1);
   //System.out.println("输出依单位重量价值从大到小排序  ");
   for(int i=0;i<q.length;i++)
   //System.out.print(q[i].d+"  ");
   //System.out.println();
  p=new double[n+1];
  w=new double[n+1];
  for(int i=1;i<=n;i++)
   {
    p[i]=pp[q[i-1].id];
    w[i]=ww[q[i-1].id];
   }
 //  System.out.println("输出单位价值升序排序后的价值顺序结果  ");
 //  for(int i=0;i<p.length;i++)
 //  System.out.print(p[i]+"  ");
 //  System.out.println();
   //System.out.println("输出单位价值升序排序后的重量顺序结果  ");
   for(int i=1;i<w.length;i++)
   //System.out.print(w[i]+"  ");
   //System.out.println();
  backtrack(1);//回溯搜索
  return bestp;
 }
 private static void backtrack(int i)
  {
    if(i>n)
    {//到达叶结点
     bestp=cp;
     return;
    }
   //搜索子树
    if(cw+w[i]<=c)
    {//  进入左子树
      cw+=w[i];
      cp+=p[i];
      backtrack(i+1);
      cw-=w[i];
      cp-=p[i];
   }
    if(bound(i+1)>bestp)
      backtrack(i+1);//进入右子树 
  }

  private static double bound(int i)
    {//计算上界
     double cleft=c-cw;// 剩余容量 
       
     double bound=cp;
     //以物品单位重量价值递减顺序装入物品
     while(i<=n && w[i]<=cleft)
       {//System.out.println("剩余容量="+cleft+"  w["+i+"]="+w[i]+","+p[i]); 
         cleft-=w[i];
         bound+=p[i];
         i++;
       }
     
     //装满背包
     if(i<=n)
      bound+=p[i]/w[i]*cleft;
     return bound;
   }
  
}
   public class MM{
   public static void main(String args[])
{
//  double pk[]={0,9d,10d,7d,4d};
//  double wk[]={0,3d,5d,2d,1d};
	   
//	   double[] wk = {0,12,3,11,5,6,8,9,4,7,10};
//     double[] pk = {0,6,2,7,3,2,9,8,10,4,5};
	   
	   Scanner sc = new Scanner(System.in);
		double pk[]= new double[11];
	     double wk[]=new double[11];
	     pk[0] = 0;
	     wk[0] = 0;
       //10个物品重量
       for (int i = 1; i < 11; i++) {
			wk[i] = sc.nextDouble();
		}
       //10个物品价值
      for (int i = 1; i < 11; i++) {
			pk[i] = sc.nextDouble();
		}
       sc.close();
  Knapsack2 abc=new Knapsack2();
  abc.n=10;
  abc.c=50;
  abc.p=pk;
  abc.w=wk;
   
  System.out.println((int)abc.knapsack(abc.p,abc.w,abc.c));
}
}