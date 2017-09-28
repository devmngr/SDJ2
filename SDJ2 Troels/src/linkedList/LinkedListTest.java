package linkedList;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	private ListADT<String> list;

	   @Before
	   public void setUp() throws Exception
	   {
	      list = new LinkedList<String>(true);
	   }

	   @After
	   public void tearDown() throws Exception
	   {
	   }

	   @Test
	   public void testAddIndex()
	   {
	      list.add(0, "$B$");
	      assertTrue(list.size() == 1 && containsUsingGet("$B$"));
	      list.add(0, "$A$");
	      assertTrue(list.size() == 2 && containsUsingGet("$A$", "$B$"));
	      list.add(2, "$D$");
	      assertTrue(list.size() == 3 && containsUsingGet("$A$", "$B$", "$D$"));
	      list.add(2, "$C$");
	      assertTrue(list.size() == 4 && containsUsingGet("$A$", "$B$", "$C$", "$D$"));
	      list.add(2, "$C$");
	      assertTrue(list.size() == 5
	            && containsUsingGet("$A$", "$B$", "$C$", "$C$", "$D$"));
	      list.add(2, "$C$");
	      assertTrue(list.size() == 6
	            && containsUsingGet("$A$", "$B$", "$C$", "$C$", "$C$", "$D$"));

	      try
	      {
	         list.add(0, null);
	         assertTrue(list.size() == 7
	               && containsUsingGet(null, "$A$", "$B$", "$C$", "$C$", "$C$", "$D$"));
	         list.add(0, null);
	         assertTrue(list.size() == 8
	               && containsUsingGet(null, null, "$A$", "$B$", "$C$", "$C$", "$C$",
	                     "$D$"));
	         list.add(3, null);
	         assertTrue(list.size() == 9
	               && containsUsingGet(null, null, "$A$", null, "$B$", "$C$", "$C$",
	                     "$C$", "$D$"));
	         list.add(7, null);
	         assertTrue(list.size() == 10
	               && containsUsingGet(null, null, "$A$", null, "$B$", "$C$", "$C$",
	                     null, "$C$", "$D$"));
	         list.set(3, "$P$");
	         list.set(7, "$Q$");
	         assertTrue(list.size() == 10
	               && containsUsingGet(null, null, "$A$", "$P$", "$B$", "$C$", "$C$",
	                     "$Q$", "$C$", "$D$"));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testAddIndexException1()
	   {
	      list.add(1, "$B$");
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testAddIndexException2()
	   {
	      list.add(0, "$A$");
	      list.add(1, "$B$");
	      list.add(3, "$D$");
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testAddIndexException3()
	   {
	      list.add(0, "$A$");
	      list.add(1, "$B$");
	      list.add(-1, "$D$");
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testAddIndexException4()
	   {
	      try
	      {
	         list.add(1, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.add(1, "???");
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testAddIndexException5()
	   {
	      list.add(0, "$A$");
	      list.add(1, "$B$");
	      try
	      {
	         list.add(3, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.add(3, "???");
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testAddIndexException6()
	   {
	      list.add(0, "$A$");
	      list.add(1, "$B$");
	      try
	      {
	         list.add(-1, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.add(-1, "???");
	      }
	   }

	   @Test
	   public void testAddElement()
	   {
	      list.add("$A$");
	      assertTrue(list.size() == 1 && containsUsingGet("$A$"));
	      list.add("$B$");
	      assertTrue(list.size() == 2 && containsUsingGet("$A$", "$B$"));
	      list.add("$B$");
	      assertTrue(list.size() == 3 && containsUsingGet("$A$", "$B$", "$B$"));
	      list.add("$C$");
	      assertTrue(list.size() == 4 && containsUsingGet("$A$", "$B$", "$B$", "$C$"));
	      try
	      {
	         list.add(null);
	         assertTrue(list.size() == 5
	               && containsUsingGet("$A$", "$B$", "$B$", "$C$", null));
	         list.add(null);
	         assertTrue(list.size() == 6
	               && containsUsingGet("$A$", "$B$", "$B$", "$C$", null, null));
	         list.add(null);
	         assertTrue(list.size() == 7
	               && containsUsingGet("$A$", "$B$", "$B$", "$C$", null, null, null));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test
	   public void testSet()
	   {
	      list.add("$T$");
	      list.set(0, "$A$");
	      assertTrue(list.size() == 1 && containsUsingGet("$A$"));
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.set(0, "$X$");
	      assertTrue(list.size() == 4 && containsUsingGet("$X$", "$B$", "$C$", "$D$"));
	      list.set(3, "$Y$");
	      assertTrue(list.size() == 4 && containsUsingGet("$X$", "$B$", "$C$", "$Y$"));
	      list.set(1, "$Z$");
	      assertTrue(list.size() == 4 && containsUsingGet("$X$", "$Z$", "$C$", "$Y$"));
	      list.set(2, "$V$");
	      assertTrue(list.size() == 4 && containsUsingGet("$X$", "$Z$", "$V$", "$Y$"));

	      try
	      {
	         list.set(0, null);
	         assertTrue(list.size() == 4 && containsUsingGet(null, "$Z$", "$V$", "$Y$"));
	         list.set(3, null);
	         assertTrue(list.size() == 4 && containsUsingGet(null, "$Z$", "$V$", null));
	         list.set(1, null);
	         assertTrue(list.size() == 4 && containsUsingGet(null, null, "$V$", null));
	         list.set(2, null);
	         assertTrue(list.size() == 4 && containsUsingGet(null, null, null, null));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testSetException1()
	   {
	      list.set(0, "$A$");
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testSetException2()
	   {
	      try
	      {
	         list.set(0, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.set(0, "???");
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testSetException3()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.set(4, "$D$");
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testSetException4()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      try
	      {
	         list.set(4, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.set(4, "???");
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testSetException5()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.set(-1, "$D$");
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testSetException6()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      try
	      {
	         list.set(-1, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.set(-1, "???");
	      }
	   }

	   @Test
	   public void testGet()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$B$");
	      list.add("$D$");
	      assertEquals("$A$", list.get(0));
	      assertEquals("$B$", list.get(1));
	      assertEquals("$B$", list.get(2));
	      assertEquals("$D$", list.get(3));
	      try
	      {
	         list.set(0, null);
	         assertEquals(null, list.get(0));
	         assertEquals("$B$", list.get(1));
	         assertEquals("$B$", list.get(2));
	         assertEquals("$D$", list.get(3));
	         list.set(3, null);
	         assertEquals(null, list.get(3));
	         assertEquals("$B$", list.get(2));
	         assertEquals("$B$", list.get(1));
	         assertEquals(null, list.get(0));
	         list.set(2, null);
	         assertEquals(null, list.get(3));
	         assertEquals(null, list.get(2));
	         assertEquals("$B$", list.get(1));
	         assertEquals(null, list.get(0));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }

	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testGetException1()
	   {
	      list.get(0);
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testGetException2()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.get(4);
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testGetException3()
	   {
	      list.add("$A$");
	      list.add("$D$");
	      try
	      {
	         list.add(0, null);
	         list.add(null);
	         list.get(4);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.get(2);
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testGetException4()
	   {
	      list.add("$A$");
	      list.add("$D$");
	      try
	      {
	         list.add(0, null);
	         list.add(null);
	         list.get(-1);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.get(-1);
	      }
	   }

	   @Test
	   public void testRemoveIndex()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertEquals("$C$", list.remove(3)); // middle
	      assertTrue(list.size() == 4 && containsUsingGet("$A$", "$B$", "$B$", "$D$"));

	      assertEquals("$D$", list.remove(3)); // last
	      assertTrue(list.size() == 3 && containsUsingGet("$A$", "$B$", "$B$"));

	      assertEquals("$A$", list.remove(0)); // first
	      assertTrue(list.size() == 2 && containsUsingGet("$B$", "$B$"));

	      assertEquals("$B$", list.remove(0));
	      assertEquals("$B$", list.remove(0)); // emptying
	      assertTrue(list.size() == 0);

	      // adding all again and removing again
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertEquals("$C$", list.remove(3)); // middle
	      assertTrue(list.size() == 4 && containsUsingGet("$A$", "$B$", "$B$", "$D$"));

	      assertEquals("$D$", list.remove(3)); // last
	      assertTrue(list.size() == 3 && containsUsingGet("$A$", "$B$", "$B$"));

	      assertEquals("$A$", list.remove(0)); // first
	      assertTrue(list.size() == 2 && containsUsingGet("$B$", "$B$"));

	      assertEquals("$B$", list.remove(0));
	      assertEquals("$B$", list.remove(0)); // emptying
	      assertTrue(list.size() == 0);

	      try
	      {
	         // adding all again and removing again
	         list.add(null);
	         list.add(null);
	         list.add("$B$");
	         list.add("$C$");
	         list.add(null);
	         assertEquals("$C$", list.remove(3)); // middle
	         assertTrue(list.size() == 4 && containsUsingGet(null, null, "$B$", null));

	         assertEquals(null, list.remove(3)); // last
	         assertTrue(list.size() == 3 && containsUsingGet(null, null, "$B$"));

	         assertEquals(null, list.remove(0)); // first
	         assertTrue(list.size() == 2 && containsUsingGet(null, "$B$"));

	         assertEquals(null, list.remove(0));
	         assertEquals("$B$", list.remove(0)); // emptying
	         assertTrue(list.size() == 0);

	         // adding all again and removing again
	         list.add(null);
	         list.add(null);
	         list.add("$B$");
	         list.add("$C$");
	         list.add(null);
	         assertEquals("$C$", list.remove(3)); // middle
	         assertTrue(list.size() == 4 && containsUsingGet(null, null, "$B$", null));

	         assertEquals(null, list.remove(3)); // last
	         assertTrue(list.size() == 3 && containsUsingGet(null, null, "$B$"));

	         assertEquals(null, list.remove(0)); // first
	         assertTrue(list.size() == 2 && containsUsingGet(null, "$B$"));

	         assertEquals(null, list.remove(0));
	         assertEquals("$B$", list.remove(0)); // emptying
	         assertTrue(list.size() == 0);

	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testRemoveIndexException1()
	   {
	      list.remove(0);
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testRemoveIndexException2()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.remove(-1);
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testRemoveIndexException3()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.remove(4);
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testRemoveIndexException4()
	   {
	      try
	      {
	         list.add(null);
	         list.add("$B$");
	         list.add("$C$");
	         list.add(null);
	         list.remove(-1);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.remove(-1);
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testRemoveIndexException5()
	   {
	      try
	      {
	         list.add(null);
	         list.add("$B$");
	         list.add("$C$");
	         list.add(null);
	         list.remove(4);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.remove(4);
	      }
	   }

	   @Test(expected = IndexOutOfBoundsException.class)
	   public void testRemoveIndexException6()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      try
	      {
	         list.set(-1, null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         list.set(-1, "???");
	      }
	   }

	   @Test
	   public void testRemoveElement()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertEquals("$C$",list.remove("$C$")); // middle
	      assertTrue(list.size() == 3 && containsUsingGet("$A$", "$B$", "$D$"));
	      assertEquals("$A$",list.remove("$A$")); // first
	      assertTrue(list.size() == 2 && containsUsingGet("$B$", "$D$"));
	      assertEquals("$D$",list.remove("$D$")); // last
	      assertTrue(list.size() == 1 && containsUsingGet("$B$"));
	      assertEquals("$B$",list.remove("$B$")); // emptying
	      assertTrue(list.size() == 0);

	      // add and remove some again
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertEquals("$C$",list.remove("$C$")); // middle
	      assertTrue(list.size() == 3 && containsUsingGet("$A$", "$B$", "$D$"));
	      assertEquals("$A$",list.remove("$A$")); // first
	      assertTrue(list.size() == 2 && containsUsingGet("$B$", "$D$"));

	      // add and remove some again having duplicates
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertTrue(list.size() == 6
	            && containsUsingGet("$B$", "$D$", "$A$", "$B$", "$C$", "$D$"));
	      assertEquals("$C$",list.remove("$C$")); // middle
	      assertTrue(list.size() == 5
	            && containsUsingGet("$B$", "$D$", "$A$", "$B$", "$D$"));
	      assertEquals("$B$",list.remove("$B$")); // first
	      assertTrue(list.size() == 4 && containsUsingGet("$D$", "$A$", "$B$", "$D$"));
	      assertEquals("$B$",list.remove("$B$")); // another B
	      assertTrue(list.size() == 3 && containsUsingGet("$D$", "$A$", "$D$"));
	   }

	   @Test(expected = IllegalStateException.class)
	   public void testRemoveElementException1()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.remove("???");
	   }

	   @Test(expected = IllegalStateException.class)
	   public void testRemoveElementException2()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.remove(null);
	   }

	   @Test(expected = IllegalStateException.class)
	   public void testRemoveElementException3()
	   {
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      try
	      {
	         list.set(0, null);
	         list.set(3, null);
	         list.remove("???");
	      }
	      catch (IllegalArgumentException e)
	      {
	         assertEquals(null,list.remove(null));
	      }
	   }

	   @Test
	   public void testIndexOf()
	   {
	      assertEquals(-1, list.indexOf("???"));
	      assertEquals(-1, list.indexOf(null));
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.add("$B$");
	      assertEquals(0, list.indexOf("$A$"));
	      assertEquals(1, list.indexOf("$B$"));
	      assertEquals(3, list.indexOf("$C$"));
	      assertEquals(4, list.indexOf("$D$"));
	      assertEquals(-1, list.indexOf("???"));
	      assertEquals(-1, list.indexOf(null));
	      try
	      {
	         list.set(3, null);
	         assertEquals(3, list.indexOf(null));
	         list.set(0, null);
	         assertEquals(0, list.indexOf(null));
	         assertEquals(1, list.indexOf("$B$"));
	         assertEquals(4, list.indexOf("$D$"));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }

	   }

	   @Test
	   public void testContains()
	   {
	      assertFalse(list.contains("$A$"));
	      assertFalse(list.contains(null));
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      list.add("$B$");
	      assertTrue(list.contains("$A$"));
	      assertTrue(list.contains("$B$"));
	      assertTrue(list.contains("$C$"));
	      assertTrue(list.contains("$D$"));
	      assertFalse(list.contains("???"));
	      assertFalse(list.contains(null));
	      try
	      {
	         list.set(3, null);
	         assertTrue(list.contains(null));
	         list.set(0, null);
	         assertTrue(list.contains(null));
	         assertTrue(list.contains("$B$"));
	         assertTrue(list.contains("$D$"));
	         assertFalse(list.contains("$C$"));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test
	   public void testIsEmpty()
	   {
	      assertTrue(list.isEmpty());
	      list.add("$A$");
	      assertFalse(list.isEmpty());
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertFalse(list.isEmpty());
	      list.remove(0);
	      list.remove(0);
	      list.remove(0);
	      list.remove(0);
	      assertTrue(list.isEmpty());
	      try
	      {
	         list.add(null);
	         assertFalse(list.isEmpty());
	         list.add(null);
	         list.add("$C$");
	         assertFalse(list.isEmpty());
	         list.remove(0);
	         list.remove(0);
	         list.remove(0);
	         assertTrue(list.isEmpty());
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test
	   public void testSize()
	   {
	      assertEquals(0, list.size());
	      list.add("$A$");
	      assertEquals(1, list.size());
	      list.add(1, "$B$");
	      list.add(0, "$C$");
	      list.add(2, "$D$");
	      list.set(2, "$X$");
	      list.set(2, "$Y$");
	      assertEquals(4, list.size());
	      list.remove(0);
	      assertEquals(3, list.size());
	      list.remove("$Y$");
	      assertEquals(2, list.size());
	      list.remove(0);
	      list.remove(0);
	      assertEquals(0, list.size());
	      try
	      {
	         list.add(null);
	         assertEquals(1, list.size());
	         list.add(1, null);
	         list.add(0, "$C$");
	         list.add(2, null);
	         assertEquals(4, list.size());
	         list.remove(0);
	         assertEquals(3, list.size());
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   @Test
	   public void testToString()
	   {
	      // format is not defined only order of elements
	      list.add("$B$");
	      list.add("$D$");
	      list.add("$A$");
	      list.add("$B$");
	      list.add("$C$");
	      list.add("$D$");
	      assertTrue(containsToString("$B$", "$D$", "$A$", "$B$", "$C$", "$D$"));
	      try
	      {
	         list.add(null);
	         assertTrue(containsToString("$B$", "$D$", "$A$", "$B$", "$C$", "$D$", "null"));
	         list.add("$C$");
	         assertTrue(containsToString("$B$", "$D$", "$A$", "$B$", "$C$", "$D$", "null", "$C$"));
	         list.add(2, null);
	         assertTrue(containsToString("$B$", "$D$", "null", "$A$", "$B$", "$C$", "$D$", "null", "$C$"));
	         list.add(0, null);
	         assertTrue(containsToString("null", "$B$", "$D$", "null", "$A$", "$B$", "$C$", "$D$", "null", "$C$"));
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }
	   }

	   private boolean containsUsingGet(String... s)
	   {
	      if (s.length != list.size())
	      {
	         return false;
	      }
	      for (int i = 0; i < s.length; i++)
	      {
	         if (s[i] == null && list.get(i) != null)
	         {
	            return false;
	         }
	         if (s[i] != null && !s[i].equals(list.get(i)))
	         {
	            return false;
	         }
	      }
	      return true;
	   }

	   private boolean containsToString(String... s)
	   {
	      String listString = list.toString();
//	      System.out.println(listString);
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
	         if (index1 > index2)
	            return false;
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

