using System;
using System.Collections.Generic;

namespace Other
{
    class Program
    {
        //####################################################################################
        // Задача за лабиринта
        static char[,] lab =
        {
                {' ', ' ', ' ', '*', ' ', ' ', ' '},
                {'*', '*', ' ', '*', ' ', '*', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', '*', '*', '*', '*', '*', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', 'е'},
        };

        static char[] path = new char[lab.GetLength(0) * lab.GetLength(1)];
        static int position = 0;

        static void FindPath(int row, int col, char direction)
        {
            if ((col < 0) || (row < 0) || (col >= lab.GetLength(1)) || (row >= lab.GetLength(0)))
            {
                // We are out of the labyrinth
                return;
            }

            // Append the direction to the path
            path[position] = direction;
            position++;

            // Check if we have found the exit
            if (lab[row, col] == 'е')
            {
                PrintPath(path, 1, position - 1);
            }

            if (lab[row, col] == ' ')
            {
                // The current cell is free. Mark it as visited
                lab[row, col] = 's';

                // Invoke recursion to explore all possible directions
                FindPath(row, col - 1, 'L'); // left
                FindPath(row - 1, col, 'U'); // up
                FindPath(row, col + 1, 'R'); // right
                FindPath(row + 1, col, 'D'); // down          

                // Mark back the current cell as free
                lab[row, col] = ' ';
            }

            // Remove the direction from the path
            position--;
        }

        static void PrintPath(char[] path, int startPos, int endPos)
        {
            Console.Write("Found path to the exit: ");

            for (int pos = startPos; pos <= endPos; pos++)
            {
                Console.Write(path[pos]);
            }

            Console.WriteLine();
        }

        //####################################################################################
        // Пермутации
        private static void Permute(string str, int l, int r)
        {
            if (l == r)
                Console.WriteLine(str);
            else
            {
                for (int i = l; i <= r; i++)
                {
                    str = Swap(str, l, i);
                    Permute(str, l + 1, r);
                    str = Swap(str, l, i);
                }
            }
        }

        public static string Swap(string a, int i, int j)
        {
            char temp;
            char[] charArray = a.ToCharArray();
            temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            string s = new string(charArray);
            return s;
        }

        //####################################################################################
        // Ханойски кули
        private static void SolveTowers(int n, char startPeg, char endPeg, char tempPeg)
        {
            if (n > 0)
            {
                SolveTowers(n - 1, startPeg, tempPeg, endPeg);
                Console.WriteLine("Move disk from " + startPeg + ' ' + endPeg);
                SolveTowers(n - 1, tempPeg, endPeg, startPeg);

            }
        }

        //####################################################################################
        // Умножение на дълги цели числа, представени с масив от цифрите им в десетична бройна система.

        // Multiplies str1 and str2, and prints result.
        static int[] Multiply(int[] num1, int[] num2)
        {
            int len1 = num1.Length;
            int len2 = num2.Length;

            if (len1 == 0 || len2 == 0)
            {
                return new int[0];
            }

            // will keep the result number in vector
            // in reverse order
            int[] result = new int[len1 + len2];

            // Below two indexes are used to
            // find positions in result.
            int i_n1 = 0;
            int i_n2 = 0;
            int i;

            // Go from right to left in num1
            for (i = len1 - 1; i >= 0; i--)
            {
                int carry = 0;
                int n1 = num1[i];

                // To shift position to left after every
                // multipliccharAtion of a digit in num2
                i_n2 = 0;

                // Go from right to left in num2            
                for (int j = len2 - 1; j >= 0; j--)
                {
                    // Take current digit of second number
                    int n2 = num2[j];

                    // Multiply with current digit of first number
                    // and add result to previously stored result
                    // charAt current position.
                    int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

                    // Carry for next itercharAtion
                    carry = sum / 10;

                    // Store result
                    result[i_n1 + i_n2] = sum % 10;

                    i_n2++;
                }

                // store carry in next cell
                if (carry > 0)
                {
                    result[i_n1 + i_n2] += carry;
                }

                // To shift position to left after every
                // multipliccharAtion of a digit in num1.
                i_n1++;
            }

            Array.Reverse(result);

            return result;
        }

