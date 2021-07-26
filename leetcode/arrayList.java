import java.util.Scanner;

public class arrayList{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a1 = new int[n];
		for(int i =0; i<n; i++){
			a1[i]= sc.nextInt();
		}
		arrayList al = new arrayList();
		System.out.printf("%d ", al.pivotIndex(a1));
	}
	public int pivotIndex(int[] nums) {
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = 0;
		right[n-1] = 0;
		for(int i = 1; i<n; i++){
			left[i] = left[i-1] + nums[i-1];
		}
		for(int i = n-2; i>=0; i--)
			right[i] = right[i+1] + nums[i+1];
		for(int i = 0; i<n; i++){
			if(left[i] == right[i])
				return i;
		}
			return -1;
	}
}
