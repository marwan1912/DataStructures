
public class BST {

	Node root;
	
	public BST() {
		root = null;
	}
	
	public void insert(int data) {
		root = insertHelper(data, root);
	}
	
	Node insertHelper(int data, Node root) {
		if(root == null) {
			root = new Node(data);
		}else {
			if(data <= root.getData()) {
				if(root.left == null) {
					root.left = new Node(data);
				}else {
					root.left = insertHelper(data, root.left);
				}
				
			}else if(data > root.getData()) {
				if(root.right == null) {
					root.right = new Node(data);
				}else {
					root.right = insertHelper(data, root.right);
				}
			}
		}
        return root; 
	}
	
	public boolean exists(int data) {
		return existsHelper(data, root);
	}
	
	boolean existsHelper(int data, Node root) {
		if(data == root.getData()) {
			return true;
		}else {
			if(data < root.getData()) {
				if(root.left == null) {
					return false;
				}else {
					return existsHelper(data, root.left);
				}
			}else {
				if(root.right == null) {
					return false;
				}else {
					return existsHelper(data, root.right);
				}
			}
		}
	}
	
	public int size() {
		return sizeHelper(root);
	}
	
	int sizeHelper(Node root) {
		if(root == null) {
			return 0;
		}else {
			return 1 + sizeHelper(root.left) + sizeHelper(root.right);
		}	
	}
	
	public void remove(int data) {
		root = removeHelper(data, root);
	}
	
	Node removeHelper(int data, Node root) {
		if (root == null) {
			return root;
		}else {
			if(data < root.getData()) {
			root.left = removeHelper(data, root.left);	
			}else if(data > root.getData()) {
				root.right = removeHelper(data, root.right);
			}else {
				if(root.left == null) {
					return root.right;
				}else if(root.right == null) {
					return root.left;
				}else {
					root.setData(smallest(root.right));
					root.right = removeHelper(root.getData(), root.right);
				}
			}
		}
		return root;
	}
	
	/*Returns the smallest value in the right sub-tree because it will be always bigger than 
	the main root left sub-tree and smaller than the right subtree*/
	int smallest(Node root) {
		int smallestValue = root.getData();
		while(root.left != null) {
			smallestValue = root.left.getData();
			root = root.left;
		}
		return smallestValue;
	}
	
	public void print() {
		printHelper(root);
		System.out.println();
	}
	
	void printHelper(Node root) {
		if(root.left != null) {
			printHelper(root.left);
		}
		System.out.print(root.getData() + " ");
		if(root.right != null) {
			printHelper(root.right);
		}
	}
	
	public boolean isEmpty() {
		return isEmptyHelper(root);
	}
	
	boolean isEmptyHelper(Node root) {
		return root == null;
	}
	
	public static void main(String[] args) {
		BST bst = new BST();
		System.out.println("isEmpty: " + bst.isEmpty());
		bst.insert(10);
		System.out.println("isEmpty: " + bst.isEmpty());
		bst.insert(5);
		bst.insert(15);
		bst.insert(8);
		bst.insert(4);
		bst.insert(17);
		bst.insert(13);
		System.out.println("Size: " + bst.size());
		bst.print();
		System.out.println("10 Exists: " + bst.exists(10));
		bst.remove(10);
		System.out.println("10 Exists: " + bst.exists(10));
		System.out.println("Size: " + bst.size());
		bst.print();
	}
			
}

class Node{
	
	int data;
	Node right, left;
	public Node(int data) {
		this.data = data;
		right = left = null;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
}
