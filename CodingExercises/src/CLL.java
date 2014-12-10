class CLLNode {
	private int data;
	private CLLNode next;

	public CLLNode() {
		this.data = 0;
		this.next = null;
	}

	public CLLNode(int data) {
		this.data = data;
		this.next = this;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CLLNode getNext() {
		return next;
	}

	public void setNext(CLLNode next) {
		this.next = next;
	}	
}

public class CLL {

	private CLLNode headNode;	

	public CLL(CLLNode headNode) {
		this.headNode = headNode;
	}

	public int getCLLSize(CLLNode headNode){

		if(headNode == null) return 0;

		int size = 0;

		CLLNode currentNode = headNode;

		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
			if(currentNode == headNode)
				break;
		}

		return size;
	}

	public void displayCLL(CLLNode headNode){

		if(headNode.getNext() == headNode) System.out.println(headNode.getData() + "->" + "("+headNode.getData()+")headNode");

		else {
			CLLNode currentNode = headNode;
			while(currentNode != null){
				System.out.print(currentNode.getData());
				System.out.print("->");
				currentNode = currentNode.getNext();
				if(headNode == currentNode)
					break;				
			}
			System.out.print("("+headNode.getData()+")headNode");
			System.out.println();
		}
	}

	public CLLNode insertAtEnd(CLLNode headNode, CLLNode nodeToInsert){

		if(headNode == null){

			nodeToInsert.setNext(nodeToInsert);
			return nodeToInsert;
		} else {

			CLLNode currentNode = headNode;

			while(currentNode.getNext() != headNode) {
				currentNode = currentNode.getNext();
			}

			nodeToInsert.setNext(headNode);
			currentNode.setNext(nodeToInsert);
		}

		return headNode;
	}

	public CLLNode insertAtBegin(CLLNode headNode, CLLNode nodeToInsert){

		if(headNode == null){

			nodeToInsert.setNext(nodeToInsert);
			return nodeToInsert;
		} else {

			CLLNode currentNode = headNode;

			while(currentNode.getNext() != headNode) {
				currentNode = currentNode.getNext();
			}

			nodeToInsert.setNext(headNode);
			currentNode.setNext(nodeToInsert);
			headNode = nodeToInsert;
		}

		return headNode;
	}

	public CLLNode deleteAtEnd(CLLNode headNode){

		CLLNode currentNode = headNode;
		CLLNode prevNode = headNode;

		while(currentNode.getNext() != headNode) {
			prevNode = currentNode;
			currentNode = currentNode.getNext();
		}

		prevNode.setNext(headNode);
		currentNode = null;

		return headNode;
	}

	public CLLNode deleteAtBegin(CLLNode headNode){

		CLLNode currentNode = headNode;
		@SuppressWarnings("unused")
		CLLNode nextNode = headNode;

		while(currentNode.getNext() != headNode) {
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(headNode.getNext());
		headNode = headNode.getNext();
		nextNode = null;

		return headNode;
	}

	public static void splitList(CLLNode headNode,CLLNode newHead1, CLLNode newHead2) {

		if(headNode == null) return;

		CLLNode slowptr = headNode;
		CLLNode fastptr = headNode;

		while(fastptr.getNext() != headNode && fastptr.getNext().getNext() != headNode) {			

			slowptr = slowptr.getNext();
			fastptr = fastptr.getNext().getNext();			
		}

		if(fastptr.getNext().getNext() == headNode)
			fastptr = fastptr.getNext();

		newHead1.setData(headNode.getData());
		newHead1.setNext(headNode.getNext());

		if(slowptr.getNext().getNext() != headNode) {
			newHead2.setData(slowptr.getNext().getData());
			newHead2.setNext(slowptr.getNext().getNext());
		} else {
			newHead2.setData(fastptr.getData());
			newHead2.setNext(newHead2);
		}

		fastptr.setNext(newHead2);

		slowptr.setNext(newHead1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CLL list = new CLL(new CLLNode(2));

		list.displayCLL(list.headNode);
		list.headNode = list.insertAtEnd(list.headNode,new CLLNode(3));
		list.displayCLL(list.headNode);
		list.headNode = list.insertAtEnd(list.headNode,new CLLNode(4));
		list.displayCLL(list.headNode);
		list.headNode = list.insertAtBegin(list.headNode,new CLLNode(1));
		list.displayCLL(list.headNode);
		list.headNode = list.insertAtEnd(list.headNode,new CLLNode(5));
		list.displayCLL(list.headNode);
		list.headNode = list.deleteAtEnd(list.headNode);
		list.displayCLL(list.headNode);
		list.headNode = list.deleteAtBegin(list.headNode);
		list.displayCLL(list.headNode);
		list.headNode = list.insertAtBegin(list.headNode, new CLLNode(1));
		list.displayCLL(list.headNode);

		CLLNode head1 = new CLLNode();
		CLLNode head2 = new CLLNode();

		splitList(list.headNode,head1,head2);
		list.displayCLL(head1);
		list.displayCLL(head2);
	}

}
