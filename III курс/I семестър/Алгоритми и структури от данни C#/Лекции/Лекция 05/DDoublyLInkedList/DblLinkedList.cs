using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DDoublyLInkedList
{
    internal class DblLinkedList<T>
    {
        public DblLinkedListItem<T> Root { get; private set; }
        public DblLinkedListItem<T> Last { get; private set; }


        public void Add(T value)
        {
            var newItem = new DblLinkedListItem<T>() { Value = value };
            if (Root is null)
            {
                Root = newItem;
                Last = newItem;
                return;
            }
            Last.Next = newItem;
            newItem.Previous = Last;
            Last = newItem;
        }

        private DblLinkedListItem<T> FindFromStart(T value)
        {
            var current = Root;
            while (current != null)
            {
                if (current.Value.Equals (value)) return current;
                current = current.Next;
            }
        }

        public void Remove (T value)
        {
            var itemToRemove = FindFromStart(value);
            if (itemToRemove is null) return;
            
        }
    }
}
