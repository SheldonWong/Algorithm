import java.util.Scanner;

	/**
	 * 堆排序算法
	 * @author 王晓腾
	 * @date 2014-06-07
	 */
public class HeapSort3 {
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			int arr[] = new int[sc.nextInt() + 1];
			arr[0] = 0;
			for(int i=1; i<arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			sc.close();
			
			heapsort(arr, arr.length-1);
			for (int  i= arr.length-1; i > 0; i--) {
				System.out.println(arr[i]);
			}
		}

		
//调整堆的函数
		public static void sift(int[] arr, int low, int high) {

			int i = low;
			int temp = arr[i];
			for (int j = 2 * i; j <= high; j = 2 * j) {//j=2*i是arr[i]的左孩子
				
				if (j < high && arr[j] < arr[j + 1])
					j = j + 1;		// 找出较大者把较大者给num[i]根结点
				if (temp > arr[j])
					break;
				arr[i] = arr[j];
				i = j;

			}

			arr[i] = temp;

		}

		public static void heapsort(int[] arr, int n) {
			int i;
			//初始化堆
			for (i = n / 2; i >= 1; i--) {
				sift(arr, i, n);
			}

			for (i = n; i > 1; i--) {
				arr[0] = arr[i];// 将堆顶元素与第n,n-1,.....2个元素相交换
				arr[i] = arr[1];
				arr[1] = arr[0];// 从num[1]到num[i-1]调整成新堆
				sift(arr, 1, i - 1);

			}

		}

	}
