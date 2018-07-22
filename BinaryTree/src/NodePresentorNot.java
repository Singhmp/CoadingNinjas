import java.util.Scanner;

public class NodePresentorNot {

	public static void printTree(BinaryTree<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}
		
		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	
	public static BinaryTree<Integer> takeInput(Scanner s) {
		int rootData;
		System.out.println("Enter root data");
		rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	
	public static BinaryTree<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTree<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTree<Integer> root = new BinaryTree<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTree<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTree<Integer> child = new BinaryTree<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTree<Integer> child = new BinaryTree<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
//	First  Way Of solving this problem
	public static boolean IsNodePresent(BinaryTree<Integer> root,int x) {
		if (root == null) {
			return false;
		}
		boolean found=root.data.equals(x);
		if(found) {
			return true;
		}
		
		found=found || IsNodePresent(root.left,x);
if(found) {
	return true;
		
	}
found=found || IsNodePresent(root.right,x);
if(found) 
	return true;
else
return false;

	}
	//2nd Way must solve by your self
	public static boolean isPresent=false;
	public static boolean isNodePresent2(BinaryTree root,int x) {
		if(root==null) {
			return false;
		}
		QueueUsingLL<BinaryTree<Integer>> pendingNode=new QueueUsingLL<>();
		pendingNode.enqueue(root);
		while(!pendingNode.isEmpty()) {
			BinaryTree<Integer> frontNode=null;
			try {
				frontNode=pendingNode.dequeue();
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(frontNode.data==x) {
				isPresent=true;
			break;
			}
		isPresent=isNodePresent2(root.left,x)||isNodePresent2(root.right,x);
		
		}
		return isPresent;
	}
	public static void main(String[] args) {
		//Scanner s = new Scanner(System.in);
		BinaryTree<Integer> root = takeInputLevelWise();
		printTree(root);
	boolean m=	IsNodePresent(root,5);
	boolean n=	IsNodePresent(root,5);
		System.out.println(m);
		System.out.println(n);
			//s.close();
//		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
//		root.left = node1;
//		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
//		root.right = node2;
	}
}

