using System;
using System.Collections.Generic;

namespace _09.Week
{
    public class Graph
    {
        private int[,] vertices;


        public Graph(int[,] vertices)
        {
            this.vertices = vertices;
        }

        public void AddEdge(int i, int j, int value)
        {
            vertices[i, j] = value;
        }

        public void RemvoeEdge(int i, int j)
        {
            AddEdge(i, j, 0);
        }

        public bool HasEdge(int i,int j)
        {
            return vertices[i, j] != 0;
        }

        public List<int> GetSuccessors(int i)
        {
            List<int> successors = new List<int>();

            for (int j = 0; j < vertices.GetLength(0); j++)
            {
                if (vertices[i, j] != 0)
                {
                    successors.Add(j);
                }
            }

            return successors;
        }

        public void TraverseBFS(int node)
        {
            bool[] visited = new bool[vertices.GetLength(0)];
            Queue<int> queue = new Queue<int>();
            queue.Enqueue(node);
            visited[node] = true;

            while(queue.Count > 0)
            {
                int currentNode = queue.Dequeue();
                Console.Write("{0} ", currentNode);

                List<int> successors = GetSuccessors(currentNode);

                foreach (int childNode in successors)
                {
                    if (!visited[childNode])
                    {
                        queue.Enqueue(childNode);
                        visited[childNode] = true;
                    }
                }
            }
        }




    }
}
