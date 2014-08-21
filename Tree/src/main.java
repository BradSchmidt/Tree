


public class main {
	public static void main(String[] args)
	{
		
		StringTreeBag bag = new StringTreeBag();
		System.out.println("BAG 1:");
		bag.add("hello");
		bag.add("ear");
		bag.add("leopard");
		bag.add("duck");
		bag.add("island");
		bag.add("noise");
		bag.remove("ear");
		bag.printTree(3);
		System.out.println("POST ORDER PRINT");
		bag.postPrint();
		
		System.out.println("BAG 2:");
		StringTreeBag second = new StringTreeBag();
		second.add("gun");
		second.add("go");
		second.add("lion");
		second.add("blue");
		second.remove("gun");
		second.printTree(3);
		System.out.println("The SIZE of the BAG is: " + second.size());
		System.out.println("INORDER PRINT");
		second.inPrint();
		System.out.println("Adding BAG 1 and BAG 2");
		bag.addAll(second);
		bag.printTree(6);
		System.out.println("The SIZE of the BAG is: " + bag.size());
		

		System.out.println("UNION METHOD");
		StringTreeBag bag3 = new StringTreeBag();
		bag3.add("computer");
		bag3.add("disk");
		bag3.add("monitor");
		bag3.add("keyboard");
		bag3.add("mouse");
		StringTreeBag bag4 = new StringTreeBag();
		bag4.add("muscle");
		bag4.add("bone");
		bag4.add("heart");
		bag4.add("lung");
		StringTreeBag.union(bag3, bag4).printTree(4);

		System.out.println("ADD MANY method");	
		StringTreeBag bag5 = new StringTreeBag();
		bag5.add("apple");
		bag5.add("boy");
		bag5.add("girl");
		bag5.add("axe");
		bag5.addMany("juice", "axe", "zebra", "sun", "cut", "aqua");
		bag5.printTree(5);
		System.out.println("The SIZE of the BAG is: " + bag5.size());
		System.out.println("PREORDER PRINT");
		bag5.prePrint();
	}

}
