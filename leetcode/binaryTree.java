import java.util.*;
class treeNode{
	int data;
	treeNode left;
	treeNode right;
	treeNode(int val){
		this.data = val;
		this .left = null;
		this.right = null;
	}
}
class binaryTree{
	public static void main(String[] args){
		System.out.println("Anant");
		Scanner sc = new Scanner(System.in);
		treeNode root = null;
		int n = sc.nextInt();
		int i = n;
		int data;
		binaryTree bt = new binaryTree();
		while(i>0){
			i--;
			data = sc.nextInt();
			root = bt.insertNode(data, root);
		}
		bt.printPreOrder(root);

	}
	public treeNode insertNode(int data, treeNode root){
		treeNode point = root;
		treeNode prev = null;
		treeNode node = new treeNode(data);
		if(root == null)
			return node;
		while(point !=null){
			prev = point;
			if(point.data >= data)
				point = point.left;
			else
				point = point.right;
		}
		if(prev.data >= data)
			prev.left = node;
		else
			prev.right = node;
		return root;

	}
	void printPreOrder(treeNode root){
		treeNode point = root;
		if(point == null)
			return;
		System.out.printf("%d ", point.data);
		printPreOrder(point.left);
		printPreOrder(point.right);
		}
	public List<Integer> postorderTraversal(treeNode root) {
	       	List<Integer> l2 = new ArrayList<Integer>();
        	treeNode point = root;
                if(point == null)
                        return l2;
                l2.addAll(postorderTraversal(point.left));
                l2.addAll(postorderTraversal(point.right));
                l2.add(point.data);
       		return l2;
	}
	void printInOrder(treeNode root){
		treeNode point = root;
		if(point == null)
			return;
		printInOrder(point.left);
		System.out.printf("%d ", point.data);
		printInOrder(point.right);
		}
	public List<Integer> inOrderTraversal(treeNode root) {
	       	List<Integer> l2 = new ArrayList<Integer>();
        	treeNode point = root;
                if(point == null)
                        return l2;
                l2.addAll(inOrderTraversal(point.left));
                l2.add(point.data);
                l2.addAll(inOrderTraversal(point.right));
       		return l2;
	}
	void printPostOrder(treeNode root){
		treeNode point = root;
		if(point == null)
			return;
		printPostOrder(point.left);
		printPostOrder(point.right);
		System.out.printf("%d ", point.data);
		}
	public List<Integer> preOrderTraversal(treeNode root) {
	       	List<Integer> l2 = new ArrayList<Integer>();
        	treeNode point = root;
                if(point == null)
                        return l2;
                l2.add(point.data);
                l2.addAll(preOrderTraversal(point.left));
                l2.addAll(preOrderTraversal(point.right));
       		return l2;
	}
}
