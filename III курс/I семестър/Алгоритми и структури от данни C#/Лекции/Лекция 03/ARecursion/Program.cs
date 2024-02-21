using System;

namespace ARecursion
{
    class Program
    {
        // Factoriel: f(n) = f(n-1)*n, f(0) = 1, f(1) = 1
        static int factoriel(int n)
        {
            if (n == 1)
                return n;
            return factoriel(n - 1) * n;
        }

        static int factoriel2(int n)
        {
            int result = 1;
            for (int i = 2; i <= n; i++)
                result *= i;
            return result;
        }

        // f(n) = f(n-1) + f(n-2), f(0)=0, f(1)=1
        // 0, 1, 1, 2, 3, 5, 8
        static int fibonacci(int n)
        {
            if (n <= 1)
                return n;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

        // non recursive
        static int fibonacci2(int n)
        {
            int a = 0;
            int b = 1;
            int c = 1;
            for (int i = 2; i <= n; i++)
            {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }

        static void Main(string[] args)
        {
            Console.WriteLine(factoriel2(5));
            Console.WriteLine(fibonacci2(6));
        }
    }
}
