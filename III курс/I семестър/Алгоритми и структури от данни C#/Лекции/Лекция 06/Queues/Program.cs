using System;
using System.Collections.Generic;

namespace Queues
{
    class Program
    {
        static void Main(string[] args)
        {
            IQueue<int> arrQueue = new CircularArrayQueue<int>();
            arrQueue.Enqueue(1);
            arrQueue.Enqueue(2);
            arrQueue.Enqueue(3);
            arrQueue.Enqueue(4);
            arrQueue.Enqueue(5);
            Console.WriteLine(arrQueue.Dequeue());
            Console.WriteLine(arrQueue.Dequeue());
            Console.WriteLine(arrQueue.Dequeue());

            arrQueue.Enqueue(6);
            arrQueue.Enqueue(7);
            arrQueue.Enqueue(8);
            //            arrQueue.Enqueue(9);
            Console.WriteLine(arrQueue.Dequeue());
            Console.WriteLine(arrQueue.Dequeue());
            Console.WriteLine(arrQueue.Dequeue());
            Console.WriteLine(arrQueue.Dequeue());
            Console.WriteLine(arrQueue.Dequeue());

        }
    }
}
