using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DDoublyLInkedList
{
    internal class DblLinkedListItem<T> 
    {
        public T Value { get; set; }

        public DblLinkedListItem<T> Previous;
        public DblLinkedListItem<T> Next;

        public void RemoveFromList()
        {
            if (Next is not null)
            {
                Next.Previous = Previous;
            }
            if (Previous is not null)
            {
                Previous.Next = Next;
            }
        }
    }
}
