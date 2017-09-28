package linkedList;

import static org.junit.Assert.*;
import linkedQueue.LinkedQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.QueueADT;
sadasdasdas
public class ArrayListTest {
	private ArrayList<String> arr;

	@Before
	public void setUp() throws Exception {
		arr = new ArrayList<String>(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddElement() {
		assertEquals(null,arr.get(0));
		arr.add("A");
		assertEquals(1, arr.size());
		assertEquals("A", arr.get(0));
		arr.add("B");
		arr.add("C");
		assertEquals(3, arr.size());
		assertEquals("C", arr.get(2));
	}

	@Test
	public void testAddElementAtIndex() {
		assertEquals(null,arr.get(0));
		arr.add(0, "A");
		assertEquals("A",arr.get(0));
		arr.add(1, "B");
		assertEquals("B", arr.get(1));
		arr.add("C");
		arr.add(0, "Z");
		assertEquals("Z", arr.get(0));
		assertEquals("A", arr.get(1));
		assertEquals("B", arr.get(2));
		assertEquals("C", arr.get(3));
		assertEquals(null, arr.get(4));
		
	}

	@Test
	public void testSetElementAtIndex() {

		assertEquals(null,arr.get(0));
		arr.set(0, "A");
		assertEquals(0, arr.size());
		arr.add("A");
		assertEquals(1, arr.size());
		assertEquals("A", arr.get(0));
		arr.add("B");
		assertEquals("B", arr.get(1));
		arr.add("C");
		assertEquals(3, arr.size());
		assertEquals("C", arr.get(2));
		arr.set(2, "X");
		assertEquals(3, arr.size());
		assertEquals("X", arr.get(2));
		assertEquals("B", arr.get(1));
		arr.add("D");
		assertEquals(4, arr.size());
		assertEquals("D", arr.get(3));
		assertEquals(null,arr.get(4));
		
		
	}
	@Test
	public void testGetAtIndex() {
		assertEquals(null,arr.get(0));
		arr.add("A");
		assertEquals(1, arr.size());
		arr.add("B");
		arr.add("C");
		arr.add("D");
		assertEquals(4, arr.size());
		
		assertEquals("A", arr.get(0));
		assertEquals("B", arr.get(1));
		assertEquals("C", arr.get(2));
		assertEquals("D", arr.get(3));
		assertEquals(null,arr.get(4));
		
	}
	@Test
	public void testRemoveAtIndex() {

		
		
		
	}
	@Test
	public void testRemoveElement() {

		
	}

	@Test
	public void testIndexOfElement() {
		arr.add("A");
		assertEquals(1, arr.size());
		assertEquals("A", arr.get(0));
		arr.add("B");
		arr.add("C");
		assertEquals(3, arr.size());
		
		assertEquals(0, arr.indexOf("A"));
		assertEquals(1, arr.indexOf("B"));
		assertEquals(2, arr.indexOf("C"));
	}
	@Test
	public void testContainsElement() {

	}
	@Test
	public void testIsEmpty() {
		assertTrue(arr.isEmpty());
		assertEquals(0, arr.size());
		
		arr.add("A");
		assertEquals(1, arr.size());
		assertFalse(arr.isEmpty());
		
		arr.add("A");
		arr.add("A");
		arr.add("A");
		assertFalse(arr.isEmpty());
		assertEquals(4, arr.size());
	}
	@Test
	public void testSize() {
		assertEquals(0,arr.size());
		arr.add("A");
		assertEquals(1,arr.size());
		arr.add("B");
		arr.add("C");
		assertEquals(3,arr.size());
		arr.add(3, "Z");
		assertEquals(4, arr.size());
		arr.add(3, "Q");
		assertEquals(5, arr.size());
		
		//problem remove
		arr.remove(2);
		assertEquals(4,arr.size());
		
		
		
	}
	
	
	@Test
	public void testIsBounded()
	{
		ArrayList<String> temp= new ArrayList<String>(5,true);
		assertFalse(temp.isBounded());
		ArrayList<String> temp2= new ArrayList<String>(true);
		assertTrue(temp2.isBounded());
		assertTrue(arr.isBounded());
		
	}
	@Test
	public void testToString() {

	}

}
