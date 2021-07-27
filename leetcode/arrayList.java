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
		int[] ans = al.plusOne(a1);
		for(int i = 0; i<ans.length; i++)
			System.out.printf("%d ", ans[i]);
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
	public int dominantIndex(int[] nums) {
		int n = nums.length;
		if(n == 1){
			return 0;
		}
		int l = nums[0];
		int s = nums[1];
		int index = 0;
		if(nums[0]<nums[1]){
			l = nums[1];
			s = nums[0];
			index = 1;
		}
		for(int i = 2; i<n; i++){
			if(l<=nums[i]){
				s = l;
				l = nums[i];
				index = i;
			}
			else if(s<nums[i])
				s = nums[i];
		}
		if(l>=(2*s))
			return index;
		else
			return -1;
    }
    public int[] plusOne(int[] digits) {
	    int n = digits.length;
	    int carry = 0;
	    if(digits[n-1]+1+carry == 10){
		    carry = 1;
		    digits[n-1] = 0;
	    }
	    else{
		    digits[n-1] = digits[n-1]+carry+1;
		    carry = 0;
		    return digits;
	    }
	    for(int i = n-2; i>=0; i--){
		    if(digits[i]+carry == 10){
			    carry = 1;
			    digits[i] = 0;
		    }
		    else{
			    digits[i] = digits[i]+carry;
			    carry = 0;
			    break;
		    }
	    }
	    if(carry == 1){
		    int[] ans = new int[n+1];
		    ans[0] = 1;
		    return ans;
	    }
	    return digits;
    }
}
