using System;
using System.Collections.Generic;
using System.Text;

namespace Queues
{
    class CircularArrayQueue<T> : IQueue<T>
    {
        private T[] data = new T[5];

        private int front = 0;
        private int rear = -1;

        private int count = 0;

        public int Count
        {
            get
            {
                return count;
            }
        }
        public void Enqueue(T value)
        {
            // check if full array
            // two options: throw exception with memory overflow or
            // grow the underlying array
            if (Count == data.Length)
                throw new InvalidOperationException("Memory overflow");

            rear++;
            // if reached the end 
            if (rear == data.Length)
                rear = 0;
            data[rear] = value;
            count++;
        }

        public T Peek()
        {
            if (Count == 0)
                throw new InvalidOperationException("Queue is empty");
            return data[front];
        }

        public T Dequeue()
        {
            T value = Peek();
            front++;
            if (front == data.Length)
                front = 0;
            count--;
            return value;
        }

        public void Clear()
        {
            front = 0;
            rear = -1;
            count = 0;
        }



    }
}
