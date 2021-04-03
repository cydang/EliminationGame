package cs146F20.dang.project1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit testing that tests multiple different lineups and elimination processes to evaluate whether 
 * prisoners were eliminated accordingly and the expected freed prisoner remains in the linked list
 * @author chloedang
 */
class EliminationGameTest {

	EliminationGame prisoners;
	
	/**
	 * Instantiate EliminationGameTest to start each test with a fresh linked list lineup of prisoners
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		prisoners = new EliminationGame();
	}

	/**
	 * Tests elimination of every 2 prisoners in a lineup of 6 prisoners
	 * output should equal 1
	 */
	@Test
	void test1() {
		assertTrue(prisoners.prisonerLineup.isEmpty()); //before inserting, list is empty 
		assertEquals(0,prisoners.prisonerLineup.size()); // Size is 0
		prisoners.createLineup(6);
		assertFalse(prisoners.prisonerLineup.isEmpty()); // after inserting element, list is not empty
		assertEquals(1,prisoners.eliminatePrisoner(2));
		assertEquals(1,prisoners.prisonerLineup.size()); //size is 1
	}
	
	/**
	 * Tests elimination of every 9 prisoners in a lineup of 1 prisoner
	 * output should equal 1
	 */
	@Test
	void test2() {
		assertTrue(prisoners.prisonerLineup.isEmpty());  
		assertEquals(0,prisoners.prisonerLineup.size()); 
		prisoners.createLineup(1);
		assertFalse(prisoners.prisonerLineup.isEmpty()); 
		assertEquals(1,prisoners.eliminatePrisoner(9));
		assertEquals(1,prisoners.prisonerLineup.size()); 
	}
	
	/**
	 * Tests elimination of every 7 prisoners in a lineup of 7 prisoners
	 * output should equal 4
	 */
	@Test
	void test3() {
		assertTrue(prisoners.prisonerLineup.isEmpty()); 
		assertEquals(0,prisoners.prisonerLineup.size()); 
		prisoners.createLineup(7);
		assertFalse(prisoners.prisonerLineup.isEmpty()); 
		assertEquals(4,prisoners.eliminatePrisoner(7));
		assertEquals(1,prisoners.prisonerLineup.size()); 
	}
	
	/**
	 * Tests elimination of every 8 prisoners in a lineup of 12 prisoners
	 * output should equal 2
	 */
	@Test
	void test4() {
		assertTrue(prisoners.prisonerLineup.isEmpty());  
		assertEquals(0,prisoners.prisonerLineup.size()); 
		prisoners.createLineup(12);
		assertFalse(prisoners.prisonerLineup.isEmpty()); 
		assertEquals(2,prisoners.eliminatePrisoner(8));
		assertEquals(1,prisoners.prisonerLineup.size()); 
	}
	
	/**
	 * Tests elimination of every 1 prisoner in a lineup of 5 prisoners
	 * output should equal 3
	 */
	@Test
	void test5() {
		assertTrue(prisoners.prisonerLineup.isEmpty());  
		assertEquals(0,prisoners.prisonerLineup.size()); 
		prisoners.createLineup(5);
		assertFalse(prisoners.prisonerLineup.isEmpty()); 
		assertEquals(3,prisoners.eliminatePrisoner(1));
		assertEquals(1,prisoners.prisonerLineup.size());
	}

}
