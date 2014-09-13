import java.util.Scanner;

public class Knapsack {

	/**
	 * @author 王晓腾 20116581
	 * date 2014/6/1
	 */
	 public static int knapsack(int[] v, int[] w, int c, int[][] m)
	    {
	        /** v[] w[] c 分别是价值、重量、和背包容量
	        m[i][j]表示有i~n个物品，背包容量为j的最大价值。*/

	        int n = v.length-1;
	        int jMax = Math.min(w[n]-1, c);
	        for(int j = 0; j <= jMax; j++)  
	            m[n][j] = 0;        //当w[n]>j 有 m[n][j]=0

	        //m[n][j] 表示只有n物品，背包的容量为j时的最大价值
	        for (int l = w[n]; l <= c; l++)
	            m[n][l] = v[n];  //当w[n]<=j 有m[n][j]=v[n]

	        //递规调用求出m[][]其它值，直到求出m[0][c]
	        for(int i = n-1; i >=1; i--)
	        {
	            jMax = Math.min(w[i]-1,c);            
	            for(int k = 0; k <=jMax; k++)
	                m[i][k] = m[i+1][k];
	                      
	            for(int h = w[i]; h <= c; h++)
	                m[i][h] = Math.max(m[i+1][h],m[i+1][h-w[i]]+v[i]);
	        }
	        m[0][c] = m[1][c];
	        if(c >= w[0])
	            m[0][c] = Math.max(m[0][c],m[1][c-w[0]]+v[0]);

	        return m[0][c];
	        
	    }
	         
	    public static void traceback(int[][] m, int[] w, int c, int[] x)
	    {// 根据最优值求出最优解
	        int n = w.length-1;
	        for(int i = 0; i<n;i++)
	            if(m[i][c] == m[i+1][c])
	                x[i] = 0;
	            else{
	                x[i] = 1;
	                c -= w[i];
	            }
	        x[n] = (m[n][c]>0)?1:0;
	    }
	    public static void main(String[] args)
	    {
	        //测试数据
//	        int[] ww = {12,3,11,5,6,8,9,4,7,10};
//	        int[] vv = {6,2,7,3,2,9,8,10,4,5};

	        int[] ww = new int[10];
	        int[] vv = new int[10];
	        int c = 50; //背包容量
	        
	        Scanner sc = new Scanner(System.in);
	        //10个物品重量
	        for (int i = 0; i < ww.length; i++) {
				ww[i] = sc.nextInt();
			}
	        //10个物品价值
	        for (int i = 0; i < vv.length; i++) {
				vv[i] = sc.nextInt();
			}
	        sc.close();
	        
	    	int[][] mm = new int[51][51];
	        int best = knapsack(vv,ww,c,mm);
	        System.out.println(best);
	        
	        int[] xx =new int[ww.length];
	        traceback(mm,ww,c,xx);
	        for(int i = 0;i<xx.length;i++)
	            System.out.println(xx[i]);
	    }

}