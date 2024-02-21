using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLinkedList
{
    internal class StringLinkedList
    {
        public StringListItem Root { get; private set; }

        public StringLinkedList()
        {
            Root = null;
        }

        public void Add(StringListItem item)
        {
            if (Root == null)
            {
                Root = item;
                return;
            }
            StringListItem current = Root;
            while (current.Next is not null)
            {
                current = current.Next;
            }
            current.Next = item;
        } 

        public void Remove(string value)
        {
            var current = Root;
            StringListItem previous = null;
            while (current != null)
            {
                if (current.Value == value)
                {
                    if (previous == null)
                    {
                        //This means we found the Root.  Only then previous is null.
                        Root = current.Next;
                    }
                    else
                    {
                        previous.Next = current.Next;
                    }
                }
                previous = current;
                current = current.Next;
            }
        }
    }
}
