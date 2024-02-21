using System;

namespace _08.Week
{
    class Program
    {
        static void Main(string[] args)
        {
            Tree<int> tree = new Tree<int>(20,
                                    new Tree<int>(22),
                                    new Tree<int>(8,
                                        new Tree<int>(4),
                                        new Tree<int>(12,
                                            new Tree<int>(10),
                                            new Tree<int>(14))));

            tree.DFS();
        }
    }
}
