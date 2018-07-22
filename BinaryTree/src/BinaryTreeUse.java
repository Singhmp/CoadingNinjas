
import java.util.Scanner;
public class BinaryTreeUse {
public static void printTree(BinaryTree<Integer> root) {
	if(root==null) {
		return;
	}
	String toBePrinted=root.data + "";
	if(root.left!=null) {
		toBePrinted+="L :" +root.left.data + ",";
	}
	if(root.right !=null) {
		toBePrinted +="R: "+ root.right.data;
	}
	System.out.println(toBePrinted);
	printTree(root.left);
	printTree(root.right);
}
public static BinaryTree<Integer> takeInput(Scanner s) {
	int rootData;
	System.out.println("Enterr the root data");
	rootData=s.nextInt();
	if(rootData==-1) {
		return null;
	}
	BinaryTree<Integer>  root=new BinaryTree<Integer>(rootData);
	root.left=takeInput(s);
	root.right=takeInput(s);
	return root;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner s=new Scanner(System.in);
BinaryTree<Integer> root=takeInput(s);
printTree(root);

	}

}
