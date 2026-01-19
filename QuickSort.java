import java.util.*;
class QuickSort{
	 static int partion(int[] arr,int low,int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=arr[temp];
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;//pivot position
	}
	static void quicksort(int[] arr,int low,int high) {
		if(low<high) {
			int p=partion(arr,low,high);
			quicksort(arr,low,p-1);
			quicksort(arr,p+1,high);
		}
	}
	public static void main(System[]args) {
		int[] arr= {10,7,4,5,8,3,9};
		
		quicksort(arr,0,arr.length-1);
		
		System.out.println("Sorted array");
		for (int num:arr) {
			System.out.println(num+" ");
		}
	}
}
