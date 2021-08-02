import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class sorting{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		sorting sort = new sorting();
		int n = sc.nextInt();
		List<Integer> arrList = new ArrayList<Integer>();
		for(int i = 0; i<n; i++)
			arrList.add(sc.nextInt());
		sort.insertionSort(arrList);
		System.out.println(arrList);

	}
	void insertionSort(List<Integer> arrList){
		for(int i = 1; i<arrList.size(); i++){
			int x = arrList.get(i);
			for(int j = i; j>0; j--){
				if(arrList.get(j)< arrList.get(j-1))
					swap(arrList, j, j-1);
			}
		}
	}
	void swap(List<Integer> arrList, int i, int j){
		int x = arrList.get(i);
		arrList.set(i, arrList.get(j));
		arrList.set(j, x);
	}
}
