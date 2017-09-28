package adaptor;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestANDRunTest {

	private IAdaptor<String> adaptor;

	@Before
	public void adaptorUp() throws Exception{
		adaptor = new Adaptor<String>();
	}
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {

		assertEquals(0, adaptor.size());
		assertFalse(adaptor.contains("A"));
		adaptor.add("A");
		assertTrue(adaptor.contains("A"));
		assertEquals(1, adaptor.size());

		assertFalse(adaptor.contains("B"));
		adaptor.add("B");
		assertTrue(adaptor.contains("B"));
		assertEquals(2, adaptor.size());

		assertFalse(adaptor.contains("C"));
		adaptor.add("C");
		assertTrue(adaptor.contains("C"));
		assertEquals(3, adaptor.size());

		assertFalse(adaptor.contains("D"));
		assertFalse(adaptor.contains("E"));
		adaptor.add("D");
		adaptor.add("E");
		assertTrue(adaptor.contains("D"));
		assertTrue(adaptor.contains("E"));
		assertEquals(5, adaptor.size());
	}

	@Test
	public void testAddDuplicate() {

		assertEquals(0, adaptor.size());
		assertFalse(adaptor.contains("A"));
		adaptor.add("A");
		assertTrue(adaptor.contains("A"));
		assertEquals(1, adaptor.size());

		assertFalse(adaptor.contains("B"));
		adaptor.add("B");
		assertTrue(adaptor.contains("B"));
		assertEquals(2, adaptor.size());

		assertFalse(adaptor.contains("C"));
		adaptor.add("C");
		assertTrue(adaptor.contains("C"));
		assertEquals(3, adaptor.size());

		adaptor.add("A");
		assertEquals(3, adaptor.size());
		assertTrue(adaptor.contains("A"));

		adaptor.add("D");
		assertTrue(adaptor.contains("D"));
		assertEquals(4, adaptor.size());
		adaptor.add("D");
		assertEquals(4, adaptor.size());
		assertTrue(adaptor.contains("D"));
	}

	@Test
	public void testAddNullParameter() {
		assertFalse(adaptor.contains("A"));
		assertFalse(adaptor.contains("B"));
		assertFalse(adaptor.contains("C"));
		adaptor.add("A");
		adaptor.add("B");
		adaptor.add("C");
		assertTrue(adaptor.contains("A"));
		assertTrue(adaptor.contains("B"));
		assertTrue(adaptor.contains("C"));
		assertEquals(3, adaptor.size());

		try {
			assertFalse(adaptor.contains(null));
			adaptor.add(null);
			assertTrue(adaptor.contains(null));
		} catch (IllegalArgumentException e) {
			// fail("No null allowed");
		}

	}

	@Test
	public void testRemove() {

		adaptor.add("A");
		adaptor.add("B");
		adaptor.add("C");
		assertTrue(adaptor.contains("A"));
		assertTrue(adaptor.contains("B"));
		assertTrue(adaptor.contains("C"));
		assertEquals(3, adaptor.size());

		adaptor.remove("B");
		assertTrue(adaptor.contains("A"));
		assertTrue(adaptor.contains("C"));
		assertEquals(2, adaptor.size());

		adaptor.remove("C");
		adaptor.remove("A");
		assertFalse(adaptor.contains("A"));
		assertFalse(adaptor.contains("B"));
		assertFalse(adaptor.contains("C"));
		assertEquals(0, adaptor.size());
	}

	@Test(expected = IllegalStateException.class)
	public void testRemoveException() {
			adaptor.remove("X");		
	}

	@Test
	public void testContains() {
		assertFalse(adaptor.contains("A"));
		assertFalse(adaptor.contains("B"));
		assertFalse(adaptor.contains("C"));

		adaptor.add("A");
		adaptor.add("B");
		adaptor.add("C");

		assertTrue(adaptor.contains("A"));
		assertTrue(adaptor.contains("B"));
		assertTrue(adaptor.contains("C"));
		assertEquals(3, adaptor.size());

		assertFalse(adaptor.contains("a"));
		assertFalse(adaptor.contains("b"));
		assertFalse(adaptor.contains("c"));

	}
	@Test
	public void testSize() {

		assertEquals(0, adaptor.size());
		adaptor.add("A");
		assertEquals(1, adaptor.size());

		adaptor.add("B");
		assertEquals(2, adaptor.size());
		adaptor.add("C");
		adaptor.add("D");
		assertEquals(4, adaptor.size());
		adaptor.remove("B");
		assertEquals(3, adaptor.size());
		adaptor.remove("A");
		adaptor.remove("C");
		assertEquals(1, adaptor.size());
		adaptor.remove("D");
		assertEquals(0, adaptor.size());
	}

}
