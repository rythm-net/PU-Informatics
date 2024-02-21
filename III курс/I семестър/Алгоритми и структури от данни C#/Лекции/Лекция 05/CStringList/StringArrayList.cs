using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CStringList
{
    internal class StringArrayList
    {
        string[] data = null;
        public int Length { get; private set; } = 0;

        public void Add(string item)
        {
            string[] newData = new string[Length + 1];
            if (data != null)
            {
                Array.Copy(data, newData, data.Length);
            }
            newData[newData.Length - 1] = item;
            data = newData;
            Length = newData.Length;
        }

        public string this[int index]
        {
            get { return data[index]; }
            set { data[index] = value; }
        }
    }
}
