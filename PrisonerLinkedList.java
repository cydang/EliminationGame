package cs146F20.dang.project1;

/**
 * Defines append and delete methods and linked list size methods
 * @author chloedang
 */
public class PrisonerLinkedList {
	
	Node head;
	Node tail;
	int totalPrisoners; //total number of prisoner nodes in linked list
	
	// constructor to initialize head, tail, and total number of prisoners
	public PrisonerLinkedList() {
		
		head = null; 
		tail = null;
		totalPrisoners = 0;
		
	}
	
	/**
	 * returns total number of prisoner nodes in the linked list
	 * @return totalPrisoners
	 */
	public int size() {
		return totalPrisoners;
	}
	
	/**
	 * checks if linked list is empty
	 * @return true if empty
	 * @return false if not empty
	 */
	public boolean isEmpty() {
		if (totalPrisoners == 0)
			return true;
		return false;
	}
	
	/**
	 * appends node containing data(prisoner number)
	 * @param prisoner -- number assigned to prisoner node
	 */
	public void appendAtEnd(int prisoner) {
		
		Node new_node = new Node(prisoner);
		
		if (head != null) {	
			
			Node beforeHead = head;		// finds node before head and is used to define new head and tail
			
			// traverses linked list until node before head is found
			while (beforeHead.getNext() != head) {
				beforeHead = beforeHead.getNext();
			}
			
			// define new head and tail
			beforeHead.setNext(new_node);
			new_node.setNext(head);
			tail = new_node;
			totalPrisoners++;
		}
		
		// if linked list is empty
		else {
			head = new_node;
			head.setNext(head);
			tail = new_node;
			tail.setNext(tail);
			totalPrisoners++;
		}
	}
	
	/**
	 * deletes the node passed as a parameter from the linked list
	 * @param prisoner -- prisoner node to be deleted from linked list
	 */
	public void deleteNode(Node prisoner) {
		
		int prisonerNumber = prisoner.getData();
		Node temp = head; // store head node
		// if head node is the prisoner node to be removed
		if (temp != null && temp.getData() == prisonerNumber) {
			head = temp.getNext(); // changed head to node passed in paramter
			tail.setNext(head);		
			totalPrisoners--; // decrements size of linked list by 1
			return;
		}
		
		// traverses the linked list and searches for the prisoner node to be removed, 
		// while keeping track of the previous node and changing temp to temp.next
		while (temp != null && temp.getData() != prisonerNumber) {
			prisoner.setPrev(temp);
			temp = temp.getNext();
		}
		
		// if the prisoner node to be deleted was not present in the linked list
		if (temp == null)
			return;
		
		// unlinks the prisoner node from the linked list
		prisoner.getPrev().setNext(temp.getNext());
		totalPrisoners--;	// decrements size of linked list by 1
		
	}
}
