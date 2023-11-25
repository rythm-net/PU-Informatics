package data_structures;

public interface CustomList<T>
{
	// всички методи при `interface`-ите са `public` и `abstract` по шаблон
	T get(int index);
	
	boolean removeAt(int index);
	
	void add(T element);
	
	int size();
	
	default boolean isInBoundary(int index)	{return index-1<this.size();}
}
