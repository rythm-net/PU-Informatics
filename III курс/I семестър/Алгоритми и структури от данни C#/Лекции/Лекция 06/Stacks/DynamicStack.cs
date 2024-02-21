using System;
using System.Collections.Generic;
using System.Text;

namespace Stacks
{
    class DynamicStack<T> : IStack<T>
    {
        LinkedList<T> data = new LinkedList<T>();

        public int Count
        {
            get
            {
                return data.Count;
            }
        }
        public void Push(T value)
        {
            data.AddLast(value);
        }

        public T Peek()
        {
            if (Count == 0)
                throw new InvalidOperationException("Stack is empty!");
            return data.Last.Value;
        }

        public T Pop()
        {
            T value = Peek();
            data.RemoveLast();
            return value;
        }

        public void Clear()
        {
            data.Clear();
        }
    }
}
