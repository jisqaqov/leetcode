package leetcode.p0004;

/**
 * @author Jandos Iskakov
 * problem: 622. Design Circular Queue
 * algorithm: Array
 * time complexity: O(1)
 * space complexity: O(N)
 * Runtime: 4 ms, faster than 97.52% of Java online submissions
 * Memory Usage: 40.4 MB, less than 10.72% of Java online submissions
 */
public class DesignCircularQueue622 {

  class MyCircularQueue {

    private int front;
    private int rear;
    private int size = 0;
    private int[] queue;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
      size = k;
      queue = new int[k];
      front = rear = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }

      if (isEmpty()) {
        front = rear = 0;
      } else if (rear == size - 1) {
        rear = 0;
      } else {
        rear++;
      }

      queue[rear] = value;

      return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }

      if (front == rear) {
        front = rear = -1;
      } else if (front == size - 1) {
        front = 0;
      } else {
        front++;
      }

      return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
      if (isEmpty()) {
        return -1;
      }

      return queue[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
      if (isEmpty()) {
        return -1;
      }

      return queue[rear];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
      return front == -1;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
      return (front == 0 && rear == size - 1) || (rear + 1 == front);
    }


    private class Node {

      Node prev;
      Node next;
      int val;
    }
  }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

}