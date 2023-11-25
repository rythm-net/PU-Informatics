package data_structures;

public class CustomLinkedList<T> implements CustomList<T>
{
	private CustomLinkedListNode<T> head;
	private CustomLinkedListNode<T> tail;
	
	private int size=0;
	
	@Override
	public T get(int index)	{return (T)this.getNode(index).getValue();}
	
	@Override
	public boolean removeAt(int index)
	{
		if(!this.isInBoundary(index)) {return false;}
		
		// намираме елемента, който ще премахнем
		CustomLinkedListNode nodeElement=this.getNode(index);
		
		// намираме двата съседа на премахнатия елемент
		CustomLinkedListNode nextNode=nodeElement.getNext();
		CustomLinkedListNode prevNode=nodeElement.getPrev();
		
		this.size--;
		
		// премахване на SINGLE елемент
		if(nodeElement.isSingle())
		{
			this.head=null;
			this.tail=null;
			
			return true;
		}
		
		if(nodeElement.isHead())
		{
			this.head=nextNode;
			
			return true;
		}
		if(nodeElement.isTail())
		{
			this.tail=prevNode;
			
			return true;
		}
		if(!nodeElement.hasPrev())
		{
			this.head=nextNode;
		}
		
		prevNode.setNext(nextNode);
		nextNode.setPrev(prevNode);
		
		return true;
	}

	@Override
	public void add(T element)
	{
		// създаваме нов елемент node
		CustomLinkedListNode<T> nextNode=new CustomLinkedListNode<T>(element);
		this.size++;
		
		if(this.tail!=null)
		{
			this.tail.setNext(nextNode);
			nextNode.setPrev(this.tail);
			this.tail=nextNode;
		}
		if(this.head==null)
		{
			this.head=nextNode;
			this.tail=this.head;
		}
	}

	@Override
	public int size() {return this.size;}
	
	private CustomLinkedListNode getNode(int index)
	{
		if(index==0) {return this.head;}
		
		int currentIndex=0;
		CustomLinkedListNode<T> currentNode=this.head;
		
		while(currentNode.hasNext())
		{
			currentNode=currentNode.getNext();
			currentIndex++;
			
			if(currentIndex==index)
				return currentNode;
		}
		
		return null;
	}
	
	private class CustomLinkedListNode<T>
	{
		private Object value;
		
		private CustomLinkedListNode next;
		private CustomLinkedListNode prev;
		
		public CustomLinkedListNode(Object value) {this.value=value;}
		
		public T getValue()	{return (T)this.value;}
		
		public void setNext(CustomLinkedListNode node) {this.next=node;}
		public void setPrev(CustomLinkedListNode node) {this.prev=node;}
		
		public CustomLinkedListNode getNext() {return this.next;}
		public CustomLinkedListNode getPrev() {return this.prev;}
		
		public boolean 				hasNext() {return this.next!=null;}
		public boolean 				hasPrev() {return this.prev!=null;}
		
		public boolean   isHead() {return !this.hasPrev();}
		public boolean   isTail() {return !this.hasNext();}
		public boolean isSingle() {return this.isHead() && this.isTail();}
	}
}
