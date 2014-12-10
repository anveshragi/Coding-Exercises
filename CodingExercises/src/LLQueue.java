
public class LLQueue {

	private LLNode front;
	private LLNode rear;
	private int size;	
	
	public LLQueue() {
		super();
		front = null;
		rear = null;
		this.size = 0;
	}

	public boolean isEmpty(){
		if(front == null) 
			return true;
		else 
			return false;
	}
	
	public void enQueue(int data) {
		LLNode node = new LLNode(data);
		if(rear == null) {
			rear = node;
			front = node;
		} else {
			rear.setNext(node);
			rear = node;
		}		
		size++;
	}
	
	public int deQueue() throws Exception{
		if(isEmpty()) 
			throw new Exception("Empty Queue!");
		else {
			int data = front.getData();
			front = front.getNext();
			size--;
			return data;
		}			
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LLQueue queue = new LLQueue();
		
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println("size : " + queue.size);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println("size : " + queue.size);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println("size : " + queue.size);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

}
