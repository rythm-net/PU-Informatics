using System;
using System.Collections.Generic;

namespace _10.Week
{
    class Program
    {
        static void Main(string[] args)
        {
            int INF = int.MaxValue;
            int[,] graph = new int[,] {
                { INF, 2, INF, 6, INF },
                { 2, INF, 3, 8, 5 },
                { INF, 3, INF, INF, 7 },
                { 6, 8, INF, INF, 9 },
                { INF, 5, 7, 9, INF }};


            Graph graphInstance = new Graph(graph);
            graphInstance.Dijkstra(0);
            graphInstance.Prim();
            graphInstance.Kruskal();



            Dictionary<String, int> notes = new Dictionary<string, int>();
            notes["Ivan"] = 5;
            notes["Ivan"] = 6;
            notes["Dragan"] = 6;


            HashSet<int> set = new HashSet<int>();
            set.Add(5);

        }
    }
}
