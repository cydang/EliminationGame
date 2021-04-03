package cs146F20.dang.project1;

/**
 * Creates circular singly linked list of prisoner nodes and determines which position you
 * should stand in to win freedom if there are n prisoners and every k prisoners are eliminated
 * @author chloedang
 */
public class EliminationGame {
	
	public PrisonerLinkedList prisonerLineup; //prisoner lineup in the form of a linked list
	
	/**
	 * initializes prisoner lineup
	 */
	public EliminationGame() {
		prisonerLineup = new PrisonerLinkedList();
	}
	
	/**
	 * creates lineup of prisoners by adding a number of nodes specified in the parameter 
	 * @param n -- total number of prisoners to be added
	 * @return prisonerLineup -- circular singly linked list containing prisoners
	 */ 
	public PrisonerLinkedList createLineup(int n) {
		
		long start = System.currentTimeMillis(); // millis from Jan 1st, 1970
		int i = 1;
		while (i <= n) {
			prisonerLineup.appendAtEnd(i);
			i++;
		}
		long end = System.currentTimeMillis(); // millis from Jan 1st, 1970
		System.out.println("Difference between start and end time to create lineup: " + (end - start));
		return prisonerLineup;
	}
	
	/**
	 * elimination process of every k prisoners in a an n number of prisoners until one prisoner remains,
	 * determining which position to stand in to be freed
	 * @param k -- every k prisoners are eliminated
	 * @return freedPrisoner -- position one should stand in to be freed
	 */
	public int eliminatePrisoner(int k) {
		
		long start = System.currentTimeMillis(); // millis from Jan 1st, 1970
		Node freedPrisoner = null;
		Node currentPrisoner = prisonerLineup.head; // currentPrisoner starting from first prisoner in linked list
		
		if (currentPrisoner != null) {
			// deletes nodes until one remains
			while (prisonerLineup.size() != 1) {
				int i = 1;
				// traverses list for every k prisoners
				while (i <= k) {
					currentPrisoner = currentPrisoner.getNext();
					i++;
				}
				long startDelete = System.currentTimeMillis(); // millis from Jan 1st, 1970
				prisonerLineup.deleteNode(currentPrisoner);
				long endDelete = System.currentTimeMillis();
				System.out.println("Difference between start and end time to delete single node: " + (endDelete - startDelete));
				currentPrisoner = currentPrisoner.getNext(); //sets currentPrisoner to be the node after the most recent eliminated node
			}
			
			freedPrisoner = prisonerLineup.head;
		}
		long end = System.currentTimeMillis(); // millis from Jan 1st, 1970
		System.out.println("Difference between start and end time to eliminate prisoners and find the winner: " + (end - start));	// print time to delete prisoners and find the winner
		return freedPrisoner.getData();
	}
}
