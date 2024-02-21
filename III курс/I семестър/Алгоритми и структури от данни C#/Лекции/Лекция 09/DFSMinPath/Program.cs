using System;

namespace DFSMinPath
{
    class Program
    {
        static void addEdge(int[,] matrix, int a, int b, int weight=1)
        {
            matrix[a, b] = weight;
            matrix[b, a] = weight;
        }
        static void Main(string[] args)
        {
            int n = 12;
            int[,] matrix = new int[n, n];
            addEdge(matrix, 1, 2);
            addEdge(matrix, 2, 3);
            addEdge(matrix, 2, 5);
            addEdge(matrix, 2, 6);
            addEdge(matrix, 3, 4);
            addEdge(matrix, 4, 8);
            addEdge(matrix, 5, 7);
            addEdge(matrix, 5, 8);
            addEdge(matrix, 6, 7);
            addEdge(matrix, 7, 9);
            addEdge(matrix, 8, 9);
            addEdge(matrix, 10, 11);

            DFS dfs = new DFS(matrix);

            List<int>? path = dfs.FindMinPath(3, 7);

            if (path == null)
            {
                Console.WriteLine("No path found");
            } else
            {
                foreach (int node in path)
                    Console.Write(node + "-");
                Console.WriteLine();
            }
        }
    }
}