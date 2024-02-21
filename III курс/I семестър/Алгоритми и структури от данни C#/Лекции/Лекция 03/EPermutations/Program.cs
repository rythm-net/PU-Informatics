using System;

namespace EPermutations
{


    class Program
    {
        static void perm(int pos, int[] result, bool[] used)
        {
            if (pos == result.Length)
            {
                foreach (int a in result)
                    Console.Write($"{a}, ");
                Console.WriteLine();
                return;
            }

            for (int i = 1; i <= result.Length; i++)
            {
                if (!used[i - 1])
                {
                    used[i - 1] = true;
                    result[pos] = i;
                    perm(pos + 1, result, used);
                    used[i - 1] = false;
                }
            }
        }
        static void GeneratePermutations(int n)
        {
            int[] result = new int[n];
            bool[] used = new bool[n];

            perm(0, result, used);

        }

        static void Main(string[] args)
        {
            GeneratePermutations(4);
        }
    }
}
