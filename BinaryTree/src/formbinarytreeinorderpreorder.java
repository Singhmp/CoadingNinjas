
public class formbinarytreeinorderpreorder {

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
	
	
	
	
	public static BinaryTree<Integer> gettreefrominandre(int[]pre,int[]in){
	return helper(pre,in,0,pre.length-1,0,in.length-1);
}
public static BinaryTree<Integer> helper(int pre[],int in[],int preS,int preE,int inS,int inE)
{
	if(inS>inE) {
		return null;
	}
int rootData=pre[preS];
BinaryTree<Integer> root=new BinaryTree<Integer>(rootData);
int i=inS;
while(i<inS) {
	if(in[i]==rootData) {
		break;
	}
	i++;
}
int leftInStart=inS;
int leftInEnd=i-1;
int rightInStart=i+1;
int rightInEnd=inE;

int leftPreStart=preS+1;
int rightPreEnd=preE;
int leftLenght=leftInEnd-leftInStart+1;
int leftPreEnd=leftPreStart+leftLenght-1;
int rightPreStart=leftPreEnd+1;
root.left=helper(pre,in,leftPreStart,leftPreEnd,leftInStart,leftInEnd);
root.right=helper(pre,in,rightPreStart,rightPreEnd,rightInStart,rightInEnd);
return root;
}	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
int in[]= {4,2,5,1,3,7};
int pre[]= {1,2,4,5,3,7};
BinaryTree<Integer> root = gettreefrominandre(pre,in);
printLevelWise(root);
	}

}
