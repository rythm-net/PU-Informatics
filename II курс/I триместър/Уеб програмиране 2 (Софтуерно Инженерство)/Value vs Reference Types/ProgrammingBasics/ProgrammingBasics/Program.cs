using System;

namespace ProgrammingBasics
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[3];
            arr[0] = 1;
            arr[1] = 2;
            arr[2] = 3;

            int[] arr1 = arr;

            Array.Resize<int>(ref arr, 4);
            arr[3] = 4;

            for (int i = 0; i < arr.Length; i++)
            {
                Console.WriteLine(arr[i]);
            }

            Console.WriteLine("###################");

            for (int i = 0; i < arr1.Length; i++)
            {
                Console.WriteLine(arr1[i]);
            }

            string s1 = "asdfsafd";
            Console.WriteLine(s1[3]);

            Console.ReadKey(true);
        }
    }
}
