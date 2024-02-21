using System;
namespace _07.Week
{
    public class QueueNode<T>
    {
        public T Value { get; private set; }

        public QueueNode<T> NextNode { get; set; }
        public QueueNode<T> PrevNode { get; set; }


        public QueueNode(T value, QueueNode<T> prevNode = null)
        {
            this.Value = value;
            this.PrevNode = prevNode;
        }
    }

    public class LinkedQueue<T>
    {
        public int Count { get; private set; }

        public QueueNode<T> Head { get; private set;}
        private QueueNode<T> Tail;

        public void Enqueue(T element)
        {
            if (Count == 0)
            {
                Head = Tail = new QueueNode<T>(element);
            }
            else
            {
                var node = new QueueNode<T>(element, Tail);
                Tail.NextNode = node;
                Tail = node;
            }

            Count++;
        }

        public T Dequeue()
        {
            if (Count == 0)
            {
                throw new InvalidOperationException();
            }
            else
            {
                var removedElement = Head.Value;
                Head = Head.NextNode;


                Count--;
                return removedElement;
            }
        }
    }
}
