package stack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {

	private StackADT<String> stack;

	   @Before
	   public void setUp() throws Exception
	   {
	      stack = new ArrayStack<>(10);
	   }

	   @After
	   public void tearDown() throws Exception
	   {
		   
	   }
	   @Test
	   public void testPush()
	   {
	      stack.push("$A$");
	      assertEquals(1, stack.size());
	      assertEquals("$A$", stack.peek());
	      
	      stack.push("$B$");
	      assertEquals(2, stack.size());
	      assertEquals("$B$", stack.peek());

	      stack.push("$C$");
	      assertEquals(3, stack.size());
	      assertEquals("$C$", stack.peek());

	      stack.push("$D$");
	      assertEquals(4, stack.size());
	      assertEquals("$D$", stack.peek());

	      try
	      {
	         stack.push(null);
	         assertEquals(5, stack.size());
	         assertEquals(null, stack.peek());

	         stack.push("$A$");
	         assertEquals(6, stack.size());
	         assertEquals("$A$", stack.peek());

	         stack.push(null);
	         assertEquals(7, stack.size());
	         assertEquals(null, stack.peek());
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	    	  stack.pop();
	    	  stack.push("A");
	      } catch (Exception e) {
	    	  fail("Should either accept null or throw IllegalArgumentException");
	      }
	   }
	   @Test
	   public void testPushAlmostFull()
	   {
	      stack.push("$A$");
	      stack.push("$B$");
	      stack.push("$C$");
	      stack.push("$D$");
	      stack.push("$E$");
	      stack.push("$F$");
	      stack.push("$G$");
	      stack.push("$H$");
	      stack.push("$I$");
	      stack.push("$J$");
	   }

	   
	   
	   @Test //(expected = IllegalStateException.class)
	   public void testPushFull()
	   {
	      stack.push("$A$");
	      stack.push("$B$");
	      stack.push("$C$");
	      stack.push("$D$");
	      stack.push("$E$");
	      stack.push("$F$");
	      stack.push("$G$");
	      stack.push("$H$");
	      stack.push("$I$");
	      stack.push("$J$");
	      try{
	    	  stack.push("$K$");
	      } catch(IllegalStateException e) {
	    	  // this is ok
	      } 
	      
	   }

	   @Test//(expected = IllegalStateException.class)
	   public void testPushNullFull()
	   {
	      stack.push("$A$");
	      stack.push("$B$");
	      stack.push("$C$");
	      stack.push("$D$");
	      stack.push("$E$");
	      stack.push("$F$");
	      stack.push("$G$");
	      stack.push("$H$");
	      stack.push("$I$");
	      stack.push("$J$");
	      try
	      {
	         stack.push(null);
	      }
	      catch (IllegalArgumentException e)
	      {
	         stack.push("$K$");
	      }
	   }

	   @Test
	   public void testPushNull()
	   {
	      try
	      {
	         stack.push(null);
	         assertEquals(1, stack.size());
	         assertEquals(null, stack.peek());
	         stack.push(null);
	         stack.push("$A$");
	         assertEquals(3, stack.size());
	         assertEquals("$A$", stack.peek());
	      }
	      catch (IllegalArgumentException e)
	      {
	         assertTrue(stack.size() == 0);
	      }
	   }

	   @Test
	   public void testSize() // indirectly testing pop too
	   {
	      assertEquals(0, stack.size());
	      stack.push("$A$");
	      assertEquals(1, stack.size());
	      assertEquals("$A$", stack.pop());
	      assertEquals(0, stack.size());
	      stack.push("$B$");
	      stack.push("$B$");
	      stack.push("$D$");
	      assertEquals(3, stack.size());
	      assertEquals("$D$", stack.pop());
	      assertEquals(2, stack.size());
	      assertEquals("$B$", stack.pop());
	      assertEquals(1, stack.size());
	      assertEquals("$B$", stack.pop());
	      assertEquals(0, stack.size());
	      stack.push("$X$");
	      stack.push("$Y$");
	      stack.push("$Z$");
	      assertEquals(3, stack.size());
	      assertEquals("$Z$", stack.pop());
	      assertEquals("$Y$", stack.pop());
	      assertEquals("$X$", stack.pop());
	      assertEquals(0, stack.size());
	      try
	      {
	         stack.push(null);
	         assertEquals(1, stack.size());
	         assertEquals(null, stack.pop());
	         assertEquals(0, stack.size());
	         stack.push(null);
	         stack.push(null);
	         stack.push("$A$");
	         assertEquals("$A$", stack.pop());
	         assertEquals(2, stack.size());
	         assertEquals(null, stack.pop());
	         assertEquals(null, stack.pop());
	         assertEquals(0, stack.size());
	      }
	      catch (IllegalArgumentException e)
	      {
	         // OK
	      }

	   }
}
