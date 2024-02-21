using System;
using System.Collections.Generic;

namespace CPrimes
{
    class Program
    {
        static bool checkPrime(int n)
        {
            for (int i = 2; i <= Math.Sqrt(n); i++)
                if (n % i == 0)
                    return false;
            return true;
        }

        static void printPrimes(List<int> primes)
        {
            foreach (int p in primes)
                Console.Write($"{p}, ");
            Console.WriteLine();
        }

        // generate prime numbers smaller or equal to n
        static List<int> generatePrimes(int n)
        {
            List<int> primes = new List<int>();

            // array with flag if a number is prime
            // numbers[i] == false if number is prime
            // numbers[i] == true if number is not prime
            bool[] numbers = new bool[n + 1];
            numbers[1] = true;
            for (int i = 2; i <= n; i++)
            {
                // check if current number is a prime
                if (!numbers[i])
                {
                    primes.Add(i);
                    for (int j = i * 2; j <= n; j += i)
                        numbers[j] = true;
                }
            }
            return primes;
        }

        // on each number check if it is divided by a previously found primes
        static List<int> generatePrimes2(int n)
        {
            List<int> primes = new List<int>();
            for (int i = 2; i <= n; i++)
            {
                bool isPrime = true;
                for (int j = 0; j < primes.Count; j++)
                {
                    if (primes[j] > Math.Sqrt(i))
                        break;
                    if (i % primes[j] == 0)
                    {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    primes.Add(i);
            }
            return primes;
        }

        static void Main(string[] args)
        {
            Console.WriteLine(checkPrime(7) ? "Prime number" : "Not a prime");
            printPrimes(generatePrimes(501));
            Console.WriteLine();
            printPrimes(generatePrimes2(501));
        }
    }
}
