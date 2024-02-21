using System;
namespace _06.Week
{
    public class LinkedListNode<T>
    {
        private T element;

        public T Element
        {
            get { return this.element; }
            set { this.element = value; }
        }

        private LinkedListNode<T> next;
        public LinkedListNode<T> Next
        {
            get { return this.next; }
            set { this.next = value; }
        }

        public LinkedListNode(T element)
        {
            this.element = element;
            next = null;
        }

        public LinkedListNode(T element, LinkedListNode<T> prevLinkedListNode)
        {
            this.element = element;
            this.next = prevLinkedListNode.next;
            prevLinkedListNode.next = this;
        }

    }


    public class LinkedList<T>
    {
        private LinkedListNode<T> head;
        private LinkedListNode<T> tail;


        private int count;
        public int Count
        {
            get { return count; }
            private set { count = value; }
        }

        public LinkedList()
        {
            head = null;
            tail = null;
            count = 0;
        }

        public void Add(T item)
        {
            if (head == null)
            {
                LinkedListNode<T> newNode = new LinkedListNode<T>(item);
                head = newNode;
                tail = newNode;
            }
            else
            {
                LinkedListNode<T> newNode = new LinkedListNode<T>(item, tail);
                tail = newNode;
            }

            count++;
        }

        public int IndexOf(T item)
        {
            LinkedListNode<T> current = head;
            int index = 0;

            while(current != null)
            {
                if (current.Element.Equals(item))
                {
                    return index;
                }

                index++;
                current = current.Next;
            }
            return -1;
        }

        // 0, 1, 2, 3, 4, 5

        public T RemoveAt(int index)
        {
            T item = default(T);
            LinkedListNode<T> current = head;
            LinkedListNode<T> previous = null;
            int i = 0;

            while(current != null)
            {
                if (index == i)
                {
                    item = current.Element;
                    previous.Next = current.Next;
                    break;
                }

                i++;
                previous = current;
                current = current.Next;
            }

            return item;
        }

        public int Remove(T item)
        {
            int index = 0;
            LinkedListNode<T> current = head;

            while(current != null)
            {
                if (current.Element.Equals(item))
                {
                    RemoveAt(index);
                    return index;
                }

                index++;
                current = current.Next;
            }

            return -1;
        }



    }
}
