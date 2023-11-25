package data_structures;

public class CustomLinkedListNode<T>
{
	private Object value;
	
	private CustomLinkedListNode<T> next;
	
	public CustomLinkedListNode(Object value) 	   {this.value=value;}
	public void setNext(CustomLinkedListNode node) {this.next=node;}
	
	public T getValue()	{return (T)this.value;}
	
	public CustomLinkedListNode getNext() {return this.next;}
	public boolean 				hasNext() {return this.next!=null;}
}
