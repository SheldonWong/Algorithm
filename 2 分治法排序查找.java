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
		//����Ҫ���ҵ�����
		Scanner sc = new Scanner(System.in);
		 goal = sc.nextInt();
		
		//��������

		arr = new int[20];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		//����
		QuickSort(arr,0,arr.length-1);
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		//���ֲ���
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
				//goal��arr[mid]���
				return binSearch(arr,left,mid-1,goal);
			}
			 if(goal > arr[mid]){
				//goal��arr[mid]�Ҳ�
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