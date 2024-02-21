using System;

namespace _06.Week
{
    class Program
    {
        static void Main(string[] args)
        {
            CustomArrayList list = new CustomArrayList();

            list.Add(1);
            list.PrintList();
            list.Add(2);
            list.PrintList();
            list.Add(3);
            list.PrintList();

            Console.WriteLine(list.IndexOf(2));
            Console.WriteLine(list.Contains(3));
            Console.WriteLine(list.IndexOf(4));
        }
    }
}
