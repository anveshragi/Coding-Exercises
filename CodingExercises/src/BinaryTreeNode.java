
public class BinaryTreeNode {

	private int data;
	private BinaryTreeNode leftNode;
	private BinaryTreeNode rightNode;	
	
	public BinaryTreeNode(int data) {
		super();
		this.leftNode = null;
		this.rightNode = null;
		this.data = data;
	}

	public BinaryTreeNode() {
		this.leftNode = null;
		this.rightNode = null;
	}	
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public BinaryTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public boolean isLeaf() {
		if(this.leftNode == null && this.rightNode == null)
			return true;
		else 
			return false;
	}
}
