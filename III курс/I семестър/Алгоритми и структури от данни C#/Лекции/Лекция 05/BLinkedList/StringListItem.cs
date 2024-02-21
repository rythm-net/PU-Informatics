using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BLinkedList
{
    internal class StringListItem
    {
        public string Value { get; set; }

        public StringListItem Next { get; set; }

        public StringListItem(string value)
        {
            Value = value;
        }
    }
}
