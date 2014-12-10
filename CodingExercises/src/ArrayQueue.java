public class ArrayQueue {

	private int front;
	private int rear;
	private int capacity;
	private int array[];
	private int current_size;

	public ArrayQueue(int capacity) {
		super();
		this.front = 0;
		this.rear = -1;
		this.current_size = 0;
		this.capacity = capacity;
		this.array = new int[capacity];
	}

	public int size(){
		return current_size;
	}

	public boolean isEmpty(){
		return (current_size == 0);
	}

	public boolean isFull(){
		return (current_size == capacity);
	}

	public void resize() {
		int newCapacity = capacity*2;
		int oldArray[] = this.array;
		this.array = new int[newCapacity];
		int temp = front;
		
		for(int i=0;i<current_size;i++) {
			this.array[i] = oldArray[temp];
			temp++;
			if(temp == capacity)
				temp = 0;	
		}
		this.front = 0;
		this.rear = current_size;
		capacity = newCapacity;
	}
	
	public void enQueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full! Resizing!!");
			resize();
		}
			rear++;
			if(rear >=capacity && current_size != capacity)
				rear = 0;
			array[rear] = data;
			current_size++;
	}

	public int deQueue() throws Exception {
		if(isEmpty()) { 
			System.out.println("Queue is Empty!");
			throw new Exception();
		}
		else {
			int data = array[front];
			front++;			
			if(front >= capacity)
				front = 0;
			current_size--;
			return data;
		}	
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ArrayQueue queue = new ArrayQueue(5);

		System.out.println("size : " + queue.size());
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		System.out.println("size : " + queue.size());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println("size : " + queue.size());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println("size : " + queue.size());
		queue.enQueue(6);
		System.out.println("size : " + queue.size());
		queue.enQueue(7);
		queue.enQueue(8);
		System.out.println("size : " + queue.size());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println("size : " + queue.size());
		queue.enQueue(9);
		queue.enQueue(10);
		queue.enQueue(11);
		queue.enQueue(12);
		queue.enQueue(13);
		queue.enQueue(14);
		queue.enQueue(15);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println("size : " + queue.size());
	}

}
