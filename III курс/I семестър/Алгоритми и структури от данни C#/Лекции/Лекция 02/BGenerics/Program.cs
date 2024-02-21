using System;
using System.Collections;
using System.Collections.Generic;

namespace BGenerics
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] intArray = new int[] { 1, 2, 3 };

            ArrayList list = new ArrayList();
            list.Add(1);
            list.Add(2);
            list.Add("3");

            int sum = 0;
            foreach(int n in list)
            {
                sum += n;
            }
            Console.WriteLine($"Sum is {sum}");

            List<int> list2 = new List<int>();
            list2.Add(1);
            list2.Add(2);
            list2.Add(3);

            // list can be randomly accessed with an index
            int nn = list2[10];
        }
    }
}