        //####################################################################################
        // g(x): g(0)=1, g(1)=0, g(2n)=g(n)+1, g(2n+1)=2g(n - 1)g(n)+g(n+1), n &gt; 0. За въведено x да се намери g(x).
        static int g(int x)
        {
            if (x == 0)
            {
                return 1;
            }

            if (x == 1)
            {
                return 0;
            }

            int n = x / 2;

            if (x % 2 == 0)
            {
                return g(n) + 1;
            }
            else
            {
                return 2 * g(n - 1) * g(n) + g(n + 1);
            }
        }

        //####################################################################################
        // Даден е ориентиран граф без ориентиран цикъл с върхове, в които е записана целочислена стойност. Да се
        // преизчислят стойностите във всички върхове по следният начин: Ако на един връх предходника е с отрицателна
        // стойност, то тя се добавя към стойността на върха.Ако един връх се преизчисли и стойността му стане
        // отрицателна, това трябва да повлияе и на неговите наследници.

        class NodeTuple
        {
            public int NodeValue { get; set; }
            public int ValueToAdd { get; set; }
        }

        static int[,] vertices = new int[,] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        static int[] nodeValues = new int[] { -6, -3, 2, -9, 1, 9, -5, 1, 9 };


        static void TraverseBFSExtended(int node)
        {
            bool[] visited = new bool[vertices.GetLength(0)];

            Queue<NodeTuple> queue = new Queue<NodeTuple>();
            queue.Enqueue(new NodeTuple() { NodeValue = 0, ValueToAdd = 0 });

            visited[node] = true;

            while (queue.Count > 0)
            {
                NodeTuple nodeTuple = queue.Dequeue();
                int initialValue = nodeValues[nodeTuple.NodeValue];
                bool initialVisited = visited[nodeTuple.NodeValue];


                visited[nodeTuple.NodeValue] = true;
                nodeValues[nodeTuple.NodeValue] = nodeValues[nodeTuple.NodeValue] + nodeTuple.ValueToAdd;

                // Successors
                for (int j = 0; j < nodeValues.Length; j++)
                {
                    if (vertices[nodeTuple.NodeValue, j] != 0)
                    {
                        if (nodeValues[nodeTuple.NodeValue] < 0 && (initialValue >= 0 || initialVisited == false))
                        {
                            queue.Enqueue(new NodeTuple() { NodeValue = j, ValueToAdd = nodeValues[nodeTuple.NodeValue] });
                        }
                        else
                        {
                            queue.Enqueue(new NodeTuple() { NodeValue = j, ValueToAdd = 0 });
                        }
                    }
                }
            }
        }


        static void Main(string[] args)
        {
            /* // Hanoi towers
           char startPeg = 'A'; // start tower in output
           char endPeg = 'C'; // end tower in output
           char tempPeg = 'B'; // temporary tower in output
           int totalDisks = 3; // number of disks
           SolveTowers(totalDisks, startPeg, endPeg, tempPeg);
           */

            /* // combinations // https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
             String str = "ABC"; 
             int n = str.Length; 
             permute(str, 0, n-1); 
             */


            /* // Labirinth // https://introprogramming.info/intro-csharp-book/read-online/glava10-rekursia/
             FindPath(0, 0, 'S');
             */
            FindPath(0, 0, 'S');


            /*
            // MultiplyDigitArrays
            int[] leftArray = { 1, 2, 3, 4, 5 };
            int[] rightArray = { 6, 7, 8, 9 };
            int[] productArray = Multiply(leftArray, rightArray);

            for (int i = 0; i < productArray.Length; i++)
            {
                Console.Write(productArray[i] + " ");
            }
            */

            /*
            // g(x): g(0)=1, g(1)=0, g(2n)=g(n)+1, g(2n+1)=2g(n - 1)g(n)+g(n+1), n &gt; 0. За въведено x да се намери g(x).
            g(5);
             */

            /*
            //####################################################################################
            // Даден е ориентиран граф без ориентиран цикъл с върхове, в които е записана целочислена стойност. Да се
            // преизчислят стойностите във всички върхове по следният начин: Ако на един връх предходника е с отрицателна
            // стойност, то тя се добавя към стойността на върха.Ако един връх се преизчисли и стойността му стане
            // отрицателна, това трябва да повлияе и на неговите наследници.

            TraverseBFSExtended();
             */

            HashTable<string, int> table = new HashTable<string, int>();
            table.Add("One", 1);
            table.Add("Two", 2);
            table.Add("Three", 3);

            Console.WriteLine(table.Find("One"));
            Console.WriteLine(table.Find("Two"));
            Console.WriteLine(table.Find("Three"));

        }
    }
}
