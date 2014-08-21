


public class StringTreeBag {
	private BTNode<String> root, cursor;
	private BTNode<String> left, right, precursor, parentOfCursor;
	private String data;
	
	public BTNode<String> getRoot()
	{return root;}
	
	public BTNode<String> getRight()
	{return right;}
	public void setRight(BTNode<String> element)
	{right = element;}
	
	public BTNode<String> getLeft()
	{return left;}
	public void setleft(BTNode<String> element)
	{left = element;}
	
	public BTNode<String> getCursor()
	{return cursor;}
	public void setCursor(BTNode<String> element)
	{cursor = element;}
	
	public BTNode<String> getPrecursor()
	{return precursor;}
	public void setPrecursor(BTNode<String> element)
	{precursor = element;}
	
	public StringTreeBag() //optional
	{
		root = null;
	}
	
	public int size()
	{
		return BTNode.treeSize(root);
	}
	
	//add an element
	public void add(String element)
	{
		if (element == null)
			throw new IllegalStateException("element is null");
		cursor = root;
		if (root == null)
		{
			root = new BTNode<String>(element, null, null);
			return;
		}
		
		boolean done = false;
		
		while(done == false)
		{
			if (element.compareTo(cursor.getData()) <= 0)
			{
				if (cursor.getLeft() == null)
				{
					cursor.setLeft(new BTNode<String>(element, null, null));
					done = true;
				}
				else
				{
					cursor = cursor.getLeft();
				}
			}
			else
			{
				if (cursor.getRight() == null)
				{
					cursor.setRight(new BTNode<String>(element, null, null));
					done = true;
				}
				else 
				{
					cursor = cursor.getRight();
				}
			}
		}
	}
		
	public boolean remove(String target)
	{
		cursor = root;
		parentOfCursor = null;
		
		while(cursor != null && target.compareTo(cursor.getData()) != 0)
		{
			if (target.compareTo(cursor.getData()) <= 0)
			{
				parentOfCursor = cursor;
				cursor = cursor.getLeft();
			}
			else if (target.compareTo(cursor.getData()) > 0)
			{
				parentOfCursor = cursor;
				cursor = cursor.getRight();
			}
		}
		
		if (cursor == null)
		{
			System.out.println(target + " WAS NOT found");
			return false;
		}
		
		if (cursor == root && root.getLeft() == null)//if (cursor == root)
		{
			root = root.getRight();
			System.out.println("The new root is " + root.getData());
			System.out.println(target + " WAS FOUND and REMOVED!!");
		}
		
		else if (cursor.getLeft() == null)
		{
			if (cursor == parentOfCursor.getLeft())
			{parentOfCursor.setLeft(cursor.getRight());}
			else
			{parentOfCursor.setRight(cursor.getLeft());}
			System.out.println(target + " WAS FOUND and REMOVED!!!");
		}
		
		else
		{
			cursor.setData(cursor.getLeft().getRightMost());
			cursor.setLeft(cursor.getLeft().removeRightmost());
			System.out.println(target + " WAS FOUND and REMOVED!!!!");
			System.out.println("The new root is " + root.getData());
		}
		
		
		return true;
	}
	
	public void addAll(StringTreeBag addend)  //using preorder traversal
	{
		BTNode addroot;
		
		if (root == addend.root)
		{
			addroot = BTNode.treeCopy(addend.root);
			addTree(addroot);
		}
		else
			addTree(addend.root);
	}
	
	private void addTree(BTNode<String> addroot)
	{
		if  (addroot.getData() != null)
		{
			add(addroot.getData());
			
			if(addroot.getLeft() != null)
			addTree(addroot.getLeft());
			
			if(addroot.getRight() != null)
			addTree(addroot.getRight());
		}
	}
	
	//addMany, implement by repeatedly calling the simpler add method
	public void addMany(String... elements)
	{
		for (String i : elements)
			add(i);	
	}
	
	public static StringTreeBag union(StringTreeBag b1, StringTreeBag b2)
	{
		StringTreeBag answer = new StringTreeBag();
		answer.addTree(b1.root);
		answer.addTree(b2.root);
		return answer;
	}
	
	public void print (int depth)
	{
		int i;
		
		for (i = 1; i <= depth; i++)
			System.out.print("  ");
		System.out.println(root.getData());  
		
		if (left != null)
		{
			cursor = cursor.getLeft(); 
			left.print(depth+1);
		}
		else if (right != null)
		{
			for (i = 1; i <= depth+1; i++)
				System.out.print("  ");
			System.out.println("--");	
		}		
	}
	
	public void preorderPrint()
	{
		System.out.println(root.getData()); 
		if (left != null)
			left.preorderPrint();
		if (right != null)
			right.preorderPrint();
	}	
	
	public void inorderPrint()
	{
		if (left != null)
			left.inorderPrint();
		System.out.println(root.getData());
		if (right != null)
			right.inorderPrint();
	}
	
	public void postorderPrint()
	{
		if (left != null)
			left.postorderPrint();
		if (right != null)
			right.postorderPrint();
		System.out.println(root.getData());
	}
	
	public void printTree(int depth)
	{root.print(depth);}
	
	public void prePrint()
	{root.preorderPrint();}
	
	public void inPrint()
	{root.inorderPrint();}
	
	public void postPrint()
	{root.postorderPrint();}
}
