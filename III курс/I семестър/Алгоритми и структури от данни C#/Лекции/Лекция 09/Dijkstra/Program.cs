using System;
using System.Collections.Generic;

namespace Dijkstra
{
    internal class Program
    {
        static void addEdge(int[,] matrix, int a, int b, int weight = 1)
        {
            matrix[a, b] = weight;
            matrix[b, a] = weight;
        }
        static void Main(string[] args)
        {
            int n = 9;
            int[,] matrix = new int[n, n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    matrix[i, j] = -1;

            addEdge(matrix, 1, 2, 5);
            addEdge(matrix, 2, 3, 1);
            addEdge(matrix, 2, 4, 1);
            addEdge(matrix, 2, 5, 2);
            addEdge(matrix, 2, 6, 5);
            addEdge(matrix, 3, 4, 3);
            addEdge(matrix, 5, 6, 1);
            addEdge(matrix, 7, 8, 10);

            Dijkstra dijkstra = new Dijkstra(matrix);

            List<int>[] paths = new List<int>[n];
            int a = 3;
            int[] D = dijkstra.FindMinPaths(a, paths);

            for (int i = 0; i < paths.Length; i++)
            {
                Console.Write("Min path from " + a + " to " + i + ": ");
                if (D[i] != int.MaxValue)
                {
                    for (int j = 0; j < paths[i].Count; j++)
                    {
                        Console.Write(paths[i][j]);
                        if (j < paths[i].Count - 1)
                            Console.Write(" -> ");
                    }
                    Console.WriteLine(", Length:" + D[i]);
                }
                else
                {
                    Console.WriteLine("No path found");
                }
            }
        }
    }
}

