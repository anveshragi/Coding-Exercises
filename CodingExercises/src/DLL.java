class DLLNode {
	private int data;
	private DLLNode prev;
	private DLLNode next;
	
	public DLLNode(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public DLLNode getPrev(){
		return this.prev;
	}
	
	public void setPrev(DLLNode prev){
		this.prev = prev;
	}
	public DLLNode getNext(){
		return this.next;
	}
	
	public void setNext(DLLNode next){
		this.next = next;
	}
}

public class DLL {
	private DLLNode headNode;
	
	public DLL(DLLNode headNode){
		this.headNode = headNode;
	}

	public int getDLLSize(DLLNode headNode){
		int size = 0;
		
		DLLNode currentNode = headNode;
		
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
		}
			
		return size;
	}
	
	public DLLNode DLLInsert(DLLNode headNode,DLLNode nodeToInsert,int position){
		
		if(headNode == null){
			return nodeToInsert;
		}
		
		int size = getDLLSize(headNode);
		
		if(position > size+1 || position < 1) {
			System.out.println("Invalid position!");
		}

		if(position == 1) {
			nodeToInsert.setNext(headNode);
			
				if(headNode != null)
					headNode.setPrev(nodeToInsert);
					
			nodeToInsert.setPrev(null);
		} else {
			DLLNode currentNode = headNode;
			int count =1;
			while(count < position-1){
				currentNode = currentNode.getNext();
				count++;
			}
			
			DLLNode nextNode = currentNode.getNext();
			nodeToInsert.setNext(nextNode);
			if(nextNode != null)
				nextNode.setPrev(nodeToInsert);
			currentNode.setNext(nodeToInsert);
			nodeToInsert.setPrev(currentNode);	
		}
		
		return headNode;
	}
	
	public DLLNode DLLDelete(DLLNode headNode,int position){
	
		int size = getDLLSize(headNode);

		if(position > size || position < 1) {
			System.out.println("Invalid position!");
		}
		
		if(position == 1) {
			
			DLLNode temp = headNode;
			headNode = headNode.getNext();
			headNode.setPrev(null);
			temp.setNext(null);
			temp = null;
			
		} else {
			DLLNode currentNode = headNode;
			int count =1;
			while(count < position){
				currentNode = currentNode.getNext();
				count++;
			}
			
			DLLNode prevNode = currentNode.getPrev();
			DLLNode nextNode = currentNode.getNext();
			
			prevNode.setNext(nextNode);
			
			if(nextNode != null)
				nextNode.setPrev(prevNode);
			
			currentNode = null;
		}
		
		return headNode;
	
	}
	
	public void displayDLL(DLLNode headNode){
		while(headNode != null){
			System.out.print(headNode.getData());
			if(headNode.getNext() != null)
				System.out.print("->");
			headNode = headNode.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		
		DLL list = new DLL(new DLLNode(1));
		
		list.displayDLL(list.headNode);
		list.DLLInsert(list.headNode,new DLLNode(2),list.getDLLSize(list.headNode)+1);
		list.displayDLL(list.headNode);
		list.DLLInsert(list.headNode,new DLLNode(3),list.getDLLSize(list.headNode)+1);
		list.displayDLL(list.headNode);
		list.DLLInsert(list.headNode,new DLLNode(4),list.getDLLSize(list.headNode)+1);
		list.displayDLL(list.headNode);
		list.DLLInsert(list.headNode,new DLLNode(5),list.getDLLSize(list.headNode)+1);
		list.displayDLL(list.headNode);
		list.DLLDelete(list.headNode,3);
		list.displayDLL(list.headNode);
		
	}
	
}