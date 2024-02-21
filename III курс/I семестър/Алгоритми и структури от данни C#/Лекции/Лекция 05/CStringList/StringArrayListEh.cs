using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CStringList
{
    internal class StringArrayListEh
    {
        string[] data = new string[4];
        public int Length { get; private set; } = 0;

        private void GrowBuffer()
        {
            string[] newData = new string[Length * 2];
            Array.Copy(data, newData, data.Length);
            data = newData;
        }
        public void Add(string item)
        {
            
            if (Length == data.Length)
            {
                GrowBuffer();
            }
            data[Length] = item;
            Length++;
        }

        public string this[int index]
        {
            get { return data[index]; }
            set { data[index] = value; }
        }
    }
}
