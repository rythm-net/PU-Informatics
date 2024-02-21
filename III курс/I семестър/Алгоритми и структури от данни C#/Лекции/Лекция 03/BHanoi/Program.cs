using System;

namespace BHanoi
{
    class Program
    {
        static void hanoi(int numDisks, int rod1, int rod2, int rod3)
        {
            if (numDisks == 0)
                return;
            hanoi(numDisks - 1, rod1, rod3, rod2);
            Console.WriteLine($"{rod1} -> {rod2}");
            hanoi(numDisks - 1, rod3, rod2, rod1);
        }
        static void Main(string[] args)
        {
            hanoi(100, 1, 2, 3);
        }
    }
}
