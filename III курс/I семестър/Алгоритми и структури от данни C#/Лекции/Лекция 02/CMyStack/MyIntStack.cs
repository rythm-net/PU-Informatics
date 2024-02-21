using System;
using System.Collections.Generic;
using System.Text;

namespace CMyStack
{
    class MyIntStack
    {
        private int[] data = new int[10000];
        private int index = -1;

        public void Push(int value)
        {
            index++;
            if (index >= 10000)
                throw new ArgumentException("Stack is full");
            data[index] = value;
        }

        public int Pop()
        {
            if (index == -1)
                throw new ArgumentException("Stack is empty");
            int result = data[index];
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
