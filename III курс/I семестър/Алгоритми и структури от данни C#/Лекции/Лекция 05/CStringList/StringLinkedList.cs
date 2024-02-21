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
        private StringListItem Last { get; set; }

        public StringLinkedList()
        {
            Root = null;
            Last = null;
        }

        public void Add(StringListItem item)
        {
            if (Root == null)
            {
                Root = item;
                Last = item;
                return;
            }
            //Slow: we need to traverse the whole list
            //StringListItem current = Root;
            //while (current.Next is not null)
            //{
            //    current = current.Next;
            //}
            //current.Next = item;
            
            //Fast: we use the last
            Last.Next = item;
            Last = item;
        }
        
        public void Add (string value)
        {
            Add(new StringListItem(value));
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

        private StringListItem WalkToIndex(int index)
        {
            var current = Root;
            int currentIndex = 0;
            while (current != null && currentIndex < index)
            {
                currentIndex++;
                current = current.Next;
            }
            return current;
        }

        public string this[int index]
        {
            get
            {
                return WalkToIndex(index)?.Value;
            }
            set
            {
                var item = WalkToIndex(index);
                if (item is not null) item.Value = value;
            }
        }
    }
}
