using System;
using System.Collections.Generic;

namespace MazeSolver
{
    class Program
    {
        static int[,] maze = new int[,]
        {
            {0, 0, 1, 1, 1, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 1, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {1, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 1, 1, 0, 0, 0, 0, 1, 1}
        };

        static int initialX = 0;
        static int initialY = 9;
        static int finalX = 9;
        static int finalY = 3;

        static int width = maze.GetLength(1);
        static int height = maze.GetLength(0);

        static int[] dx = { 1, 0, -1, 0 };
        static int[] dy = { 0, 1, 0, -1 };

        static bool[,] visited = new bool[height, width];
        static int[,] distance = new int[height, width];
        static int[,] previous = new int[height, width];

        static Queue<int> queue = new Queue<int>();

        static void Main(string[] args)
        {
            int initialState = GetStateNumber(initialX, initialY);
            int finalState = GetStateNumber(finalX, finalY);

            //breadth-first search to find the shortest path
            BFS(initialState);

            //retrieve the shortest path
            List<int> path = RetrievePath(initialState, finalState);

            //prints the shortest path
            Console.WriteLine("Shortest Path:");
            foreach (int state in path)
            {
                int x = state % width;
                int y = state / width;
                Console.WriteLine($"({x}, {y})");
            }
        }

        static void BFS(int initialState)
        {
            queue.Clear();
            visited = new bool[height, width];
            distance = new int[height, width];
            previous = new int[height, width];

            for (int i = 0; i < height; i++)
            {
                for (int j = 0; j < width; j++)
                {
                    distance[i, j] = int.MaxValue;
                    previous[i, j] = -1;
                }
            }

            int initialX = initialState % width;
            int initialY = initialState / width;

            distance[initialY, initialX] = 0;
            visited[initialY, initialX] = true;
            queue.Enqueue(initialState);

            while (queue.Count > 0)
            {
                int currentState = queue.Dequeue();
                int currentX = currentState % width;
                int currentY = currentState / width;

                //checks all adjacent cells
                for (int i = 0; i < 4; i++)
                {
                    int nextX = currentX + dx[i];
                    int nextY = currentY + dy[i];

                    //checks if the next cell is within the maze boundaries
                    if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height)
                    {
                        //checks if the next cell is reachable and has not been visited before
                        if (maze[nextY, nextX] == 0 && !visited[nextY, nextX])
                        {
                            int nextState = GetStateNumber(nextX, nextY);
                            visited[nextY, nextX] = true;
                            distance[nextY, nextX] = distance[currentY, currentX] + 1;
                            previous[nextY, nextX] = currentState;
                            queue.Enqueue(nextState);
                        }
                    }
                }
            }
        }

        static List<int> RetrievePath(int initialState, int finalState)
        {
            List<int> path = new List<int>();
            int currentState = finalState;

            while (currentState != initialState)
            {
                path.Add(currentState);
                int currentX = currentState % width;
                int currentY = currentState / width;
                currentState = previous[currentY, currentX];
            }

            path.Add(initialState);
            path.Reverse();
            return path;
        }

        static int GetStateNumber(int x, int y)
        {
            return y * width + x;
        }
    }
}