import java.util.Scanner;

public class EditDistance {

	/**
	 * @author 王晓腾20116581
	 * 2014年5月28日
	 */
	public static void main(String[] args) {
		
//		String a = "She smiled and left, and the music changed to a Billy Joel tune.";
//		String b = "We came to a stop and stood in the silent forest, listening.";
		
		String a = "";
		String b = "";
		Scanner sc = new Scanner(System.in);
		
		a=sc.nextLine();
		b=sc.nextLine();
		sc.close();
		
		System.out.println(LevenshteinDistance(a, b));
		
			
	}


	public static int LevenshteinDistance(String strA,String strB){
		
		char[] charArrA = strA.toCharArray();
		char[] charArrB = strB.toCharArray();
		
		int m = charArrA.length + 1;
		int n = charArrB.length +1;
		
		//定义并初始化LD矩阵
		int[][] LD = new int[m][n];
		for (int i = 0; i < m; i++) {
			LD[i][0] = i;
		}
		for(int j = 0; j < n ;j++) 
			LD[0][j] = j;
		
		for(int i = 1;i < m;i++){
			for(int j = 1; j < n; j++){
				if(charArrA[i-1] == charArrB[j-1])
					LD[i][j] = LD[i-1][j-1];
				else 
					LD[i][j] = 
Math.min(Math.min(LD[i-1][j-1],LD[i-1][j]),LD[i][j-1])+1;
 			}
		}
				
		return LD[m-1][n-1];
		
	}
}