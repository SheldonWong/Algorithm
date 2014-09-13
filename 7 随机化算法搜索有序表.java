import java.util.Scanner;

/**
 * @author ������
 * date:2014/6/29
 */
class RandomNumber
{
  private long seed;//��ǰ����
  private final static long multiplier=0x5DEECE66DL;
  private final static long adder=0xBL;
  private final static long mask=(1L<<48)-1;
  //���췽�����Զ���������
  public RandomNumber(){
    this.seed=System.currentTimeMillis();}
 //���췽����ȱʡֵ0��ʾ��ϵͳ�Զ���������
  public RandomNumber(long seed)
    {
      if(seed==0)this.seed=System.currentTimeMillis();
      else this.seed=seed;
    }
 //����[0,n-1]֮����������
  public int random(int n)
    {
     if(n<=0)
      throw new  IllegalArgumentException(" n must be positive");
     seed=(seed*multiplier+adder) & mask;
     return ((int)(seed>>>17)%n);
    }
 //����[0,1]֮������ʵ��
  public double fRandom()
    {
     return random(Integer.MAX_VALUE)/(double)(Integer.MAX_VALUE);
    } 
 }

public class OrderList {

    public static void main(String[] args) {
        //��ʼ��˳���
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
        //�����ȡԪ�ش���
        int m = (int)Math.sqrt(value.length);
        //���������
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
        //˳������
        while(value[index]<x) {
            index = link[index] + 1;
        }
        //���ؽ��
        if(value[index] == x){
        	return index;
        }else{
        	return -1;
        }
    }
}
