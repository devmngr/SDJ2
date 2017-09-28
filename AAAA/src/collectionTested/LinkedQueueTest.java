package collectionTested;

import static org.junit.Assert.*;
import org.junit.*;

public class LinkedQueueTest {

	private QueueADT<String> q;

	@Before
	public void setUp() throws Exception {
		q = new LinkedQueue(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnqueue() {

		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(3, q.size());
		assertEquals("A", q.dequeue());
		assertEquals(2, q.size());
		q.enqueue("D");
		assertEquals(3, q.size());
		assertEquals("B", q.dequeue());
		q.dequeue();
		assertEquals(1, q.size());
		q.dequeue();
		assertEquals(0, q.size());
		q.enqueue("A");
		assertEquals(1, q.size());
		q.dequeue();
	}

	@Test
	public void testEnqueueNull() {
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(3, q.size());
		assertEquals("A", q.dequeue());
		assertEquals("B", q.dequeue());
		assertEquals("C", q.dequeue());
		assertEquals(0, q.size());

		try {
			q.enqueue(null);
			assertEquals(1, q.size());
			q.enqueue("D");
			assertEquals(2, q.size());
			q.enqueue(null);
			assertEquals(3, q.size());
			assertEquals(null, q.dequeue());
			assertEquals("D", q.dequeue());
			assertEquals(null, q.dequeue());
			assertEquals(0, q.size());
		} catch (IllegalArgumentException e) {
			assertTrue(q.size() == 0);
			fail("Null elements not allowed");
		}
	}

	@Test
	public void testDequeue() {
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");

		assertEquals(5, q.size());
		assertEquals("A", q.dequeue());
		assertEquals(4, q.size());

		assertEquals("B", q.dequeue());
		assertEquals(3, q.size());

		assertEquals("C", q.dequeue());
		assertEquals("D", q.dequeue());
		assertEquals(1, q.size());
		assertEquals("E", q.dequeue());
		assertEquals(0, q.size());
	}

	@Test(expected = IllegalStateException.class)
	public void testDequeueEmpty() {
		q.dequeue();
	}

	@Test
	public void testFirst() {
		q.enqueue("A");
		assertEquals("A", q.first());
		q.dequeue();

		q.enqueue("B");
		q.enqueue("A");
		assertEquals("B", q.first());
		q.dequeue();
		q.dequeue();

	}

	@Test(expected = IllegalStateException.class)
	public void testFirstEmpty() {
		q.first();
	}

	@Test(expected = IllegalStateException.class)
	public void testIndexOfNotFound()
	{
		assertEquals(-1, q.indexOf("???"));
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(-1, q.indexOf("X"));
	}

	@Test(expected = IllegalStateException.class)
	public void testIndexOfNotFoundNull() {
		assertEquals(-1, q.indexOf(null));
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(-1, q.indexOf(null));
		
		
	}

	@Test
	public void testIndexFound()
	{
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(0, q.indexOf("A"));
		assertEquals(2, q.indexOf("C"));
		q.enqueue("D");
		q.enqueue("E");
		q.enqueue("F");
		assertEquals(0, q.indexOf("A"));
		assertEquals(5, q.indexOf("F"));
		try{
			
			q.enqueue(null);
			assertEquals(6, q.indexOf(null));
			q.enqueue(null);
			q.enqueue("Z");
			q.enqueue("W");
			q.enqueue("X");
			assertEquals(0, q.indexOf("A"));
			assertEquals(6, q.indexOf(null));
			assertEquals(8, q.indexOf("Z"));
			
		}
		catch(IllegalArgumentException e)
		{
			//ok
		}
	}

	@Test
	public void testIsEmpty() {
		assertTrue(q.isEmpty());
		q.enqueue("A");
		assertFalse(q.isEmpty());
		q.enqueue("B");
		q.enqueue("C");
		assertFalse(q.isEmpty());
		q.dequeue();
		q.dequeue();
		assertFalse(q.isEmpty());

		q.dequeue();
		assertTrue(q.isEmpty());
		try {

			q.enqueue(null);
			assertFalse(q.isEmpty());
			q.enqueue(null);
			q.enqueue("Z");
			assertFalse(q.isEmpty());
			q.dequeue();
			q.dequeue();
			q.dequeue();
			assertTrue(q.isEmpty());

		} catch (IllegalArgumentException e) {
			// ok
		}

	}

	@Test
	public void testSize() {
		assertEquals(0, q.size());
		q.enqueue("A");
		assertEquals(1, q.size());
		q.enqueue("B");
		q.enqueue("C");
		assertEquals(3, q.size());
		assertEquals("A", q.dequeue());
		assertEquals(2, q.size());
		q.dequeue();
		q.dequeue();
		assertEquals(0, q.size());

		try {
			q.enqueue(null);
			assertEquals(1, q.size());
			q.enqueue(null);
			q.enqueue("Z");
			assertEquals(3, q.size());
			q.dequeue();
			q.dequeue();
			q.dequeue();
			assertEquals(0, q.size());

		} catch (IllegalArgumentException e) {
			// ok
		}
	}

	@Test
	public void testToString() {
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		assertTrue(contains("C", "B", "A"));
		assertFalse(q.toString().contains("null"));
	}

	@Test
	public void testToStringAndNull() {

		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");

		try {
			q.enqueue(null);
			q.enqueue("E");
			q.enqueue("F");
			assertTrue(contains("F", "E", "null", "D", "C", "B", "A"));
			assertTrue(q.toString().contains("null"));

		} catch (IllegalArgumentException e) {
			assertTrue(contains("D", "C", "B", "A"));
			assertFalse(q.toString().contains("null"));
		}
	}

	private boolean contains(String... s) {
		// correct elements and order (cannot check if there are too many
		// elements)
		String listString = q.toString();
		if (s.length < 1)
			return false;
		int index1 = listString.indexOf(s[0]);
		if (index1 == -1)
			return false;
		listString = replace(listString, s[0], '£');
		if (s.length == 1) {
			return index1 > -1;
		}
		for (int i = 1; i < s.length; i++) {
			int index2 = listString.indexOf(s[i]);
			if (index2 == -1)
				return false;
			listString = replace(listString, s[i], '£');
			/*
			 * if (index1 > index2) return false;
			 */
			index1 = index2;
		}
		return true;
	}

	private String replace(String s, String target, char replacementChar) {
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
