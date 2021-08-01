import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class arrayList{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		/*int n = sc.nextInt();
		int[][] a1 = new int[m][n];
		for(int i =0; i<n; i++){
			for(int j = 0; j<m; j++)
				a1[i][j]= sc.nextInt();
		}*/
		arrayList al = new arrayList();
		//int[][] a1 = {{1,2},{3,4}};
		List<List<Integer>> ans = al.generate(m);
		System.out.print(ans);
		//for(int i = 0; i<ans.length; i++)
		//	System.out.printf("%d ", ans[i]);
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
    public int[] findDiagonalOrder(int[][] mat) {
	    int m = mat.length;
	    int n = mat[0].length;
	    int[] ans = new int[m*n];
	    ArrayList<ArrayList<Integer>> diagonal = new ArrayList<ArrayList<Integer>>(m+n-1);
	    for(int i = 0; i<m+n-1; i++)
		    diagonal.add(new ArrayList<Integer>());
	    for(int i = 0; i<m; i++){
		    for(int j = 0; j<n; j++){
			    //System.out.printf("i = %d, j = %d, mat[i][j] = %d", i,j,mat[i][j]);
			    diagonal.get(i+j).add(mat[i][j]);
		    }
	    }
	    int k = 0;
	    for(int i = 0; i<m+n-1; i++){
		    for(int j = 0; j< diagonal.get(i).size(); j++){
			    if(i%2 !=0)
			    	ans[k++] = diagonal.get(i).get(j);
			    else{
				    for(int t = diagonal.get(i).size()-1; t>=0; t--){
					    ans[k++] = diagonal.get(i).get(t);
					    j++;
				    }

			    }
		    }
	    }
	    return ans;
    }
    public List<Integer> spiralOrder(int[][] matrix){
	    int m = matrix.length;
	    List<Integer> ans = new ArrayList<Integer>();
	    if(m==0)
		    return ans;
	    int n = matrix[0].length;
	    int c1 = 0, c2 = n-1, r1 = 0, r2 = m-1;
	    int d = 0;
	    while(c1<=c2 && r1<=r2){
		    if(d == 0){
			    d = 1;
			    for(int i =c1; i<=c2; i++){
				    ans.add(matrix[r1][i]);
			    }
			    r1++;
		    }
		else if(d ==1){
			d = 2;
			for(int i = r1; i<=r2; i++){
				ans.add(matrix[i][c2]);
			}
			c2--;
		}
		else if(d ==2){
			d = 3;
			for(int i = c2; i>=c1; i--)
				ans.add(matrix[r2][i]);
			r2--;
		}
		else if(d==3){
			d = 0;
			for(int i = r2; i>= r1; i--)
				ans.add(matrix[i][c1]);
			c1++;
		}
		    }
	    return ans;
    }
    public List<List<Integer>> generate(int numRows) {
	    List<List<Integer>> ans = new ArrayList<List<Integer>>();
	    for(int i =0; i<numRows; i++)
		    ans.add(new ArrayList<Integer>());
	    ans.get(0).add(1);
	    if(numRows == 1)
		    return ans;
	    for(int i = 1; i<numRows; i++){
		    ans.get(i).add(1);
		    for(int j = 1; j<i; j++){
			    int s = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);
			    ans.get(i).add(s);
		    }
		    ans.get(i).add(1);
	    }
	    return ans;
    }
}
