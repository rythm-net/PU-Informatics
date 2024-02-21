using System;

namespace ASearch
{
    class Program
    {
        static int ArrayFindMin(int[] arr)
        {
            // if array is empty return int.MinValue
            if (arr.Length == 0)
                return int.MinValue;

            int minValue = arr[0];
            for (int i = 1; i < arr.Length; i++)
                if (arr[i] < minValue)
                    minValue = arr[i];
            return minValue;
        }

        static int ArrayFindMin(int[,] arr)
        {
            // if array is empty return int.MinValue
            if (arr.Length == 0)
                return int.MinValue;

            int minValue = arr[0, 0];
            for (int row = 0; row < arr.GetLength(0); row++)
                for (int col = 0; col < arr.GetLength(1); col++)
                    if (arr[row, col] < minValue)
                        minValue = arr[row, col];

            return minValue;
        }

        static void Main(string[] args)
        {
            int[] arr = { 100, 20, 5, 30, 10, 500 };
            Console.WriteLine(ArrayFindMin(arr));
            int[,] arr2d = { { 10, 20, 5 }, { 100, 1, 15 }, { 400, 3, 10 } };
            Console.WriteLine(ArrayFindMin(arr2d));
        }
    }
}
