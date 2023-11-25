package data_structures;

public class CustomLinkedListTest
{
	public static void test() {addNewElementTest();}
	
	private static void addNewElementTest()
	{
		System.out.println("Test 1");
		
		CustomList list=new CustomLinkedList();
		list.add(184);
		list.add(261);
		list.add(377);
		list.add(46);
		list.add(527);
		list.add(88);
		
		list.removeAt(150);

		System.out.println(list.size());
		System.out.println(list.get(0));
	}
}
