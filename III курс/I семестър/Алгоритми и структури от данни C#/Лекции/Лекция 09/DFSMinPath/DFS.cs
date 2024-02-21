using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DFSMinPath
{
    public class DFS
    {
        private int[,] matrix;
        private int n;

        private int target;
        private List<int>? bestPath;

        private List<int> path;
        private bool[] used;

        public DFS(int[,] matrix)
        {
            this.matrix = matrix;
            n = matrix.GetLength(0);
        }

        private void dfs(int node)
        {
            if (node == target)
            {
                if (bestPath == null || path.Count + 1 < bestPath.Count)
                {
                    bestPath = new List<int>(path);
                    bestPath.Add(target);
                }
                return;
            }
            path.Add(node);
            used[node] = true;
            // call recursively for all connected nodes that are not used
            for (int i = 0; i < n; i++)
                if (!used[i] && matrix[node, i] > 0)
                    dfs(i);
            used[node] = false;
            path.RemoveAt(path.Count - 1);
        }

        public List<int>? FindMinPath(int a, int b)
        {
            path = new List<int>();
            target = b;
            bestPath = null;
            used = new bool[n];
            dfs(a);

            return bestPath;
        }
    }
}
