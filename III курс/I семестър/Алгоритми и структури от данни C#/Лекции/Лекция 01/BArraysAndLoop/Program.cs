using System;

namespace BArraysAndLoop
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] intArray = new int[5];
            intArray[0] = 1;
            intArray[1] = 2;

            // new int[] is not required when initializing with data
            int[] intArray1 = new int[] { 1, 2, 3, 4, 5 };

            // loop with index
            for(int i=0; i<intArray1.Length;i++)
            {
                Console.Write($"{intArray1[i]} ");
            }
            //foreach loop
            foreach(int element in intArray1)
            {
                Console.Write($"{element} ");
            }
            Console.WriteLine();

            while (true)
            {

            }

            do
            {

            } while (true);

            // 2d array
            int[,] arr2d = new int[5, 5];
            arr2d[0, 0] = 1;
            arr2d[0, 1] = 2;
            arr2d[0, 2] = 3;
            arr2d[1, 0] = 4;
            arr2d[1, 1] = 5;

            // 3d array
            int[,,] arr3d = new int[5, 5, 10];

            // array of arrays
            int[][] arrOfArr = new int[5][];
            arrOfArr[0] = new int[7];
            arrOfArr[1] = new int[6];

            arrOfArr[0][0] = 1;
            arrOfArr[0][1] = 2;
            arrOfArr[0][2] = 3;
            arrOfArr[1][0] = 4;
            arrOfArr[1][1] = 5;

            Console.WriteLine("Hello World!");
        }
    }
}
