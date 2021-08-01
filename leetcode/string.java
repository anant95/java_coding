import java.util.Scanner;

class string{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String st1 = sc.nextLine();
		String st2 = sc.nextLine();
		char[] charst1 = st1.toCharArray();
		char[] charst2 = st2.toCharArray();
		string st = new string();
		//System.out.printf("%d ", st.strStr("mississippi", "pi"));
		System.out.printf("%d ", st.strStr(st1, st2));
		/*int n = charst1.length;
		int m = charst2.length;
		int carry = 0;
		for(int i = n-1,j = m-1; i>=0 && j>=0; i--,j--){
			
		}
		System.out.println(st1);*/
	}
	public int strStr(String haystack, String needle) {
	     char[] hay = haystack.toCharArray();
	     char[] nee = needle.toCharArray();
	     int h = hay.length;
	     int n = nee.length;
	     int x = n, y = h;
	     int i = 0, j = 0, nii=0;
	     int f = 0;
	     boolean ni = false;
	     if(n == 0)
		     return 0;
	     while(h>=n){
		     h--;
		     if(ni == false && f!=0 && hay[i] == nee[0]){
			     ni = true;
			     nii = i;

		     }
		     if(hay[i++] == nee[j++]){
			     f++;
			     if(f==x)
				     return i-x;
			     n--;
		     }
		     else{
			f = 0;
			j = 0;
			n = x;
			if(ni == true){
				i = nii;
				h = y-i;
				ni = false;
			}
			/*if(i!=0)
		     if(hay[i-1] == nee[j]){
			     f++;
			     j++;
			     if(f==x)
				     return i-x;
			     n--;
		     }*/
		}
	     }
	     return -1;
	}
}
