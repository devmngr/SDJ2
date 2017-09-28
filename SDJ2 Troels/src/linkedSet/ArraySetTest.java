package linkedSet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ArraySetTest {

	
	private ArraySet<String> set;

	   @Before
	   public void setUp() throws Exception
	   {
	      set = new ArraySet(5, false);
	   }

	   @After
	   public void tearDown() throws Exception
	   {
	   }
	@Test
	public void testAdd() {
		assertEquals(0, set.size());
		assertFalse(set.contains("A"));
		set.add("A");
		assertTrue(set.contains("A"));
		assertEquals(1, set.size());
		
		assertFalse(set.contains("B"));
		set.add("B");
		assertTrue(set.contains("B"));
		assertEquals(2, set.size());
		
		assertFalse(set.contains("C"));
		set.add("C");
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
		
		assertFalse(set.contains("D"));
		assertFalse(set.contains("E"));
		set.add("D");
		set.add("E");
		assertTrue(set.contains("D"));
		assertTrue(set.contains("E"));
		assertEquals(5, set.size());
		
	}

	@Test
	public void testAddOnFull() {
		assertFalse(set.contains("A"));
		assertFalse(set.contains("B"));
		assertFalse(set.contains("C"));
		set.add("A");
		set.add("B");
		set.add("C");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
		
		
		set.add("D");
		set.add("E");
		assertTrue(set.contains("D"));
		assertTrue(set.contains("E"));
		assertEquals(5, set.size());
		
		try{
			set.add("Z");
		}
		catch(IllegalStateException e)
		{
			//fail ("The ArraySet is full");
		}
		
		
	}

	@Test
	public void testAddNullElement() {

		
		assertFalse(set.contains("A"));
		assertFalse(set.contains("B"));
		assertFalse(set.contains("C"));
		set.add("A");
		set.add("B");
		set.add("C");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
		
		
		try{
			assertFalse(set.contains(null));
			set.add(null);
			assertTrue(set.contains(null));
		}
		catch(IllegalArgumentException e){
			//fail("No null allowed");
		}
	}

	@Test
	public void testRemove() {

		set.add("A");
		set.add("B");
		set.add("C");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
		
		set.remove("B");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("C"));
		assertEquals(2, set.size());
		
		set.remove("C");
		set.remove("A");
		assertFalse(set.contains("A"));
		assertFalse(set.contains("B"));
		assertFalse(set.contains("C"));
		assertEquals(0, set.size());
		
		
		
		
	}
	
	@Test (expected =IllegalStateException.class)
	public void testRemoveException() {
			set.remove("X");
		
	}

	@Test
	public void testContains() {
	
		assertFalse(set.contains("A"));
		assertFalse(set.contains("B"));
		assertFalse(set.contains("C"));

		set.add("A");
		set.add("B");
		set.add("C");
		
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
		
		assertFalse(set.contains("a"));
		assertFalse(set.contains("b"));
		assertFalse(set.contains("c"));
		
	}

	@Test
	public void testIsEmpty() {
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		
		set.add("A");
		assertFalse(set.isEmpty());
		assertEquals(1, set.size());
		
		set.add("B");
		set.add("C");
		assertFalse(set.isEmpty());
		assertEquals(3, set.size());
		
		set.remove("B");
		set.remove("A");
		set.remove("C");
		assertTrue(set.isEmpty());
		assertEquals(0, set.size());
		
	}

	@Test
	public void testSize() {

		assertEquals(0, set.size());
		set.add("A");
		assertEquals(1, set.size());
		
		set.add("B");
		assertEquals(2, set.size());
		set.add("C");
		set.add("D");
		assertEquals(4, set.size());
		set.remove("B");
		assertEquals(3, set.size());
		set.remove("A");
		set.remove("C");
		assertEquals(1, set.size());
		set.remove("D");
		assertEquals(0, set.size());
		
	}

	@Test
	public void testIsSubset() {
		LinkedSet<String> set2 = new LinkedSet<>(true);
		set.add("A");
		set.add("B");
		set.add("C");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());

		set2.add("A");
		set2.add("B");
		set2.add("C");
		set2.add("Y");
		set2.add("Z");
		assertTrue(set2.contains("A"));
		assertTrue(set2.contains("B"));
		assertTrue(set2.contains("C"));
		assertTrue(set2.contains("Y"));
		assertTrue(set2.contains("Z"));
		assertEquals(5, set2.size());

		assertTrue(set.isSubset(set2));
		assertFalse(set2.isSubset(set));
		assertTrue(set.isSubset(set));
		assertTrue(set2.isSubset(set2));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIsSubsetNullParameter() {
		set.isSubset(null);
	}

	@Test
	public void testIntersection() {

		
		LinkedSet<String> set2 = new LinkedSet<String>(true);
		set.add("A");
		set.add("B");
		set.add("C");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
			
		set2.add("A");
		set2.add("B");
		set2.add("C");
		set2.add("Y");
		set2.add("Z");
		assertTrue(set2.contains("A"));
		assertTrue(set2.contains("B"));
		assertTrue(set2.contains("C"));
		assertTrue(set2.contains("Y"));
		assertTrue(set2.contains("Z"));
		assertEquals(5, set2.size());
		
		ArraySet<String> set3 = (ArraySet<String>) set.intersection(set2);
		assertEquals(3, set3.size());
		assertTrue(set3.contains("A"));
		assertTrue(set3.contains("B"));
		assertTrue(set3.contains("C"));
		
		assertFalse(set3.contains("Y"));
		assertFalse(set3.contains("Z"));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testIntersectionNullParameter() {

		set.intersection(null);
		
	}
	@Test
	public void testUnion() {

		LinkedSet<String> set2 = new LinkedSet<String>(true);
		set.add("A");
		set.add("B");
		set.add("C");
		assertTrue(set.contains("A"));
		assertTrue(set.contains("B"));
		assertTrue(set.contains("C"));
		assertEquals(3, set.size());
			
		set2.add("A");
		set2.add("B");
		set2.add("C");
		set2.add("Y");
		set2.add("Z");
		assertTrue(set2.contains("A"));
		assertTrue(set2.contains("B"));
		assertTrue(set2.contains("C"));
		assertTrue(set2.contains("Y"));
		assertTrue(set2.contains("Z"));
		assertEquals(5, set2.size());
		
		ArraySet<String> set3 = (ArraySet<String>) set.union(set2);	
		assertEquals(5, set3.size());
		assertTrue(set3.contains("A"));
		assertTrue(set3.contains("B"));
		assertTrue(set3.contains("C"));
		assertTrue(set3.contains("Y"));
		assertTrue(set3.contains("Z"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUnionNullParameter() {

		set.union(null);

	}
}
