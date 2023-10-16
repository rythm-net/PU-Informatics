using DelegatesAndLambdasSample.Delegates;
using System;

namespace DelegatesAndLambdasSample
{
    class Program
    {
        static void MyMethod()
        {
            Console.WriteLine("\"My Method\" was just called!");
        }

        static int Sum(int a, int b)
        {
            return a + b;
        }

        static int Multiply(int a, int b)
        {
            return a * b;
        }

        static void Main(string[] args)
        {
            //VoidDelegate dlg = new VoidDelegate(MyMethod);
            //dlg();
            BinaryOperationDelegate dlg = new BinaryOperationDelegate(Multiply);
            int c = dlg(5, 10);
            Console.WriteLine(c);

            Console.ReadKey(true);
        }
    }
}
