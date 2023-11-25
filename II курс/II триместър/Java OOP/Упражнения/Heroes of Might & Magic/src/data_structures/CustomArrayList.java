package data_structures;

import java.util.Iterator;

public class CustomArrayList<E> implements CustomList<E>, Iterable<E>, Iterator<E>
{
	private Object[] collection;
	private int currentIndex =0;
	private int iteratorCount=0;
	
	private final int INITIAL_LIST_SIZE=4;
	
	public CustomArrayList() {this.collection=new Object[this.INITIAL_LIST_SIZE];}
	
	public void add(E element)
	{	
		if(this.collection.length==(this.currentIndex))	
			this.collection=this.expandArray(this.collection);
		
		this.collection[this.currentIndex++]=element;
	}
	
	public E get(int index)  {return (E)this.collection[index];}
	
	public boolean removeAt(int index)
	{
		if(index-1>this.size())	
			return false;
		
		for(int i=index+1; i<this.collection.length; i++)
		{
			E transferableElement=(E)this.collection[i];
			this.collection[i-1]=transferableElement;
		}
		
		this.currentIndex--;
		return true;
	}
	
	public int size() {return this.currentIndex+1;}

	@Override
	public boolean hasNext() {return this.iteratorCount<this.currentIndex;}
	@Override
	public E 		  next() {return (E)this.collection[this.iteratorCount++];}
	
	@Override
	public Iterator<E> iterator() {return this;}
	
	private Object[] expandArray(Object[] collection)
	{
		Object[] newCollection=new Object[collection.length*2];
		
		for(int i=0; i<collection.length; i++)
			newCollection[i]=collection[i];
		
		return newCollection;
	}
}
