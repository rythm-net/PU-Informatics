using System;

namespace DFS
{
    class Program
    {
        static void DFS(int node, int[,] matrix, bool[] used)
        {
            int n = matrix.GetLength(0);
            Console.Write(node + " ");
            used[node] = true;
            for (int i = 0; i < n; i++)
                if (matrix[node, i] == 1 && !used[i])
                {
                    DFS(i, matrix, used);
                }
        }
        static void Main(string[] args)
        {
            int n = 10;
            int[,] matrix = new int[n, n];
            matrix[1, 5] = 1;
            matrix[3, 5] = 1;
            matrix[2, 5] = 1;
            matrix[3, 4] = 1;
            matrix[2, 4] = 1;
            matrix[2, 6] = 1;
            matrix[2, 7] = 1;
            matrix[2, 8] = 1;
            matrix[8, 9] = 1;
            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++)
                    matrix[j, i] = matrix[i, j];

            bool[] used = new bool[n];
            DFS(1, matrix, used);
        }
    }
}
