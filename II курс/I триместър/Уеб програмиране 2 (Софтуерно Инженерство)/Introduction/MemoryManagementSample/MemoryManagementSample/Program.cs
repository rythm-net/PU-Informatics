using System;

namespace MemoryManagementSample
{
    class Program
    {
        static int Sum(int a, int b)
        {
            a = a + b;

            return a;
        }

        static void Main(string[] args)
        {
            int a;
            int b;
            //int 32bit
            //0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1
            a = 5;
            b = 10;

            Console.WriteLine(Sum(a, b));

            Console.ReadKey(true);
        }
    }
}
