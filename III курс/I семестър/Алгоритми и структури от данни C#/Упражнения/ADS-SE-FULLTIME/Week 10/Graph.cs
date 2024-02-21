using System;
using System.Collections.Generic;

namespace _10.Week
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
            AddEdge(i, j, int.MaxValue);
        }

        public bool HasEdge(int i, int j)
        {
            return vertices[i, j] != int.MaxValue;
        }

        public List<int> GetSuccessors(int i)
        {
            List<int> successors = new List<int>();

            for (int j = 0; j < vertices.GetLength(0); j++)
            {
                if (vertices[i, j] != int.MaxValue)
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

            while (queue.Count > 0)
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


        private int MinDistance(int[] distances, bool[] visited)
        {
            int min = int.MaxValue;
            int minIndex = -1;

            for (int i = 0; i < distances.Length; i++)
            {
                if(!visited[i] && min >= distances[i])
                {
                    min = distances[i];
                    minIndex = i;
                }
            }

            return minIndex;
        }

        // Funtion that implements Dijkstra's 
        // single source shortest path algorithm 
        // for a graph represented using adjacency 
        // matrix representation 
        public void Dijkstra(int src)
        {
            int size = vertices.GetLength(0);


            int[] dist = new int[size]; // The output array. dist[i] 
                                        // will hold the shortest 
                                        // distance from src to i 

            // visited[i] will true if vertex 
            // i is included in shortest path 
            // tree or shortest distance from 
            // src to i is finalized 
            bool[] visited = new bool[size];

            // Initialize all distances as 
            // INFINITE and stpSet[] as false 
            for (int i = 0; i < size; i++)
            {
                dist[i] = int.MaxValue;
                visited[i] = false;
            }

            // Distance of source vertex 
            // from itself is always 0 
            dist[src] = 0;

            // Find shortest path for all vertices 
            for (int count = 0; count < size - 1; count++)
            {
                // Pick the minimum distance vertex 
                // from the set of vertices not yet 
                // processed. u is always equal to 
                // src in first iteration. 
                int currentNode = MinDistance(dist, visited);

                // Mark the picked vertex as processed 
                visited[currentNode] = true;

                // Update dist value of the adjacent 
                // vertices of the picked vertex. 
                for (int v = 0; v < size; v++)

                    // Update dist[v] only if is not in 
                    // visited, there is an edge from u 
                    // to v, and total weight of path 
                    // from src to v through u is smaller 
                    // than current value of dist[v] 
                    if (!visited[v] && vertices[currentNode, v] != int.MaxValue && dist[currentNode] != int.MaxValue && dist[currentNode] + vertices[currentNode, v] < dist[v])
                    {
                        dist[v] = dist[currentNode] + vertices[currentNode, v];
                    }
            }

            // print the constructed distance array 
            PrintDijkstraSolution(dist);
        }


        // A utility function to print 
        // the constructed distance array 
        void PrintDijkstraSolution(int[] dist)
        {
            Console.Write("Vertex \t\t Distance "
                          + "from Source\n");
            for (int i = 0; i < vertices.GetLength(0); i++)
                Console.Write(i + " \t\t " + dist[i] + "\n");
        }

        public void Prim()
        {
            int verticesCount = vertices.GetLength(0);

            int[] parent = new int[verticesCount];
            int[] key = new int[verticesCount];
            bool[] mstSet = new bool[verticesCount];

            for (int i = 0; i < verticesCount; ++i)
            {
                key[i] = int.MaxValue;
                mstSet[i] = false;
            }

            key[0] = 0;
            parent[0] = -1;

            for (int count = 0; count < verticesCount - 1; ++count)
            {
                int u = MinKey(key, mstSet, verticesCount);
                mstSet[u] = true;

                for (int v = 0; v < verticesCount; ++v)
                {
                    if (Convert.ToBoolean(vertices[u, v]) && mstSet[v] == false && vertices[u, v] < key[v])
                    {
                        parent[v] = u;
                        key[v] = vertices[u, v];
                    }
                }
            }

            PrintPrimSolution(parent, vertices);
        }

        private int MinKey(int[] key, bool[] set, int verticesCount)
        {
            int min = int.MaxValue, minIndex = 0;

            for (int v = 0; v < verticesCount; ++v)
            {
                if (set[v] == false && key[v] < min)
                {
                    min = key[v];
                    minIndex = v;
                }
            }

            return minIndex;
        }

        private void PrintPrimSolution(int[] parent, int[,] graph)
        {
            Console.WriteLine("Edge     Weight");
            for (int i = 1; i < graph.GetLength(0); ++i)
            {
                Console.WriteLine("{0} - {1}    {2}", parent[i], i, graph[i, parent[i]]);
            }
        }

        // Finds MST using Kruskal's algorithm
        public void Kruskal()
        {
            int verticesCount = vertices.GetLength(0);
            int[] parent = new int[verticesCount];

            int mincost = 0; // Cost of min MST.

            // Initialize sets of disjoint sets.
            for (int i = 0; i < verticesCount; i++)
            {
                parent[i] = i;
            }

            // Include minimum weight edges one by one
            int edge_count = 0;
            while (edge_count < verticesCount - 1)
            {
                int min = int.MaxValue, a = -1, b = -1;

                for (int i = 0; i < verticesCount; i++)
                {
                    for (int j = 0; j < verticesCount; j++)
                    {
                        if (Find(i, parent) != Find(j, parent) && vertices[i, j] < min)
                        {
                            min = vertices[i, j];
                            a = i;
                            b = j;
                        }
                    }
                }

                Union(a, b, parent);
                Console.Write("Edge {0}:({1}, {2}) cost:{3} \n", edge_count++, a, b, min);
                mincost += min;
            }
            Console.Write("\n Minimum cost= {0} \n", mincost);
        }

        // Find set of vertex i
        int Find(int i, int[] parent)
        {
            while (parent[i] != i)
            {
                i = parent[i];
            }
            return i;
        }

        // Does union of i and j. It returns
        // false if i and j are already in same
        // set.
        void Union(int i, int j, int[] parent)
        {
            int a = Find(i, parent);
            int b = Find(j, parent);
            parent[a] = b;
        }

    }
}
