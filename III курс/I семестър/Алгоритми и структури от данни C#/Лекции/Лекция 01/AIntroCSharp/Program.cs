using System;

namespace MyNamespace
{
    namespace SubNamespace
    {
        class Program
        {
            static void Main(string[] args)
            {
                Console.WriteLine("Hello World!");

                Console.Write("Hello ");
                Console.WriteLine("World");

                string str = Console.ReadLine();
                //converting between string and integer
                int n = Convert.ToInt32(str);
                int n2 = Int32.Parse(str);

                Int32 anumber = 5;
                int anumer2 = 10;

                double doubleVal = 10.5;
                // 128 bit decimal numbers - slow to process
                decimal decimalNum = 1000000000000m;

                double d1 = 0.15 + 0.15;
                double d2 = 0.1 + 0.2;

                if (d1 == d2)
                    Console.WriteLine("Equal");
                else
                    Console.WriteLine("Not equal");

                Console.WriteLine($"Doubles are {d1} and {d2}");

                string s1 = "string";
                string s2 = "string";

                // can compare strings with ==
                if (s1 == s2)
                    Console.WriteLine("Strings are equls");
            }
        }
    }
}
