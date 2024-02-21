using System;
using System.Collections.Generic;
using System.Text;

namespace Stacks
{
    class ArrayStack<T> : IStack<T>
    {
        private T[] data = new T[5];
        private int top = -1;

        public int Count
        {
            get
            {
                return top + 1;
            }
        }
        public void Push(T value)
        {
            top++;
            // check if we need to grow the underlying data array
            if (top == data.Length)
            {
                // create new arrays with double the size of the old one
                T[] newData = new T[data.Length * 2];
                // copy the old data into the new array
                Array.Copy(data, newData, data.Length);
                data = newData;
            }
            data[top] = value;
        }

        public T Peek()
        {
            if (Count == 0)
                throw new InvalidOperationException("Stack is empty");
            return data[top];
        }

        public T Pop()
        {
            T value = Peek();
            top--;
            return value;
        }

        public void Clear()
        {
            top = -1;
        }
    }
}
