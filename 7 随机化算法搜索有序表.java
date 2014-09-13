import java.util.Scanner;

/**
 * @author 王晓腾
 * date:2014/6/29
 */
class RandomNumber
{
  private long seed;//当前种子
  private final static long multiplier=0x5DEECE66DL;
  private final static long adder=0xBL;
  private final static long mask=(1L<<48)-1;
  //构造方法，自动产生种子
  public RandomNumber(){
    this.seed=System.currentTimeMillis();}
 //构造方法，缺省值0表示由系统自动产生种子
  public RandomNumber(long seed)
    {
      if(seed==0)this.seed=System.currentTimeMillis();
      else this.seed=seed;
    }
 //产生[0,n-1]之间的随机整数
  public int random(int n)
    {
     if(n<=0)
      throw new  IllegalArgumentException(" n must be positive");
     seed=(seed*multiplier+adder) & mask;
     return ((int)(seed>>>17)%n);
    }
 //产生[0,1]之间的随机实数
  public double fRandom()
    {
     return random(Integer.MAX_VALUE)/(double)(Integer.MAX_VALUE);
    } 
 }

public class OrderList {

    public static void main(String[] args) {
        //初始化顺序表
    	int value[] = new int[60000];
    	int link[] = new int[60000];
    	for (int i = 0; i < 60000; i++) {
    		link[i] = i;
			value[i] = (i+1) * 2;
		}
    	
    	Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int result = searchK(value,link,k);
        System.out.println(result);
    }

    private static  int searchK(int[] value, int[] link, int x) {
        
        int max = 0;
        //随机抽取元素次数
        int m = (int)Math.sqrt(value.length);
        //产生随机数
        RandomNumber r = new RandomNumber();
        int index = 0;
        for(int i=0; i<m; i++) {
            
            int j = r.random(value.length);
            int y = value[j];
            
            
            if(max<y&&y<x) {
                max = y;
                index = j;
            }
        }
        //顺序搜索
        while(value[index]<x) {
            index = link[index] + 1;
        }
        //返回结果
        if(value[index] == x){
        	return index;
        }else{
        	return -1;
        }
    }
}
