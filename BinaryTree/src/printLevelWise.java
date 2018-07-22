import java.util.Scanner;
public class printLevelWise {
public static void printLevelWise(BinaryTree<Integer> root)
{
	QueueUsingLL<BinaryTree<Integer>> pendingNode =new QueueUsingLL<>();
	pendingNode.enqueue(root);
	while(!pendingNode.isEmpty())
	{
		BinaryTree<Integer> frontNode=null;
		try {
			frontNode=pendingNode.dequeue();
		} catch (QueueEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(frontNode.data + ": ");
		if(frontNode.left!=null) {
			pendingNode.enqueue(frontNode.left);
			System.out.println("L :" + frontNode.left.data + ",");
		}else {
			System.out.println("L:" + "-1" + ",");
		}
		if(frontNode.right!=null) {
			pendingNode.enqueue(frontNode.right);
			System.out.println("R : " + frontNode.right.data + " ,");
		}else {
			System.out.println("R : " + "-1"+ ", ");
		}
	}
}

public static BinaryTree<Integer> takeInput(Scanner s){
	System.out.println("Enter the root data");
	int rootData=s.nextInt();
	if(rootData==-1) {
		return null;
		
	}
	BinaryTree<Integer> root=new BinaryTree<>(rootData);
	root.left=takeInput(s);
	root.right=takeInput(s);
	
	return root;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		BinaryTree<Integer> root=takeInput(s);
		printLevelWise(root);

	}

}
