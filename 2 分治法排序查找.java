import java.util.Scanner;

public class BinSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int[] arr = {2,5,8,12,3,19};
		int result;
		int goal;
		int[] arr;
		//输入要查找的数字
		Scanner sc = new Scanner(System.in);
		 goal = sc.nextInt();
		
		//输入数组

		arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		//排序
		QuickSort(arr,0,arr.length-1);
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		//二分查找
		result = binSearch(arr,0,arr.length-1,goal);
		System.out.println(result);
	}
	
	
	public static int binSearch(int[] arr,int left,int right,int goal){
		int mid;
		while(left <= right){
			mid = (left + right) / 2;
			if(arr[mid] == goal )
				return mid;
			 if (goal < arr[mid]) { 
				//goal在arr[mid]左侧
				return binSearch(arr,left,mid-1,goal);
			}
			 if(goal > arr[mid]){
				//goal在arr[mid]右侧
				 //13,mid = 2,left = 0,right = 4
				 //13 left = 3, right = 4
				 //13 left = 4, right = 4
				 //21 
				return binSearch(arr,mid+1,right,goal);
			} 
		}
		return -1;
	}
	
	public static void QuickSort(int[] arr,int start,int end){
		if(start < end){
			int left = start;
			int right = end;
			int key = arr[left];
			while(left < right){
				while(arr[right] > key && left < right){
					right--;
				}
				arr[left] = arr[right];
				while(arr[left] < key && left < right){
					left++;
				}
				arr[right] = arr[left];
			}
			arr[left] = key;
			QuickSort(arr,start,left-1);
			QuickSort(arr,left+1,end);
		}
	}
}