import java.util.Scanner;
class singlyLinkedListNode{
	int data;
	singlyLinkedListNode next;
	singlyLinkedListNode(int data){
		this.data = data;
		this.next = null;
	}
};
class MyLinkedList {
	private singlyLinkedListNode head;
    /* Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
    }
    public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    MyLinkedList ml = new MyLinkedList();
	    int n = sc.nextInt();
	    int data;
	    while(n>0){
		    data = sc.nextInt();
		    ml.addAtTail(data);
		    n--;
	    }
	    ml.printList();
    }
    public void printList(){
	    singlyLinkedListNode point = head;
	    while(point != null){
		    System.out.printf("%d ->", point.data);
		    point = point.next;
	    }
    }
    
    /* Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
	    int i = 0;
	    if(index<0)
		    return -1;
	    singlyLinkedListNode point = head;
	    while(i<index){
		    point = point.next;
		    if(point == null)
			    return -1;
		    i++;
	    }
	    return point.data;
    }
    
    /* Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        singlyLinkedListNode node = new singlyLinkedListNode(val);
	if(head !=null)
		node.next = head;
	head = node;
    }
    
    /* Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
	    singlyLinkedListNode node = new singlyLinkedListNode(val);
	    if(head == null)
		    head = node;
	    else{
		    singlyLinkedListNode point = head;
		    while(point.next != null)
			    point = point.next;
		    point.next = node;
	    }
    }
    
    /* Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
	    if(index<0)
		    return;
		    if(index == 0)
			    addAtHead(val);
		    else{
		    	singlyLinkedListNode point = head;
			singlyLinkedListNode node = new singlyLinkedListNode(val);
		    	int i = 1;
			while(i<index){
				if(point ==null)
					return;
				point = point.next;
				i++;
			}
			if(point != null){
				node.next = point.next;
				point.next = node;
			}

		    }
    }
    
    /* Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
	    if(index<0)
		    return;
	    else if(index == 0){
		    singlyLinkedListNode point = head;
		    head = head.next;
	    }
	    else{
		    int i = 1;
		    singlyLinkedListNode point = head;
		    while(i<index){
			    point = point.next;
			    if(point == null){
				    return;
			    }
			    i++;
		    }
		    if(point.next != null){
			    point.next = point.next.next;
		    }
	    }
        
    }
}

/*
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
