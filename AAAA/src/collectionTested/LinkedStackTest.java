package collectionTested;

import static org.junit.Assert.*;
import org.junit.*;


public class LinkedStackTest {

	private LinkedStack<String> linkedStack;

	@Before
	public void setUp() throws Exception {
		linkedStack = new LinkedStack<String>(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPush() {

		linkedStack.push("A");
		assertEquals(1, linkedStack.size());
		assertEquals("A", linkedStack.peek());

		linkedStack.push("B");
		assertEquals(2, linkedStack.size());
		assertEquals("B", linkedStack.peek());

		try {
			linkedStack.push(null);
			assertEquals(3, linkedStack.size());
			assertEquals(null, linkedStack.peek());

	         linkedStack.push("C");
	         assertEquals(4, linkedStack.size());
	         assertEquals("C", linkedStack.peek());

	         linkedStack.push(null);
	         assertEquals(5, linkedStack.size());
	         assertEquals(null, linkedStack.peek());
		}
		catch(IllegalArgumentException e)
		{
			
		}
		
	}

	@Test
	public void testPushNULL() {

		try{
			linkedStack.push(null);
			assertEquals(1, linkedStack.size());
			assertEquals(null, linkedStack.peek());
			
			linkedStack.push("A");
			linkedStack.push(null);
			assertEquals(3, linkedStack.size());
			assertEquals(null, linkedStack.peek());
		}
		catch (IllegalArgumentException e){
			
			fail("NULL not allowed");
			//assertTrue(linkedStack.size()==0);
		}
	}

	@Test
	public void testPop() {
		linkedStack.push("A");
		assertEquals(1, linkedStack.size());
		assertEquals("A", linkedStack.pop());
		assertEquals(0, linkedStack.size());
		
		linkedStack.push("B");
		linkedStack.push("C");
		assertEquals("C", linkedStack.pop());
		assertEquals("B", linkedStack.pop());
	

		try{
			linkedStack.push(null);
			assertEquals(null, linkedStack.pop());
			
			linkedStack.push("A");
			linkedStack.push(null);
			assertEquals(null, linkedStack.pop());
			assertEquals("A", linkedStack.pop());
			
		}
		catch (IllegalArgumentException e)
		{
			
		}
		
	}
	@Test (expected = IllegalStateException.class)
	public void testPopExeption() {

		linkedStack.pop();
	}

	@Test
	public void testPeek() {
		linkedStack.push("A");
		assertEquals(1, linkedStack.size());
		assertEquals("A", linkedStack.peek());
		
		linkedStack.push("B");
		assertEquals("B", linkedStack.peek());
		linkedStack.push("C");
		assertEquals(linkedStack.peek(), linkedStack.pop());

		try{
			linkedStack.push(null);
			assertEquals(null, linkedStack.peek());
			
			linkedStack.push("A");
			linkedStack.push(null);
			assertEquals(null, linkedStack.peek());
			linkedStack.pop();
			assertEquals("A", linkedStack.peek());
		
	}
	catch(IllegalArgumentException e)
		{
		
		}
	}
	@Test (expected = IllegalStateException.class)
	public void testPeekExeption() {

		linkedStack.peek();
	}

	@Test(expected = IllegalStateException.class)
	public void testIndexOfNotFound() {
		assertEquals(-1, linkedStack.indexOf("???"));
		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		assertEquals(-1, linkedStack.indexOf("X"));
	}

	@Test(expected = IllegalStateException.class)
	public void testIndexOfNotFoundNull() {
		
		assertEquals(-1, linkedStack.indexOf(null));
		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		assertEquals(-1, linkedStack.indexOf(null));
		
	}

	@Test
	public void testIndexOfFound() {
		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		assertEquals(2, linkedStack.indexOf("A"));
		assertEquals(0, linkedStack.indexOf("C"));
		linkedStack.push("D");
		linkedStack.push("E");
		linkedStack.push("F");
		assertEquals(5, linkedStack.indexOf("A"));
		
		try{
			linkedStack.push(null);
			assertEquals(0, linkedStack.indexOf(null));
			linkedStack.push(null);
			linkedStack.push("Z");
			linkedStack.push("X");
			linkedStack.push("W");
			assertEquals(0, linkedStack.indexOf("W"));
			assertEquals(7, linkedStack.indexOf("D"));
			assertEquals(3, linkedStack.indexOf(null));
		}
		catch(IllegalArgumentException e)
		{
			///ok
		}
	}

	@Test
	public void testIsEmpty() {
		assertTrue(linkedStack.isEmpty());
		linkedStack.push("A");
		assertFalse(linkedStack.isEmpty());
		linkedStack.push("B");
		linkedStack.push("C");
		assertFalse(linkedStack.isEmpty());
		linkedStack.pop();
		linkedStack.pop();
		assertFalse(linkedStack.isEmpty());
	
		linkedStack.pop();
		assertTrue(linkedStack.isEmpty());
		try{
			
			linkedStack.push(null);
			assertFalse(linkedStack.isEmpty());
			linkedStack.push(null);
			linkedStack.push("Z");
			assertFalse(linkedStack.isEmpty());
			linkedStack.pop();
			linkedStack.pop();
			linkedStack.pop();
			assertTrue(linkedStack.isEmpty());
			
			
		}
		catch(IllegalArgumentException e)
		{
			//ok
		}
	}

	@Test
	public void testSize() {

		assertEquals(0, linkedStack.size());
		linkedStack.push("A");
		assertEquals(1, linkedStack.size());
		linkedStack.push("B");
		linkedStack.push("C");
		assertEquals(3, linkedStack.size());
		assertEquals("C", linkedStack.pop());
		assertEquals(2, linkedStack.size());
		linkedStack.pop();
		linkedStack.pop();
		assertEquals(0, linkedStack.size());
	
		try{
			linkedStack.push(null);
			assertEquals(1, linkedStack.size());
			linkedStack.push(null);
			linkedStack.push("A");
			assertEquals(3, linkedStack.size());
			linkedStack.pop();
			linkedStack.pop();
			linkedStack.pop();
			assertEquals(0, linkedStack.size());
			
		}
	catch(IllegalArgumentException e)
		{
		//ok
		}
	}

	@Test
	public void testToString() {
		
		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		assertTrue(contains("C", "B", "A"));
		assertFalse(linkedStack.toString().contains("null"));
	
	}
	@Test
	public void testToStringAndNull() {

		linkedStack.push("A");
		linkedStack.push("B");
		linkedStack.push("C");
		linkedStack.push("D");
		try{
			linkedStack.push(null);
			linkedStack.push("E");
			linkedStack.push("F");
			assertTrue(contains("F","E","null","D","C","B","A"));
			assertTrue(linkedStack.toString().contains("null"));
			
		}
		catch(IllegalArgumentException e)
		{
			assertTrue(contains("D","C","B","A"));
			assertFalse(linkedStack.toString().contains("null"));
		}
	}
	
	private boolean contains(String... s)
	   {
	      // correct elements and order (cannot check if there are too many elements) 
	      String listString = linkedStack.toString();
	      if (s.length < 1)
	         return false;
	      int index1 = listString.indexOf(s[0]);
	      if (index1 == -1)
	         return false;
	      listString = replace(listString, s[0], '£');
	      if (s.length == 1)
	      {
	         return index1 > -1;
	      }
	      for (int i = 1; i < s.length; i++)
	      {
	         int index2 = listString.indexOf(s[i]);
	         if (index2 == -1)
	            return false;
	         listString = replace(listString, s[i], '£');
	         /*if (index1 > index2)
	            return false;*/
	         index1 = index2;
	      }
	      return true;
	   }

	   private String replace(String s, String target, char replacementChar)
	   {
	      String replace = "";
	      for (int k = 0; k < target.length(); k++)
	         replace += replacementChar;
	      int index = s.indexOf(target);
	      if (index < 0)
	         return s;
	      String s2 = s.substring(0, index) + replace
	            + s.substring(index + replace.length());
	      return s2;
	   }


}
