package data_structures;

import java.util.function.Consumer;

public class ConsumerImplementation<T> implements Consumer<T>
{
	@Override
	public void accept(T t)
	{
		System.out.println("Pass");
		System.out.println(t);
	}
}
