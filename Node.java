package cs146F20.dang.project1;

public class Node {
	int data;	// data/prisoner number in the node
	Node next;	// node after current node
	Node previous;	// node before current node
	
	/**
	 * Constructor to initialize node
	 * @param d - prisoner number assigned to data in node
	 */
	public Node(int d) {
		this.data = d;
		this.next = null;
		this.previous = null;
	}
	
	/**
	 * retrieves next node of a certain node in the linked list
	 * @return next
	 */
	Node getNext() {
		return next;
	}
	
	/**
	 * sets next node of a certain node in the list to node passed in parameter
	 * @param next -- node to be set to next in the list
	 */
	void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * retrieves previous node of a certain node in the linked list
	 * @return previous
	 */
	Node getPrev() {
		return previous;
	}
	
	/**
	 * sets previous node of a certain node in the list to node passed in parameter
	 * @param previous
	 */
	void setPrev(Node previous) {
		this.previous = previous;
	}
	
	/**
	 * retrieves data stored in a node
	 * @return data
	 */
	int getData() {
		return data;
	}
}
