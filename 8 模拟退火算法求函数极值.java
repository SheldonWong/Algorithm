import java.util.Random;

public class SA {

	/**
	 * @param args
	 */
	
	static double getProbability(double df,double t){
		return 1.0 /(Math.exp(df / t)); //���ܸ���
	}
	
	static double SimulateAnnealing(){
		double T = 10000000;  //��ʼ����
		double rate = 0.9999;  //��ȴ��
		double stop = 0.00001; //��ֹ�¶�
		int lastValue = 500;   //��ʼ��
		
		Random r = new Random();
		while (T > stop) {
			int curValue = r.nextInt(1000);
			if(curValue < lastValue) 
				lastValue = curValue;
			else
				if(r.nextDouble() <= getProbability(curValue - lastValue, T));
			    lastValue = curValue;
			T *= rate;  //����
			
		}
		return lastValue;
	}
	static double func(double x){
		return x * Math.sin(10 * 3.1415926 * x) + 2.0;
	}
	
	static double aa(){
		double T = 10000000;  //��ʼ����
		double rate = 0.9999;  //��ȴ��
		double stop = 0.00001; //��ֹ�¶�
		double lastValue = 1.0;   //��ʼ��
		
		Random r = new Random();
		while (T > stop) {
			double x = r.nextDouble() * 3 - 1;
			double curValue = func(x);
			if(curValue > lastValue)  //����ֵ���󣬸��ţ�����
				lastValue = curValue;
			else
				if(r.nextDouble() <= getProbability(curValue - lastValue, T));
			    lastValue = curValue;
			T *= rate;  //����
			
		}
		return lastValue;
		
	}
	
	public static void main(String[] args) {
		
		System.out.println(aa());
		System.out.println(SimulateAnnealing());

	}

}