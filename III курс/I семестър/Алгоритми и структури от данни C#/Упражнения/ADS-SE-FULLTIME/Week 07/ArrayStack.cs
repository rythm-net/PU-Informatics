using System;
namespace _07.Week
{
    public class ArrayStack<T>
    {
        private const int INITIAL_CAPACITY = 4;

        private T[] elements;

        public ArrayStack(int capacity = INITIAL_CAPACITY)
        {
            this.elements = new T[capacity];
        }

        public int Count { get; private set; }

        public T Peek { get; private set; }

        private T peek2;

        public T Peek2
        {
            get
            {
                return elements[Count - 1];
            }
        }


        public void Push(T element)
        {
            if (Count == elements.Length)
            {
                Array.Resize(ref elements, Count * 2);
            }

            elements[Count] = element;
            Peek = element;
            Count++;
        }

        public T Pop()
        {
            if (Count == 0)
            {
                throw new InvalidOperationException();
            }

            Count--;
            Peek = elements[Count - 1];
            return elements[Count];
        }
    }
}
