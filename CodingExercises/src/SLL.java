class LLNode {
	private int data;
	private LLNode next;
	
	public LLNode() {
		this.data = 0;
		this.next = null;
	}
	
	public LLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public LLNode getNext() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}	
}

public class SLL {

	private LLNode headNode;	
	
	public SLL(LLNode headNode) {
		this.headNode = headNode;
	}

	public int getLLSize(LLNode headNode){
		
		int size = 0;
		
		LLNode currentNode = headNode;
		
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
		}
			
		return size;
	}
	
	public LLNode insert(LLNode headNode, LLNode nodeToInsert, int position){
		
		if(headNode == null) return nodeToInsert;
		
		int size = getLLSize(headNode);
		
		if(position < 1 || position > size+1) {
			System.out.println("Invalid size!");
			return null;
		}
		
		if(position == 1) {
			
			nodeToInsert.setNext(headNode);
			headNode = nodeToInsert;

		} else {
		
			int count = 1;
			LLNode currentNode = headNode;
			
			while(count<position-1) {
				currentNode = currentNode.getNext();
				count++;
			}
			
			nodeToInsert.setNext(currentNode.getNext());
			currentNode.setNext(nodeToInsert);
		}
	
		return headNode;
	}


public LLNode delete(LLNode headNode, int position){
		
		int size = getLLSize(headNode);
		
		if(position < 1 || position > size+1) {
			System.out.println("Invalid size!");
			return null;
		}
		
		if(position == 1) {
			
			@SuppressWarnings("unused")
			LLNode temp = headNode;
			headNode = headNode.getNext();
			temp = null;

		} else {
		
			int count = 1;
			LLNode currentNode = headNode;
			
			while(count<position-1) {
				currentNode = currentNode.getNext();
				count++;
			}
			
			LLNode prevNode = currentNode;
			currentNode = currentNode.getNext();
			prevNode.setNext(currentNode.getNext());
			currentNode = null;
		}
	
		return headNode;
	}

	public LLNode reverseList(LLNode headNode) {
		
		int size = getLLSize(headNode);
		if(size == 1) 
			return headNode;		
		else {
			LLNode prevNode = null;
			LLNode currentNode = null;
			
			while(headNode != null) {
				currentNode = headNode.getNext();
				headNode.setNext(prevNode);
				prevNode = headNode;
				headNode = currentNode;
			}			
			return prevNode;
		}
	}
	
public LLNode reverseInPairs(LLNode headNode) {
		
		int size = getLLSize(headNode);
		if(size == 1) 
			return headNode;	
		else if(size == 2) {
			LLNode temp = headNode.getNext();
			temp.setNext(headNode);
			headNode.setNext(null);
			return temp;
		} else {
			LLNode newHead = headNode.getNext();
			LLNode temp = headNode;
			LLNode temp2 = headNode;
			LLNode currentNode = headNode;
			LLNode prevNode = null;
			int flag = 0;
			
			while(currentNode.getNext() != null && currentNode.getNext().getNext() != null) {
				temp = currentNode.getNext();
				temp2 = temp.getNext();
				temp.setNext(currentNode);
				currentNode.setNext(temp2);
				
				if(flag == 1) {
					prevNode.setNext(temp);
				}
				flag = 1;
				
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}			
			return newHead;
		}
	}

	public LLNode exchangeAdjacentNodes(LLNode headNode) {
		LLNode currentNode = new LLNode();
		LLNode temp = new LLNode();
		LLNode nextNode = new LLNode();
		
		currentNode = headNode;
		
		if(currentNode == null || currentNode.getNext() == null) return currentNode;
		
		headNode = currentNode.getNext();
		
		while(currentNode != null && currentNode.getNext() != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(nextNode.getNext());
			temp = currentNode.getNext();
			nextNode.setNext(currentNode);
			
			if(temp != null && temp.getNext() != null)
				currentNode.setNext(currentNode.getNext().getNext());
			currentNode = temp;
		}
		return headNode;
	}

	public void displayLL(LLNode headNode){
		while(headNode != null){
			System.out.print(headNode.getData());
			if(headNode.getNext() != null)
				System.out.print("->");
			headNode = headNode.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		SLL list = new SLL(new LLNode(1));
		
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(2),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(3),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(4),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(5),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(6),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(7),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.insert(list.headNode,new LLNode(8),list.getLLSize(list.headNode)+1);
		list.displayLL(list.headNode);
		list.delete(list.headNode,3);
		list.displayLL(list.headNode);
		LLNode newhead = list.exchangeAdjacentNodes(list.headNode);
		list.displayLL(newhead);
		
	}

}
