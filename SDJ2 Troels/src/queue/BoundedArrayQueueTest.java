package queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoundedArrayQueueTest {

		private BoundedArrayQueue<String> q;
		
		@Before
		public void setup() {
			q = new BoundedArrayQueue<String>(5);
		}
		
		@Test
		public void testEnqueue() {
			q.enqueue("A");
			q.enqueue("A");
			q.enqueue("A");
			assertEquals(3, q.size());
			q.enqueue("A");
			q.enqueue("A");
			assertEquals(5, q.size());
			try {
				q.enqueue("A");
				fail("Should not be able to push 6 elements with capacity 5");
			} catch(IllegalStateException e) {
				// OK
			}
		}
		
		@Test
		public void testToString() {
			q.enqueue("A");
			q.enqueue("B");
			q.enqueue("C");
			q.enqueue("D");
			q.enqueue("E");
			assertEquals("{A, B, C, D, E}", q.toString());
			q.dequeue();
			q.dequeue();
			assertEquals("{C, D, E}", q.toString());
			
		}
		
		@Test
		public void testIndexOf() {
			q.enqueue("A");
			q.enqueue("B");
			q.enqueue("C");
			assertEquals(2, q.indexOf("C"));
			q.enqueue("D");
			q.enqueue("E");
			assertEquals(4, q.indexOf("E"));
			q.dequeue();
			q.dequeue();
			q.dequeue();
			q.enqueue("F");
			q.enqueue("G");
			assertEquals("{D, E, F, G}", q.toString());
			assertEquals(3, q.indexOf("G"));
		
			
		}

	}



