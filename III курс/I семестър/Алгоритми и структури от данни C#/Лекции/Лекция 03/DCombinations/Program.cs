using System;

namespace DCombinations
{
    class Program
    {
        static void comb(int pos, int from, int[] result, int n)
        {
            if (pos == result.Length)
            {
                foreach (int a in result)
                    Console.Write($"{a}, ");
                Console.WriteLine();
                return;
            }

            for (int i = from; i <= n; i++)
            {
                result[pos] = i;
                // if we want to repeat numbers we can use i instead of i+1
                comb(pos + 1, i + 1, result, n);
            }
        }
        static void GenerateCombinations(int n, int k)
        {
            int[] result = new int[k];
            comb(0, 1, result, n);
        }
        static void Main(string[] args)
        {
            GenerateCombinations(4, 3);

        }
    }
}
