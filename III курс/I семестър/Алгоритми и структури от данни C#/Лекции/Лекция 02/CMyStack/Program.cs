using System;
using System.Collections;

namespace CMyStack
{
    class Program
    {
        static void Main(string[] args)
        {
            MyIntStack intStack = new MyIntStack();
            intStack.Push(1);
            intStack.Push(2);
            intStack.Push(3);

            while (intStack.Size > 0)
            {
                int val = intStack.Pop();
                Console.WriteLine(val);
            }

            MyStack<string> strStack = new MyStack<string>();

            strStack.Push("Plovdiv");
            strStack.Push("Sofia");
            strStack.Push("Varna");
            while (strStack.Size > 0)
            {
                string val = strStack.Pop();
                Console.WriteLine(val);
            }

        }
    }
}
