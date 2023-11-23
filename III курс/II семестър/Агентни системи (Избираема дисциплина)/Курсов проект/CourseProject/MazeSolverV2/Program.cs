using System;
using System.Collections.Generic;

class MazeSolver
{
    private readonly int numRows;
    private readonly int numCols;
    private const double LearningRate = 0.1;
    private const double DiscountFactor = 0.9;
    private const int NumEpisodes = 1000;

    private int[,] maze;
    private double[,] qTable;

    public MazeSolver(int[,] maze, int numRows, int numCols)
    {
        this.maze = maze;
        this.numRows = numRows;
        this.numCols = numCols;
        qTable = new double[numRows * numCols, 4];
    }

    public void Train()
    {
        for (int episode = 0; episode < NumEpisodes; episode++)
        {
            int state = GetState(0, numCols - 1);     //initial state
            while (state != GetState(numRows - 1, 3)) //continue until reaching the final state
            {
                int action = GetNextAction(state);
                int nextState = GetNextState(state, action);
                double reward = GetReward(nextState);
                UpdateQTable(state, action, nextState, reward);
                state = nextState;
            }
        }
    }

    public List<int> SolveMaze()
    {
        List<int> path = new List<int>();
        int currentState = GetState(0, numCols - 1);      //initial state
        while (currentState != GetState(numRows - 1, 3))  //continue until reaching the final state
        {
            int action = GetBestAction(currentState);
            int nextState = GetNextState(currentState, action);
            path.Add(currentState);
            currentState = nextState;
        }

        path.Add(GetState(numRows - 1, 3)); //final state to the path
        return path;
    }

    private int GetNextAction(int state)
    {
        Random random = new Random();
        if (random.NextDouble() < 0.1) //exploration
            return random.Next(0, 4);

        double maxQValue = qTable[state, 0];
        int bestAction = 0;

        for (int action = 1; action < 4; action++)
        {
            double qValue = qTable[state, action];
            if (qValue > maxQValue)
            {
                maxQValue = qValue;
                bestAction = action;
            }
        }

        return bestAction;
    }

    private int GetNextState(int state, int action)
    {
        int currentX = state / numCols;
        int currentY = state % numCols;

        int nextX = currentX;
        int nextY = currentY;

        if (action == 0) //up
            nextX--;
        else if (action == 1) //down
            nextX++;
        else if (action == 2) //left
            nextY--;
        else if (action == 3) //right
            nextY++;

        if (nextX >= 0 && nextX < numRows && nextY >= 0 && nextY < numCols && maze[nextX, nextY] == 0)
            return GetState(nextX, nextY);
        else
            return state; //stay in the current state if the next state is invalid
    }

    private double GetReward(int state)
    {
        int x = state / numCols;
        int y = state % numCols;

        if (x == numRows - 1 && y == 3)
        {
            return 100; //positive reward for reaching the final state
        }
        else
        {
            return -1; //negative reward for all other states
        }
    }

    private void UpdateQTable(int state, int action, int nextState, double reward)
    {
        double currentQValue = qTable[state, action];
        double maxQValue = GetMaxQValue(nextState);
        double newQValue = currentQValue + LearningRate * (reward + DiscountFactor * maxQValue - currentQValue);
        qTable[state, action] = newQValue;
    }

    private double GetMaxQValue(int state)
    {
        double maxQValue = qTable[state, 0];
        for (int action = 1; action < 4; action++)
        {
            double qValue = qTable[state, action];
            if (qValue > maxQValue)
            {
                maxQValue = qValue;
            }
        }
        return maxQValue;
    }

    private int GetBestAction(int state)
    {
        double maxQValue = qTable[state, 0];
        int bestAction = 0;
        for (int action = 1; action < 4; action++)
        {
            double qValue = qTable[state, action];
            if (qValue > maxQValue)
            {
                maxQValue = qValue;
                bestAction = action;
            }
        }
        return bestAction;
    }

    private int GetState(int x, int y)
    {
        return x * numCols + y;
    }
}

class Program
{
    static void Main(string[] args)
    {
        int[,] maze = new int[,]
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

        int numRows = maze.GetLength(0);
        int numCols = maze.GetLength(1);

        MazeSolver solver = new MazeSolver(maze, numRows, numCols);
        solver.Train();
        List<int> path = solver.SolveMaze();

        if (path.Count > 0)
        {
            Console.WriteLine("Path found:");
            foreach (int state in path)
            {
                int x = state / numCols;
                int y = state % numCols;
                Console.WriteLine($"({x},{y})");
            }
        }
        else
        {
            Console.WriteLine("No path found.");
        }
    }
}