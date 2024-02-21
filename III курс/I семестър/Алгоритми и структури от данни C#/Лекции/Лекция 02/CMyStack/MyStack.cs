using System;
using System.Collections.Generic;
using System.Text;

namespace CMyStack
{
    class MyStack<T>
    {
        private T[] data = new T[10000];
        private int index = -1;

        public void Push(T value)
        {
            index++;
            if (index >= 10000)
                throw new ArgumentException("Stack is full");
            data[index] = value;
        }

        public T Pop()
        {
            if (index == -1)
                throw new ArgumentException("Stack is empty");
            T result = data[index];
            index--;
            return result;
        }

        public int Size
        {
            get
            {
                return index + 1;
            }
        }
    }
}
