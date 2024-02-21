using System;

namespace CValRefInOut
{
    class Program
    {
        static void M1(int n)
        {
            n = n * 2;
        }

        static void M2(int[] arr)
        {
            arr[0] = arr[0] * 2;
        }

        static void M3(ref int n)
        {
            n = n * 2;
        }

        static void M4(in int n)
        {
            // cannot be modified. its readonly
            //n = 10;

        }

        static void M5(out int n)
        {
            n = 100;
        }

        static void Main(string[] args)
        {
            int num = 10;
            Console.WriteLine($"Num is {num}");
            M1(num);
            Console.WriteLine($"Num is {num}");
            int[] a = new int[1];
            a[0] = 10;
            Console.WriteLine($"Num is {a[0]}");
            // arrays are send by reference
            M2(a);
            Console.WriteLine($"Num is {a[0]}");
            int num1 = 10;
            Console.WriteLine($"Num is {num1}");
            M3(ref num1);
            Console.WriteLine($"Num is {num1}");

            // create new variable result which will be assigned by M5
            M5(out int result);
            Console.WriteLine(result);

        }
    }
}
