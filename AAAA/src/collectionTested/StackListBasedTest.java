package collectionTested;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackListBasedTest {

	private StackListBased<String> list;
	
	@Before
	public void setUp() throws Exception {
		list = new StackListBased<String>(true);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testPush() {

		list.push("A");
		assertEquals("A", list.peek());
		assertEquals(1, list.size());
		list.push("B");
		list.push("C");
		assertEquals("C", list.peek());
		assertEquals(3, list.size());
		list.pop();
		list.pop();
		list.pop();
		assertEquals(0, list.size());

	}

	@Test
	public void testPop() {
		list.push("A");
		list.push("B");
		list.push("C");
		list.push("D");
		list.push("E");
		assertEquals(5, list.size());
		assertEquals("E", list.peek());
		list.pop();
		assertEquals("D", list.peek());
		assertEquals(4, list.size());
		list.pop();
		list.pop();
		assertEquals("B", list.peek());
		assertEquals(2, list.size());
		list.pop();
		list.pop();
		assertEquals(0, list.size());

	}

	@Test
	public void testPeek() {
		list.push("A");
		assertEquals("A", list.peek());
		list.push("B");
		assertEquals("B", list.peek());
		list.push("C");
		list.push("D");
		list.push("E");
		assertEquals("E", list.peek());
	}

	@Test
	public void testIndexOF() {
		assertEquals(-1, list.indexOf("???"));
		assertEquals(-1, list.indexOf(null));
		list.push("A");
		assertEquals("A", list.peek());
		assertEquals(0, list.indexOf("A"));
		list.push("B");
		assertEquals(0, list.indexOf("B"));
		assertEquals(1, list.indexOf("A"));
		list.push("C");
		assertEquals(0, list.indexOf("C"));
		assertEquals(1, list.indexOf("B"));
		assertEquals(2, list.indexOf("A"));
		list.push("D");
		assertEquals(0, list.indexOf("D"));
		assertEquals(1, list.indexOf("C"));
		assertEquals(2, list.indexOf("B"));
		assertEquals(3, list.indexOf("A"));
		list.pop();
		assertEquals(0, list.indexOf("C"));
		assertEquals(1, list.indexOf("B"));
		assertEquals(2, list.indexOf("A"));

	}

	@Test
	public void testIsEmpty() {

		assertTrue(list.isEmpty());
		list.push("A");
		assertFalse(list.isEmpty());
		list.push("B");
		list.push("C");
		list.push("D");
		list.push("E");
		assertFalse(list.isEmpty());
		assertEquals(5, list.size());
		assertEquals("E", list.peek());
		list.pop();
		assertFalse(list.isEmpty());
		assertEquals("D", list.peek());
		assertEquals(4, list.size());
		list.pop();
		list.pop();
		assertFalse(list.isEmpty());
		assertEquals("B", list.peek());
		assertEquals(2, list.size());
		list.pop();
		assertFalse(list.isEmpty());
		list.pop();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, list.size());
		list.push("A");
		assertEquals(1, list.size());
		list.push("B");
		assertEquals(2, list.size());
		list.push("C");
		assertEquals(3, list.size());
		list.push("D");
		list.push("E");
		assertEquals(5, list.size());
		list.pop();
		assertEquals(4, list.size());
		list.pop();
		list.pop();
		assertEquals(2, list.size());
		list.pop();
		list.pop();
		assertEquals(0, list.size());

	}

	@Test
	public void testToString() {

		// format is not defined only order of elements
		list.push("$B$");
		list.push("$D$");
		list.push("$A$");
		list.push("$B$");
		list.push("$C$");
		list.push("$D$");
		assertTrue(containsToString("$D$", "$C$", "$B$", "$A$", "$D$", "$B$"));

		list.push(null);
		assertTrue(containsToString("null", "$D$", "$C$", "$B$", "$A$", "$D$",
				"$B$"));
		list.push("$C$");
		assertTrue(containsToString("$C$", "null", "$D$", "$C$", "$B$", "$A$",
				"$D$", "$B$"));
		list.push(null);
		assertTrue(containsToString("null", "$C$", "null", "$D$", "$C$", "$B$",
				"$A$", "$D$", "$B$"));

	}

	private boolean containsToString(String... s) {
		String listString = list.toString();
		// System.out.println(listString);
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
			if (index1 > index2)
				return false;
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
