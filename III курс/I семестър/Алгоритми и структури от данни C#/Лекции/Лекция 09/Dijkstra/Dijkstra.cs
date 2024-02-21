using System;
using System.Collections.Generic;
using System.Text;

namespace Dijkstra
{
	class Dijkstra
	{
		private int[,]? matrix;
		private int n;

		public Dijkstra(int[,] matrix)
		{
			this.matrix = matrix;
			n = matrix.GetLength(0);
		}

		private int[] dijkstra(int a, List<int>[] paths)
		{
			int[] prev = new int[n];
			Array.Fill(prev, -1);
			// initialize d
			int[] D = new int[n];
			for (int i = 0; i < n; i++)
				if (matrix[a, i] >= 0)
				{
					D[i] = matrix[a, i];
					prev[i] = a;
				}
				else
					D[i] = Int32.MaxValue;
			D[a] = 0;
			// initialize T
			HashSet<int> T = new HashSet<int>();
			for (int i = 0; i < n; i++)
				if (i != a)
					T.Add(i);

			while (true)
			{
				bool foundSolution = true;
				// check if we found solution
				foreach (int n in T)
					if (D[n] != Int32.MaxValue)
					{
						foundSolution = false;
						break;
					}
				if (foundSolution) break;

				int minJ = Int32.MaxValue;
				int j = -1;
				foreach (int n in T)
					if (D[n] < minJ)
					{
						minJ = D[n];
						j = n;
					}
				T.Remove(j);
				foreach (int i in T)
				{
					if (matrix[j, i] >= 0)
					{
						if (D[i] > D[j] + matrix[j, i])
						{
							D[i] = D[j] + matrix[j, i];
							prev[i] = j;
						}
					}
				}
			}

			for (int i = 0; i < n; i++)
			{
				paths[i] = new List<int>();
				if (prev[i] == -1) continue;
				int j = i;
				while (j != a)
				{
					paths[i].Add(j);
					j = prev[j];
				}
				paths[i].Add(a);
				paths[i].Reverse();
			}
			return D;
		}


		public int[] FindMinPaths(int a, List<int>[] paths)
		{
			return dijkstra(a, paths);
		}

	}
}
