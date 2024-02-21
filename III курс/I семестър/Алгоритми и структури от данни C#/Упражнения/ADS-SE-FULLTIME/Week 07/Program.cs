using System;

namespace _07.Week
{
    class Program
    {
        static void Main(string[] args)
        {
            //ArrayStack<int> mystack = new ArrayStack<int>();

            //mystack.Push(1);
            //mystack.Push(2);
            //mystack.Push(3);
            //mystack.Push(4);

            //Console.WriteLine("Peek: " + mystack.Peek);

            //Console.WriteLine("Pop: " + mystack.Pop());

            //Console.WriteLine("Peek: " + mystack.Peek);


            LinkedQueue<int> myQueue = new LinkedQueue<int>();

            myQueue.Enqueue(1);
            myQueue.Enqueue(2);
            myQueue.Enqueue(3);
            myQueue.Enqueue(4);

            Console.WriteLine("Head: " + myQueue.Head.Value);
            Console.WriteLine("Dequeue: " + myQueue.Dequeue());
            Console.WriteLine("Head: " + myQueue.Head.Value);


            // abccba
        }
    }
}
