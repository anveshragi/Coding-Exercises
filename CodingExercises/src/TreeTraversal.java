import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	public static BinaryTreeNode createBinaryTree(Integer[] arr) {
		if (arr == null)  {
			throw new NullPointerException("The input array is null.");
		}

		BinaryTreeNode root = new BinaryTreeNode(arr[0]);

		final Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);

		final int half = arr.length / 2;

		for (int i = 0; i < half; i++) {
			if (arr[i] != null) {
				final BinaryTreeNode current = queue.poll();
				System.out.println("current : " + current.getData());
				final int left = 2 * i + 1;
				final int right = 2 * i + 2;

				if (arr[left] != null) {
					current.setLeftNode(new BinaryTreeNode(arr[left]));
					System.out.println("current's left : " + current.getLeftNode().getData());
					queue.add(current.getLeftNode());
				}
				if (right < arr.length && arr[right] != null) {
					current.setRightNode(new BinaryTreeNode(arr[right]));
					System.out.println("current's right : " + current.getRightNode().getData());
					queue.add(current.getRightNode());
				}
			}
		}
		return root;
	}

	public static void preOrderTraversal(BinaryTreeNode root) {
		if(root == null) System.out.println("Tree Empty!");

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

		stack.push(root);

		System.out.println("Pre-Order Traversal : ");

		while(!stack.isEmpty()) {
			BinaryTreeNode temp = stack.pop();
			System.out.print(temp.getData() + " ");

			if(temp.getRightNode() != null)
				stack.push(temp.getRightNode());
			if(temp.getLeftNode() != null )
				stack.push(temp.getLeftNode());
		}	
		System.out.println();
	}

	public static void inOrderTraversal(BinaryTreeNode root) {

		if(root == null) System.out.println("Tree Empty!");

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

		System.out.println("Inorder Traversal : ");

		while(true) {
			while(root != null) {
				stack.push(root);
				root = root.getLeftNode();
			}
			if(stack.isEmpty())
				break;
			root = stack.pop();
			System.out.print(root.getData() + " ");
			root = root.getRightNode();
		}

		System.out.println();

		//		BinaryTreeNode temp = root;
		//		
		//		System.out.println("Inorder Traversal : ");
		//		
		//		while(!stack.isEmpty() || temp != null){
		//			
		//			if(temp != null) {
		//				stack.push(temp);
		//				temp = temp.getLeftNode();
		//			} else {
		//				temp = stack.pop();
		//				System.out.print(temp.getData()+" ");
		//				temp = temp.getRightNode();
		//			}
		//		}
		//		System.out.println();
	}

	public static void postOrderTraversal(BinaryTreeNode root){

		if(root == null) System.out.println("Tree Empty!");

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();

		System.out.println("Postorder Traversal : ");

		while(!stack.isEmpty() || root!=null) {

			while(root!=null) {
				if(root.getRightNode()!=null) stack.push(root.getRightNode());
				stack.push(root);
				root = root.getLeftNode();
			}

			//			if(stack.isEmpty())
			//				break;

			root = stack.pop();

			if(root.getRightNode() != null && !stack.isEmpty() && root.getRightNode() == stack.peek()) {
				BinaryTreeNode nodeRight = stack.pop();
				stack.push(root);
				root = nodeRight;
				//				stack.push(root);
				//				root = root.getRightNode();
			} else {
				System.out.print(root.getData() + " ");
				root = null;
			}

		}		
		System.out.println();
	}

	public static void levelOrderTraversal(BinaryTreeNode root) {

		if(root == null) System.out.println("Tree Empty!");

		System.out.println("Level order Traversal : ");

		Queue<BinaryTreeNode> queue = new ArrayDeque<BinaryTreeNode>();

		queue.add(root);

		while(!queue.isEmpty()) {

			root = queue.remove();
			System.out.print(root.getData() + " ");				

			if(root.getLeftNode()!=null)
				queue.add(root.getLeftNode());
			if(root.getRightNode()!=null)
				queue.add(root.getRightNode());
		}
		System.out.println();
	}

	public static void traverse(BinaryTreeNode root) {
		// assume root != NULL
		traverse(root, new LinkedList<BinaryTreeNode>());
	}

	private static void traverse(BinaryTreeNode root, LinkedList<BinaryTreeNode> path) {
		path.add(root);
		if (root.isLeaf()) {
			while(path.peek() != null) {
				System.out.print(path.pop().getData() + "-");
			}
			System.out.println();
		}
		else {
			if(root.getLeftNode() != null)
				traverse (root.getLeftNode(), new LinkedList<BinaryTreeNode>(path));
			if(root.getRightNode() != null)
				traverse (root.getRightNode(), new LinkedList<BinaryTreeNode>(path));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		TreeTraversal tree = new TreeTraversal();
		Integer arr[] = {10,8,2,3,5,7,6};
		BinaryTreeNode root = createBinaryTree(arr);

		preOrderTraversal(root);
		inOrderTraversal(root);
		postOrderTraversal(root);
		levelOrderTraversal(root);
		//		traverse(root);
	}

}
