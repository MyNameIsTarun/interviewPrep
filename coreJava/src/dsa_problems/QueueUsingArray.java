package dsa_problems;

/*
 * Implement queue using array
 * 
 * O(1) enQueue, O(1) deQueue
 */
public class QueueUsingArray {

	public static void main(String[] args) {
		
		Queue queue = new Queue(5);
		
		System.out.println("isEmpty(): " + queue.isEmpty());
		System.out.println("isFull(): " + queue.isFull());
		System.out.println("deQueue(): " + queue.deQueue());
		
		System.out.println("enQueue: " + queue.enQueue(1));
		System.out.println("enQueue: " + queue.enQueue(2));
		System.out.println("enQueue: " + queue.enQueue(3));
		System.out.println("enQueue: " + queue.enQueue(4));
		System.out.println("enQueue: " + queue.enQueue(5));
		System.out.println("size(): " + queue.size());
		System.out.println("enQueue: " + queue.enQueue(6));

		System.out.println("getFront(): " + queue.getFront());
		System.out.println("getRear(): " + queue.getRear());
		
		System.out.println("deQueue(): " + queue.deQueue());
		System.out.println("deQueue(): " + queue.deQueue());
		System.out.println("deQueue(): " + queue.deQueue());
		System.out.println("deQueue(): " + queue.deQueue());
		
		System.out.println("size(): " + queue.size());
		System.out.println("getFront(): " + queue.getFront());
		System.out.println("getRear(): " + queue.getRear());
		
		System.out.println("deQueue(): " + queue.deQueue());
		System.out.println("deQueue(): " + queue.deQueue());
		
		System.out.println("enQueue: " + queue.enQueue(1));
		System.out.println("enQueue: " + queue.enQueue(2));
		System.out.println("enQueue: " + queue.enQueue(3));
		
		System.out.println("deQueue(): " + queue.deQueue());
		System.out.println("deQueue(): " + queue.deQueue());
		System.out.println("deQueue(): " + queue.deQueue());
		
		System.out.println("enQueue: " + queue.enQueue(1));
		
		System.out.println("size(): " + queue.size());
		System.out.println("getFront(): " + queue.getFront());
		System.out.println("getRear(): " + queue.getRear());
	}

}

class Queue {
	// front holds Queue's front index
	private int size, cap, front;
	private int []queue;
	
	public Queue(int cap) {
		this.cap = cap;
		front = 0;
		size = 0;
		queue = new int[cap];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return size == cap;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getFront() {
		return isEmpty() ? -1 : queue[front];
	}
	
	public int getRear() {
		return isEmpty() ? -1 : queue[(front + size - 1) % cap];
	}
	
	public boolean enQueue(int x) {
		if(isFull()) {
			return false;
		}
		
		int rear = (front + size - 1) % cap;
		queue[(rear+1)%cap] = x;
		size++;
		
		return true;
	}
	
	public int deQueue() {
		if(isEmpty()) {
			return -1;
		}
		
		int x = queue[front];
		front = (front+1)%cap;
		size--;
		
		return x;
	}
}
