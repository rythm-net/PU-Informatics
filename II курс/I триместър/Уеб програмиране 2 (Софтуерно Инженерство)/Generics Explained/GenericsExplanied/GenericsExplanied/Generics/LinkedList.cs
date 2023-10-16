using System;
using System.Collections.Generic;
using System.Text;

namespace GenericsExplanied.Generics
{
    public class LinkedList<T>
    {
        private class Element
        {
            public T Value { get; set; }
            public Element Next { get; set; }
        }

        private Element Root { get; set; }

        public void Add(T item)
        {
            if (Root == null)
            {
                Root = new Element();
                Root.Value = item;

                return;
            }

            Element iterator = Root;
            while (iterator.Next != null)
                iterator = iterator.Next;

            Element nextItem = new Element();
            nextItem.Value = item;

            iterator.Next = nextItem;
        }

        public T GetAt(int index)
        {
            Element iterator = Root;
            for (int i = 0; i < index; i++)
                iterator = iterator.Next;

            return iterator.Value;
        }

        public void Remove(int index)
        {
            if (index == 0)
            {
                Root = Root.Next;
                return;
            }

            Element iteratorPrev = Root;
            Element iteratorDelete = Root.Next;
            for (int i = 1; i < index; i++)
            {
                iteratorPrev = iteratorPrev.Next;
                iteratorDelete = iteratorDelete.Next;
            }

            iteratorPrev.Next = iteratorDelete.Next;
        }

        public int Count()
        {
            int count = 0;

            Element iterator = Root;
            while (iterator != null)
            {
                iterator = iterator.Next;
                count++;
            }

            return count;
        }
    }
}
