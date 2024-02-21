using System;

namespace Stacks
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayStack<int> arrStack = new ArrayStack<int>();

            arrStack.Push(1);
            arrStack.Push(2);
            arrStack.Push(3);
            arrStack.Push(4);
            Console.WriteLine("Count is " + arrStack.Count);
            Console.WriteLine(arrStack.Pop());
            arrStack.Push(5);
            arrStack.Push(6);
            arrStack.Push(7);
            arrStack.Push(8);
            for (int i=0; i<100; i++)
                Console.WriteLine(arrStack.Pop());
        }
    }
}
