using System;
using System.Collections.Generic;

namespace BFS
{
    class Program
    {
        static List<int>? BFSMinPath(int a, int b, int[,] matrix)
        {
            int n = matrix.GetLength(0);
            bool[] used = new bool[n];
            Queue<int> q = new Queue<int>();

            // prev[n] = predecessor of n
            int[] prev = new int[n];
            Array.Fill(prev, -1);

            q.Enqueue(a);
            used[a] = true;
            while (q.Count > 0)
            {
                int p = q.Dequeue();
                for (int i = 0; i < n; i++)
                    if (matrix[p, i] == 1 && !used[i])
                    {
                        used[i] = true;
                        q.Enqueue(i);
                        prev[i] = p;

                        if (i == b)
                        {
                            // create path
                            List<int> path = new List<int>();

                            int k = b;
                            while (k != a)
                            {
                                path.Add(k);
                                k = prev[k];
                            }
                            path.Add(a);

                            // reverse the path
                            path.Reverse();
                            return path;
                        }
                    }
            }
            return null;
        }
        static void addEdge(int[,] matrix, int a, int b, int weight = 1)
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

            List<int>? path = BFSMinPath(3, 7, matrix);

            if (path == null)
            {
                Console.WriteLine("No path found");
            }
            else
            {
                foreach (int node in path)
                    Console.Write(node + "-");
                Console.WriteLine();
            }

        }
    }
}
