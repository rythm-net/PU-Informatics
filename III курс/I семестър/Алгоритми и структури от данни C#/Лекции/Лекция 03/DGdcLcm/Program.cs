using System;
using System.Collections.Generic;

namespace DGdcLcm
{

    class Program
    {
        // Geatest Common Divider
        // method with division
        static int gcd(int a, int b)
        {
            int c;
            do
            {
                c = a % b;
                a = b;
                b = c;
            } while (c > 0);
            return a;
        }

        //method with substract
        static int gcd2(int a, int b)
        {
            while (a > 0 && b > 0)
            {
                if (a > b)
                    a -= b;
                else
                    b -= a;
            }
            return a > 0 ? a : b;
        }

        // gcd(a,b) = gcd(a, a % b)
        // gcd(a,0) = a
        static int gcd3(int a, int b)
        {
            return b == 0 ? a : gcd3(b, a % b);
        }

        // gcd on n numbers
        // gcd(a1, a2, a3, ..., an) = gcd(gcd(a1, a2, a3, ... an-1), an)
        static int gcdMulti(List<int> numbers)
        {
            if (numbers.Count == 2)
            {
                return gcd(numbers[0], numbers[1]);
            } else
            {
                int an = numbers[numbers.Count - 1];
                numbers.RemoveAt(numbers.Count - 1);
                return gcd(gcdMulti(numbers), an);
            }
        }

        // Least common multiply
        // lcm(a, b) = (a * b) / gcd(a, b)
        // lcm(a1, a2, a3, ..., an) = lcm(lcm(a1,a2,a3,....,an-1), an)
        static int lcm(int a, int b)
        {
            return a * b / gcd(a, b);
        }

        static void Main(string[] args)
        {
            Console.WriteLine(gcd(20, 15));
            Console.WriteLine(gcd(1254, 3000));
            Console.WriteLine(gcd2(1254, 3000));
            Console.WriteLine(gcd3(1254, 3000));

            Console.WriteLine(gcdMulti(new List<int>() { 24, 36, 9 }));
        }
    }
}
