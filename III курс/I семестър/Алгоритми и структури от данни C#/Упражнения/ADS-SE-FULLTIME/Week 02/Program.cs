using System;

namespace Week_2
{
    class Program
    {

        static Random generator = new Random();

        //####################################################################################

        static string ToBinary(int n)
        {
            string binary = "";

            while (n != 0)
            {
                binary += n % 2;
                n = n / 2;
            }

            char[] arr = binary.ToCharArray();
            Array.Reverse(arr);
            return new string(arr);
        }

        //####################################################################################

        static long Num10fromOtherBasis(string num_b, int basis)
        {
            long num10 = 0;
            foreach (char ch in num_b)
                num10 = num10 * basis + (int)(ch >= 'A' ? ch - 'A' + 10 : ch - '0');
            return num10;
        }

        //####################################################################################

        static string Convert10ToBase(int baseNumber, int n)
        {
            string binary = "";

            while (n != 0)
            {
                int rem = n % baseNumber;

                if (rem >= 10)
                {
                    binary += (char)('A' + (rem - 10));
                }
                else
                {
                    binary += n % baseNumber;
                }

                n = n / baseNumber;
            }

            char[] arr = binary.ToCharArray();
            Array.Reverse(arr);
            return new string(arr);
        }

        //####################################################################################

        static int GCDIterative(int a, int b)
        {
            while (a % b != 0)
            {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return b;
        }

        //####################################################################################

        static int GCD2(int a, int b)
        {
            while (a != b)
            {
                if (a > b)
                {
                    a -= b;
                }
                else
                {
                    b -= a;
                }
            }
            return a;
        }

        //####################################################################################

        static int GCDRecursive(int a, int b)
        {
            if (a == 0)
            {
                return b;
            }

            if (b == 0)
            {
                return a;
            }

            if (a > b)
            {
                return GCDRecursive(a % b, b);
            }
            else
            {
                return GCDRecursive(a, b % a);
            }
        }

        //####################################################################################

        static int GetFibNumber(int n)
        {
            if (n == 1 || n == 2)
            {
                return 1;
            }

            return GetFibNumber(n - 1) + GetFibNumber(n - 2);
        }

        //####################################################################################

        static int FactorialRecursive(int n)
        {
            if (n == 0)
            {
                return 1;
            }

            return n * FactorialRecursive(n - 1);
        }

        //####################################################################################

        static void PrintInt(int n)
        {
            if (n > 10)
            {
                return;
            }

            Console.WriteLine(n);
            PrintInt(n + 1);
        }

        //####################################################################################

        static void TransposeMatrix(int[,] matrix)
        {
            for (int i = 1; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < i; j++)
                {
                    int temp = matrix[i, j];
                    matrix[i, j] = matrix[j, i];
                    matrix[j, i] = temp;
                }
            }
        }

        //####################################################################################

        static void GenerateRandomMatrix(int[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    matrix[i, j] = generator.Next(-100, 100);
                }
            }
        }

        //####################################################################################

        static void PrintMatrix(int[,] matrix)
        {
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    Console.Write(matrix[i, j] + " ");
                }
                Console.WriteLine();
            }
        }

        //####################################################################################

        static void Main(string[] args)
        {
            //PrintInt(1);

            Console.WriteLine(GCDRecursive(18, 12));

            //int[,] matrix = new int[5, 4]; // {{1,2 3}, {4, 5 ,6}}

            //GenerateRandomMatrix(matrix);
            //PrintMatrix(matrix);


            //int a = 1;
            //int b = 2;

            //a = a + b; // a = 3; b = 2;
            //b = a - b; // a = 3; b = 1;
            //a = a - b; // a = 2; b = 1;


            /*
            int[] arr1 = { 1, 3, 5, 6, 8};
            int[] arr2 = { 2, 4, 7, 9, 10, 11 };


            int[] arr3 = new int[arr1.Length + arr2.Length];

            int i = 0;
            int j = 0;

            int k = 0;

            while(k < arr3.Length)
            {
                if (i >= arr1.Length)
                {
                    arr3[k] = arr2[j];
                    j++;
                }
                else if (j >= arr2.Length)
                {
                    arr3[k] = arr1[i];
                    i++;
                } else if (arr1[i] < arr2[j])
                {
                    arr3[k] = arr1[i];
                    i++;
                } else
                {
                    arr3[k] = arr2[j];
                    j++;
                }

                k++;
            }


            for (int l = 0; l < arr3.Length; l++)
            {
                Console.WriteLine(arr3[l]);
            }



            //{ 1, 2, 3, 4, 5, 6.... 11}

    */
        }
    }
}
