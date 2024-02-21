using System;
using System.Collections.Generic;

namespace BFS
{
    class Program
    {
        static void BFS(int startNode, int[,] matrix)
        {
            int n = matrix.GetLength(0);
            bool[] used = new bool[n];
            Queue<int> q = new Queue<int>();

            q.Enqueue(startNode);
            used[startNode] = true;
            Console.Write(startNode + " ");
            while (q.Count > 0)
            {
                int p = q.Dequeue();
                for (int i = 0; i < n; i++)
                    if (matrix[p, i] == 1 && !used[i])
                    {
                        used[i] = true;
                        Console.Write(i + " ");
                        q.Enqueue(i);
                    }
            }
        }
        static void Main(string[] args)
        {
            int n = 10;
            int[,] matrix = new int[n, n];
            matrix[1, 2] = 1;
            matrix[2, 3] = 1;
            matrix[2, 5] = 1;
            matrix[3, 4] = 1;
            matrix[4, 5] = 1;
            matrix[5, 6] = 1;
            matrix[5, 7] = 1;
            matrix[5, 8] = 1;
            matrix[8, 9] = 1;
            for (int i = 0; i < n; i++)
                for (int j = i; j < n; j++)
                    matrix[j, i] = matrix[i, j];

            //for (int i = 0; i < n; i++)
            //{
            //    for (int j = 0; j < n; j++)
            //    {
            //        Console.Write((matrix[i, j]?"1":"0") + " ");
            //    }
            //    Console.WriteLine();
            //}

            BFS(1, matrix);

        }
    }
}
