using System;
namespace _07.Week
{
    public class StackNode<T>
    {
        public StackNode<T> NextNode { get; set; }

        public T Value { get; set; }

        public StackNode(T value, StackNode<T> nextNode = null)
        {
            this.Value = value;
            this.NextNode = nextNode;
        }
    }


    public class LinkedStack<T>
    {

        public int Count { get; private set; }

        public StackNode<T> Peek { get; private set; }


        public void Push(T element)
        {
            Peek = new StackNode<T>(element, Peek);
            Count++;
        }

        public T Pop()
        {
            var removedNode = Peek.Value;
            Peek = Peek.NextNode;
            Count--;

            return removedNode;
        }



    }
}
