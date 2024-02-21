using System;
using System.Collections.Generic;

namespace DNumericSystems
{
    class Program
    {
        static string Dec2OtherBase(long num, int numberBase)
        {
            List<char> result = new List<char>();

            while (num > 0)
            {
                int digit = (int)(num % numberBase);
                result.Add(digit <= 9 ? (char)('0' + digit) : (char)('A' + digit - 10));
                num = num / numberBase;
            }
            result.Reverse();
            return new string(result.ToArray());
        }

        static long OtherBase2Dec(string num, int numberBase)
        {
            long result = 0;
            foreach (char ch in num)
            {
                int digit = ch <= '9' ? ch - '0' : ch - 'A' + 10;
                result = result * numberBase + digit;
            }
            return result;
        }

        static string OneBaseToOtherBase(string num, int fromBase, int toBase)
        {
            return Dec2OtherBase(OtherBase2Dec(num, fromBase), toBase);
        }

        static void Main(string[] args)
        {
            Console.WriteLine($"{Dec2OtherBase(254, 16)}");
            Console.WriteLine($"{OtherBase2Dec("12A7FE", 16)}");

            Console.WriteLine($"{OneBaseToOtherBase("12FE", 16, 2)}");
        }
    }
}
