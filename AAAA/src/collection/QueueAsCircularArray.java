// *****************************************************************************
// File name  : QueueAsCircularArray.java.
// Start date :
// Programmer : Hans So.
// Java       :
// Description:
// *****************************************************************************
package collection;
/**
 * This <CODE>class QueueAsCircularArray</CODE> implements
 * <CODE>interface IQueue</CODE> as a circular array.
 *
 * @version 1.0; - 7th March 2004
 * @author Hans Sondergaard
 **/
public class QueueAsCircularArray implements IQueue
{
  private Object[] queue;
  private int count, size;
  private int front, rear;
  /**
   * Creates an empty queue with places for <CODE>size</CODE> elements
   * @param size is the number of places in this queue
   * @precondition size > 0
   * @postcondition queue is empty
   */
  public QueueAsCircularArray(int size)
  {
    queue = new Object[size];
    this.size = size;
    count = 0;
    rear = 0;
    front = 0;
  }
  /**
   * @param x is not null
   * @precondition queue is not full
   * @postcondition queue is not empty
   */
  public synchronized void put(Object x)
  {
    queue[rear] = x;
    rear = (rear + 1) % queue.length;
    count++;
  }
  /**
   * @precondition queue is not empty
   * @postcondition queue is not full
   */
  public synchronized Object take()
  {
    Object obj = queue[front];
    queue[front] = null;
    front = (front + 1) % queue.length;
    count--;
    return obj;
  }

  public synchronized boolean isEmpty()
  {
    return count == 0;
  }

  public synchronized boolean isFull()
  {
    return count == queue.length;
  }

  public synchronized int count()
  {
    return count;
  }
}
