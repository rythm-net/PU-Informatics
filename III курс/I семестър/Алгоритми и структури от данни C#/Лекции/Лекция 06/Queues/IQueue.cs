using System;
using System.Collections.Generic;
using System.Text;

namespace Queues
{
    interface IQueue<T>
    {
        void Enqueue(T value);
        T Dequeue();
        T Peek();
        void Clear();
        int Count { get; }
    }
}
