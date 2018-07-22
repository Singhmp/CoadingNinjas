import java.util.Scanner;



public class HeightOfBinaryTree {
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
	
public static int Height(BinaryTree<Integer> root) {
	if(root==null) {
		return 0;
	}
	int lh=Height(root.left);
	int rh=Height(root.right);
	return Math.max(lh,rh)+1;
	
}
// diameterof binary tree time complixity is big O(n)

public static Pair<Integer,Integer> heightOfDiameter(BinaryTree<Integer> root)
{
	if(root==null) {
		Pair<Integer,Integer> output=new Pair<>();
		output.first=0;
		output.second=0;
		return output;
	}
Pair<Integer,Integer> lo=heightOfDiameter(root.left);
Pair<Integer,Integer> ro=heightOfDiameter(root.right);
int height=1+Math.max(lo.first,ro.first);
int option1=lo.first+ ro.first;
int option2=lo.second;
int option3=ro.second;
int diameter=Math.max(option1, Math.max(option2,option3));

Pair<Integer,Integer> output=new Pair<>();
output.first=height;
output.second=diameter;
return output;

}


// traversal in Binary Tree
public static void inorder(BinaryTree<Integer> root) {
	if(root==null) {
		return;
	}
	inorder(root.left);
System.out.println(root.data + " ");
inorder(root.right);
}
// preOrder
public static void preOrder(BinaryTree<Integer> root) {
	/* Your class should be named Solution
	* Don't write main().
	* Don't read input, it is passed as function argument.
	* Print output and don't return it.
	* Taking input is handled automatically.
	*/
if (root == null) {
		return;
	}
	System.out.print(root.data + " ");
	preOrder(root.left);
	preOrder(root.right);	
}
		// postOrder

public static void postOrder(BinaryTree<Integer> root) {
	/* Your class should be named Solution
	* Don't write main().
	* Don't read input, it is passed as function argument.
	* Print output and don't return it.
	* Taking input is handled automatically.
	*/
if (root == null) {
		return;
	}
	postOrder(root.left);
	postOrder(root.right);
	System.out.print(root.data + " ");		
}

	
	public static void main(String args[]) {
	BinaryTree<Integer> root=takeInputLevelWise();
	printTree(root);
	int m=Height(root);
	System.out.println("diameter:" + heightOfDiameter(root).second);
	System.out.println("Height :" + heightOfDiameter(root).first);
	}
}
