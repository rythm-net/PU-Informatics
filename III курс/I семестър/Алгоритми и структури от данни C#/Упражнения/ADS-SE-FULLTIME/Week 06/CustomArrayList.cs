using System;
namespace _06.Week
{
    public class CustomArrayList
    {
        private object[] arr;

        private static readonly int INITIAL_CAPACITY = 4;

        private int count;

        public int Count
        {
            get
            {
                return count;
            }
        }

        public CustomArrayList()
        {
            arr = new object[INITIAL_CAPACITY];
            count = 0;
        }


        public void Insert(int index, object item)
        {
            if (index > count || index < 0)
            {
                throw new IndexOutOfRangeException("Invalid index");
            }


            object[] extendedArray = arr;

            if (arr.Length == count + 1)
            {
                extendedArray = new object[arr.Length * 2];
            }

            Array.Copy(arr, extendedArray, index);
            count++;
            Array.Copy(arr, index, extendedArray, index + 1, count - index - 1);
            extendedArray[index] = item;
            arr = extendedArray;
        }

        public void Add(object item)
        {
            Insert(count, item);
        }

        public int IndexOf(object item)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                if (item.Equals(arr[i]))
                {
                    return i;
                }
            }

            return -1;
        }

        public bool Contains(object item)
        {
            for (int i = 0; i < arr.Length; i++)
            {
                if (item.Equals(arr[i]))
                {
                    return true;
                }
            }

            return false;
        }

        public object Remove(int index)
        {
            if (index >= count || index < 0)
            {
                throw new IndexOutOfRangeException("Invalid index");
            }

            object item = arr[index];

            Array.Copy(arr, index + 1, arr, index, count - index - 1);
            arr[count - 1] = null;
            count--;

            return item;
        }

        public int Remove(object item)
        {
            int index = IndexOf(item);

            Remove(index);

            return index;
        }


        public object this[int index]
        {
            get
            {
                if (index >= count || index < 0)
                {
                    throw new IndexOutOfRangeException("Invalid index");
                }

                return arr[index];
            }

            set
            {
                if (index >= count || index < 0)
                {
                    throw new IndexOutOfRangeException("Invalid index");
                }

                arr[index] = value;

            }
        }


        public void PrintList()
        {
            Console.WriteLine("----------------------------");
            for (int i = 0; i < count; i++)
            {
                
                Console.WriteLine(arr[i]);
                
            }
            Console.WriteLine("----------------------------");
        }

        void Calculate(int Z)
        {
        }

    }
}
